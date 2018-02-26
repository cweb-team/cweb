package com.test.cweb.model.result;

import java.io.Serializable;

/**
 * 统一返回格式
 * @author caiminjie
 * @date 18/2/1
 */
public class ApiResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String msg;

    /**可能用到的跟路径**/
    private String resourceUrl="";
    private String contextUrl="";

    private Object data;

    public ApiResult() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getContextUrl() {
        return contextUrl;
    }

    public void setContextUrl(String contextUrl) {
        this.contextUrl = contextUrl;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void fail(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    /**返回错误格式**/
    public void fail(Integer status) {
        fail(404, "操作失败");
    }

    public void fail(String msg) {
        fail(404, msg);
    }

    public void fail() {
        fail(404);
    }

    /**返回正确格式**/
    public void success(Object data) {
        success(200);
        this.data = data;
    }

    public void success(Integer status) {
        this.status = status;
        this.msg = "操作成功";
    }

    public void success() {
        success(200);
    }

    @Override
    public String toString() {
        return "status: " + String.valueOf(status) + " msg " + msg;
    }
}
