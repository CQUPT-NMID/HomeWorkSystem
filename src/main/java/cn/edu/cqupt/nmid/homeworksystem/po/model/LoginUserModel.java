package cn.edu.cqupt.nmid.homeworksystem.po.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 用于登陆的用户
 * @date 2020/3/3 21:15
 */

@ApiModel(description = "用于登陆")
public class LoginUserModel {

    private String email;

    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
