package cn.edu.cqupt.nmid.homeworksystem.utils;

import cn.edu.cqupt.nmid.homeworksystem.po.User;

/**
 * @author MaYunHao
 * @version 1.0
 * @description token中的user
 * @date 2020/3/13 14:45
 */


public class TokenUser {

    private String email;
    private Integer id;
    private String name;
    private Integer role;

    public TokenUser(String email, Integer id, String name, Integer role) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public TokenUser(User user) {
        this.email = user.getEmail();
        this.id = user.getId();
        this.name = user.getUsername();
        this.role = user.getRole();
    }


    public TokenUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
