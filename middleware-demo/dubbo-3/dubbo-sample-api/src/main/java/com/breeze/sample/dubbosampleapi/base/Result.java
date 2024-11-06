package com.breeze.sample.dubbosampleapi.base;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 定义Api返回结果实体类
 * </p>
 *
 * @param <T> T
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class Result<T> implements Serializable {

    public static final String OPERATION_SUCCESS = "操作成功!";
    public static final String DEF_ERROR_MESSAGE = "系统繁忙，请稍候再试";
    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 500;

    @ApiModelProperty(value = "是否成功")
    private boolean successful = true;

    @ApiModelProperty(value = "消息ID")
    private int code;

    @ApiModelProperty(value = "消息内容")
    private String message;

    @ApiModelProperty(value = "时间戳")
    private long timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(value = "返回数据")
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(value = "额外数据")
    private ConcurrentHashMap extraData;


    public Result(int code, T data, String message, boolean successful) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.successful = successful;
        this.timestamp = System.currentTimeMillis();
    }


    public Result(int code, T data, String message, boolean successful, long timestamp, ConcurrentHashMap extraData) {
        this.successful = successful;
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
        this.data = data;
        this.extraData = extraData;
    }

    public static <E> Result<E> success() {
        return new Result<>(SUCCESS_CODE, null, OPERATION_SUCCESS, true);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS_CODE, data,  OPERATION_SUCCESS, true);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(SUCCESS_CODE, data, message, true);
    }

    public static <T> Result<T> success(String message) {
        return success(message, null);
    }

    public static Result<String> success(int code) {
        return success(code, OPERATION_SUCCESS);
    }

    public static <T> Result<T> success(int code, String message, T data) {
        return new Result<>(code, data, message, true);
    }

    public static Result<String> success(int code, String message) {
        return success(code, message, null);
    }

    public static <T> Result<T> success(int code, T data) {
        return new Result<>(code, data, OPERATION_SUCCESS, true);
    }



    public static <T> Result<T> fail(String msg, Object... args) {
        String message = (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg;
        return new Result<>(FAIL_CODE, null, String.format(message, args), false);
    }

    /**
     * 请求失败消息，根据异常类型，获取不同的提供消息
     *
     * @param throwable 异常
     * @param <E>       E
     * @return RPC调用结果
     */
    public static <E> Result<E> fail(Throwable throwable) {
        return fail(FAIL_CODE, throwable != null ? throwable.getMessage() : DEF_ERROR_MESSAGE);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(FAIL_CODE, null, message, false);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(code, null, message, false);
    }

    public static <T> Result<T> fail(int code, String message, T data) {
        return new Result<>(code, data, message, false);
    }
    
    public <T> Result<T> withExtra(ConcurrentHashMap chainMap){
        this.extraData = chainMap;
        return (Result<T>) this;
    }

    public static <T> Result<T> create(boolean successful, String message){
        return new Result<>(successful ? SUCCESS_CODE : FAIL_CODE, null, message, successful);
    }

    public static <T> Result<T> create(boolean successful, String message, T data){
        return new Result<>(successful ? SUCCESS_CODE : FAIL_CODE, data, message, successful);
    }

    public static <T> Result<T> create(int code, String message){
        return new Result<>(code, null, message, code == SUCCESS_CODE);
    }

    public static <T> Result<T> create(int code, String message, T data){
        return new Result<>(code, data, message, code == SUCCESS_CODE);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
