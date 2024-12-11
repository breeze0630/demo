package com.demo.sharding.sphere.demo.config;

import cn.hutool.core.convert.Convert;
import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther: liubiao
 * @date: 2024-12-09
 */
public class SecurityContextHolder {
//    private static final TransmittableThreadLocal<Map<String, Object>> THREAD_LOCAL = new TransmittableThreadLocal();
//private static final ThreadLocal<Map<String, Object>> THREAD_LOCAL = new ThreadLocal();
private static final InheritableThreadLocal<Map<String, Object>> THREAD_LOCAL = new InheritableThreadLocal();
    private static final TransmittableThreadLocal<String> THREAD_LOCAL2 = new TransmittableThreadLocal();

    public SecurityContextHolder() {
    }

    public static void set(String key, Object value) {
        Map<String, Object> map = getLocalMap();
        map.put(key, value == null ? "" : value);
    }

    public static void set2( String value) {
        THREAD_LOCAL2.set(value);
    }
    public static String get2() {
        return THREAD_LOCAL2.get();
    }
    public static String get(String key) {
        Map<String, Object> map = getLocalMap();
        return Convert.toStr(map.getOrDefault(key, ""));
    }

    public static <T> T get(String key, Class<T> clazz) {
        Map<String, Object> map = getLocalMap();
        return (T)map.getOrDefault(key, (Object)null);
    }

    public static Map<String, Object> getLocalMap() {
        Map<String, Object> map = (Map)THREAD_LOCAL.get();
        if (map == null) {
            map = new ConcurrentHashMap();
            THREAD_LOCAL.set(map);
        }

        return map;
    }

    public static String getLocal2() {
        String str = (String)THREAD_LOCAL2.get();
        return str;
    }

    public static void setLocalMap(Map<String, Object> threadLocalMap) {
        THREAD_LOCAL.set(threadLocalMap);
    }

    public static Long getUserId() {
        return Convert.toLong(get("user_id"), 0L);
    }

    public static String getUserID() {
        return get("user_id");
    }

    public static void setUserId(String account) {
        set("user_id", account);
    }

    public static String getUserName() {
        return get("username");
    }

    public static void setUserName(String username) {
        set("username", username);
    }

    public static String getNickName() {
        return get("nickname");
    }

    public static void setNickName(String nickName) {
        set("nickname", nickName);
    }

    public static String getCompanyTag() {
        return get("companyTag");
    }

    public static void setCompanyTag(String companyTag) {
        set("companyTag", companyTag);
    }

    public static String getTenantId() {
        return get("tenantId");
    }

    public static void setTenantId(String tenantId) {
        set("tenantId", tenantId);
    }

    public static String getUserKey() {
        return get("user_key");
    }

    public static void setUserKey(String userKey) {
        set("user_key", userKey);
    }

    public static String getUserCode() {
        return get("userCode");
    }

    public static void setUserCode(String userCode) {
        set("userCode", userCode);
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
