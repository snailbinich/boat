package com.izhaoyan.bear.web.vo;

/**
 * Created by zhaoyan on 15-5-22.
 */
public class JsonResult {

    public int code;
    public Object data;

    public JsonResult() {
    }

    public JsonResult(int code) {
        this.code = code;
    }

    public JsonResult(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
               "code=" + code +
               ", data=" + data +
               '}';
    }
}
