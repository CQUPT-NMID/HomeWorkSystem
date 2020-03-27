package cn.edu.cqupt.nmid.homeworksystem.enums;

import io.swagger.models.auth.In;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 返回数据体
 * @date 2020/2/8 14:20
 */
public enum  Status {
    // 请求成功
    SUCCESS(200,"成功"),
    //请求失败
    FAISE(400,"失败"),
    //没有权限
    Unauthorized(401,"无权限"),
    //禁止访问
    Forbidden(403,"禁止"),
    //没有找到资源
    NotFound(404,"没找到"),
    //服务器异常
    SysError(500,"服务器异常"),
    //未登录
    NOT_LOGIN(1000,"用户未登录"),
    //用户或用户名错误
    FAULT_PASSWORD(1001,"用户名或密码错误"),
    //参数错误
    PARAM_IS_INVALID(1002,"参数无效"),
    //用户已存在
    USER_EXIST(1003,"用户已存在");
    private Integer code;
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
