package com.nupt.dzs.juheapi.model;

import java.util.List;

/**
 * Created by Administrator on 2016/5/21.
 *
 * @version 1.0
 * @copyright by ${COMPANY}
 */
public class JuHeResponse<T> {
    /**
     * 结果码 200 为成功
     */
    private String resultcode;
    /**
     * 错误码
     */
    private String error_code;
    /**
     * 原因
     */
    private String reason;
    /**
     * 数据结果集
     */
    private T result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
