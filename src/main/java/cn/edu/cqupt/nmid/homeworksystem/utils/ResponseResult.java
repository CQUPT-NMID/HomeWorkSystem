package cn.edu.cqupt.nmid.homeworksystem.utils;


import cn.edu.cqupt.nmid.homeworksystem.enums.Status;

import java.io.Serializable;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 返回数据体
 * @date 2020/2/8 14:04
 */

public class ResponseResult<T> implements Serializable {
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回消息
     */
    private String message;
    /**
     * 返回数据
     */
    private  T data;
    // -------------------------------getter---------------------------------


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }



    private void setResultCode(Status status){
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    private void setData(T data) {
        this.data = data;
    }

    public static ResponseResult success(){
        ResponseResult result = new ResponseResult();
        result.setResultCode(Status.SUCCESS);

        return result;
    }

    public static ResponseResult success(Object data){
        ResponseResult result = new ResponseResult();
        result.setResultCode(Status.SUCCESS);
        result.setData(data);
        return result;
    }

    public static ResponseResult failure(Status status){
        ResponseResult result = new ResponseResult();
        result.setResultCode(status);
        return result;
    }

    public static ResponseResult failure(Status status,Object data){
        ResponseResult result = new ResponseResult();
        result.setResultCode(status);
        result.setData(data);
        return result;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
