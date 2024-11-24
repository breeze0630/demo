package com.demo.sharding.sphere.demo.util;

import cn.hutool.core.lang.Singleton;
import cn.hutool.core.lang.Snowflake;

/**
 * @auther: liubiao
 * @date: 2024-11-23
 */
public class LocalIdUtil {

    public static LocalSnowflake getSnowflake() {
        return (LocalSnowflake) Singleton.get(LocalSnowflake.class, new Object[0]);
    }
}
