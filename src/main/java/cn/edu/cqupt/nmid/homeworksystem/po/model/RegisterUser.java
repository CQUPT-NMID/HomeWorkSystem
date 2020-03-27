package cn.edu.cqupt.nmid.homeworksystem.po.model;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 用于注册
 * @date 2020/3/13 15:09
 */

public class RegisterUser {

    private String password;
    private String checkCode;
    private Integer role;
    private String email;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
