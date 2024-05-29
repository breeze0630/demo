package com.example.other.trans.dto;

import cn.hutool.core.util.ObjectUtil;

import java.util.HashMap;


public class TechBankResult extends HashMap<String, Object> {
    public static final String CODE_TAG = "code";
    public static final String MSG_TAG = "msg";
    public static final String DATA_TAG = "data";

    public TechBankResult() {
    }

    public TechBankResult(int code, String msg) {
        super.put("code", code);
        super.put("msg", msg);
    }

    public TechBankResult(int code, String msg, Object data) {
        super.put("code", code);
        super.put("msg", msg);
        if (ObjectUtil.isNotEmpty(data)) {
            super.put("data", data);
        }

    }

    @Override
    public TechBankResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static TechBankResult success() {
        return success("操作成功");
    }

    public static TechBankResult success(Object data) {
        return success("操作成功", data);
    }

    public static TechBankResult success(String msg) {
        return success(msg, (Object)null);
    }

    public static TechBankResult success(String msg, Object data) {
        return new TechBankResult(200, msg, data);
    }

    public static TechBankResult error() {
        return error("操作失败");
    }

    public static TechBankResult error(String msg) {
        return error(msg, (Object)null);
    }

    public static TechBankResult error(String msg, Object data) {
        return new TechBankResult(500, msg, data);
    }

    public static TechBankResult error(int code, String msg) {
        return new TechBankResult(code, msg, (Object)null);
    }

    public static TechBankResult error(int code, String msg, String data) {
        return new TechBankResult(code, msg, data);
    }
}
