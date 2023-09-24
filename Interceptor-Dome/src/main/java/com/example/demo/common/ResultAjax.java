package com.example.demo.common;


import lombok.Data;

/**
 * 同一对象
 */
@Data
public class ResultAjax {
    private int code;       //状态码
    private String msg;     //状态码的描述信息
    private Object data;    //返回数据


    /**
     * 返回成功对象
     * @param data
     * @return
     */
    public static ResultAjax success(Object data) {
        ResultAjax resultAjax = new ResultAjax();
        resultAjax.setCode(200);
        resultAjax.setMsg("");
        resultAjax.setData(data);
        return resultAjax;
    }

    public static ResultAjax success(String msg ,Object data) {
        ResultAjax resultAjax = new ResultAjax();
        resultAjax.setCode(200);
        resultAjax.setMsg(msg);
        resultAjax.setData(data);
        return resultAjax;
    }


    public static ResultAjax fail(int code, String msg) {
        ResultAjax resultAjax = new ResultAjax();
        resultAjax.setCode(code);
        resultAjax.setMsg(msg);
        resultAjax.setData(null);
        return resultAjax;
    }


    public static ResultAjax fail(int code, String msg, Object data) {
        ResultAjax resultAjax = new ResultAjax();
        resultAjax.setCode(code);
        resultAjax.setMsg(msg);
        resultAjax.setData(data);
        return resultAjax;
    }

}
