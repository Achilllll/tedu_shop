package com.tedu.utils;

import java.io.Serializable;
import java.util.Objects;

public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = -4486435782073304717L;

    private Integer state;
    private String message;
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(Integer state) {
        this.state = state;
    }

    public ResponseResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public ResponseResult(Integer state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {        if (this == o) return true;
        if (!(o instanceof ResponseResult)) return false;
        ResponseResult<?> that = (ResponseResult<?>) o;
        return Objects.equals(getState(), that.getState()) &&
                Objects.equals(getMessage(), that.getMessage()) &&
                Objects.equals(getData(), that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getState(), getMessage(), getData());
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
