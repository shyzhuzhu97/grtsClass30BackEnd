package com.edward.mt.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

public class MtResult {
    private int code;
    private String message;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private Map<String, Object> data = new HashMap<>();

    public static MtResult ok() {
        MtResult result = new MtResult();
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    public static MtResult error(String message) {
        MtResult result = new MtResult();
        result.setCode(500);
        result.setMessage(message);
        return result;
    }

    //他是一个普通方法 data("key",value)
    public MtResult data(String key, Object value){
        //往MtResult类里面的map集合里面添加数据
        this.data.put(key, value);
        return this;
    }
    //方法的重载
    public MtResult data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MtResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
