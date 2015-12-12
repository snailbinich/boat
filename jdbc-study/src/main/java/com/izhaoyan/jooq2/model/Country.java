package com.izhaoyan.jooq2.model;

/**
 * Created by zhaoyan on 15-11-21.
 */
public class Country {

    private String code;
    private String name;
    private String flag;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
