package com.demo.sharding.sphere.demo.util;

import cn.hutool.core.date.SystemClock;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Pair;
import cn.hutool.core.lang.id.IdConstants;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @auther: liubiao
 * @date: 2024-11-23
 */
public class LocalSnowflake implements Serializable {
    private static final long serialVersionUID = 1L;
    public static long DEFAULT_TWEPOCH = 1288834974657L;
    public static long DEFAULT_TIME_OFFSET = 2000L;
    private static final long WORKER_ID_BITS = 5L;
    public static final long MAX_WORKER_ID = 31L;
    private static final long DATA_CENTER_ID_BITS = 5L;
    public static final long MAX_DATA_CENTER_ID = 31L;
    private static final long SEQUENCE_BITS = 12L;
    private static final long WORKER_ID_SHIFT = 12L;
    private static final long DATA_CENTER_ID_SHIFT = 17L;
    private static final long TIMESTAMP_LEFT_SHIFT = 22L;
    private static final long SEQUENCE_MASK = 4095L;
    private final long twepoch;
    private final long workerId;
    private final long dataCenterId;
    private final boolean useSystemClock;
    private final long timeOffset;
    private final long randomSequenceLimit;
    private long sequence;
    private long lastTimestamp;


    public LocalSnowflake() {
        this(IdConstants.DEFAULT_WORKER_ID);
    }

    public LocalSnowflake(long workerId) {
        this(workerId, IdConstants.DEFAULT_DATACENTER_ID);
    }

    public LocalSnowflake(long workerId, long dataCenterId) {
        this(workerId, dataCenterId, false);
    }

    public LocalSnowflake(long workerId, long dataCenterId, boolean isUseSystemClock) {
        this((Date)null, workerId, dataCenterId, isUseSystemClock);
    }

    public LocalSnowflake(Date epochDate, long workerId, long dataCenterId, boolean isUseSystemClock) {
        this(epochDate, workerId, dataCenterId, isUseSystemClock, DEFAULT_TIME_OFFSET);
    }

    public LocalSnowflake(Date epochDate, long workerId, long dataCenterId, boolean isUseSystemClock, long timeOffset) {
        this(epochDate, workerId, dataCenterId, isUseSystemClock, timeOffset, 0L);
    }

    public LocalSnowflake(Date epochDate, long workerId, long dataCenterId, boolean isUseSystemClock, long timeOffset, long randomSequenceLimit) {
        this.sequence = 0L;
        this.lastTimestamp = -1L;
        this.twepoch = null != epochDate ? epochDate.getTime() : DEFAULT_TWEPOCH;
        this.workerId = Assert.checkBetween(workerId, 0L, 31L);
        this.dataCenterId = Assert.checkBetween(dataCenterId, 0L, 31L);
        this.useSystemClock = isUseSystemClock;
        this.timeOffset = timeOffset;
        this.randomSequenceLimit = Assert.checkBetween(randomSequenceLimit, 0L, 4095L);
    }

    public long getWorkerId(long id) {
        return id >> 12 & 31L;
    }

    public long getDataCenterId(long id) {
        return id >> 17 & 31L;
    }

    public long getGenerateDateTime(long id) {
        return (id >> 22 & 2199023255551L) + this.twepoch;
    }

    public Pair<Long, Long> getIdScopeByTimestamp(long timestampStart, long timestampEnd) {
        return this.getIdScopeByTimestamp(timestampStart, timestampEnd, true);
    }

    public Pair<Long, Long> getIdScopeByTimestamp(long timestampStart, long timestampEnd, boolean ignoreCenterAndWorker) {
        long startTimeMinId = timestampStart - this.twepoch << 22;
        long endTimeMinId = timestampEnd - this.twepoch << 22;
        if (ignoreCenterAndWorker) {
            long endId = endTimeMinId | 4194303L;
            return Pair.of(startTimeMinId, endId);
        } else {
            long startId = startTimeMinId | this.dataCenterId << 17 | this.workerId << 12;
            long endId = endTimeMinId | this.dataCenterId << 17 | this.workerId << 12 | 4095L;
            return Pair.of(startId, endId);
        }
    }

    public synchronized long nextId() {
        long timestamp = this.genTime();
        if (timestamp < this.lastTimestamp) {
            if (this.lastTimestamp - timestamp >= this.timeOffset) {
                throw new IllegalStateException(StrUtil.format("Clock moved backwards. Refusing to generate id for {}ms", new Object[]{this.lastTimestamp - timestamp}));
            }

            timestamp = this.lastTimestamp;
        }

        if (timestamp == this.lastTimestamp) {
            long sequence = this.sequence + 1L & 4095L;
            if (sequence == 0L) {
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }

            this.sequence = sequence;
        } else if (this.randomSequenceLimit > 1L) {
            this.sequence = RandomUtil.randomLong(this.randomSequenceLimit);
        } else {
            this.sequence = ThreadLocalRandom.current().nextLong(0,2);
        }

        this.lastTimestamp = timestamp;
        return timestamp - this.twepoch << 22 | this.dataCenterId << 17 | this.workerId << 12 | this.sequence;
    }

    public String nextIdStr() {
        return Long.toString(this.nextId());
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp;
        for(timestamp = this.genTime(); timestamp == lastTimestamp; timestamp = this.genTime()) {
        }

        if (timestamp < lastTimestamp) {
            throw new IllegalStateException(StrUtil.format("Clock moved backwards. Refusing to generate id for {}ms", new Object[]{lastTimestamp - timestamp}));
        } else {
            return timestamp;
        }
    }

    private long genTime() {
        return this.useSystemClock ? SystemClock.now() : System.currentTimeMillis();
    }
}
