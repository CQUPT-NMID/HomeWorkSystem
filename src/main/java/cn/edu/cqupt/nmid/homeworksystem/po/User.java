package cn.edu.cqupt.nmid.homeworksystem.po;

/**
 * 用户的公共属性
 */

public class User {

    private Integer id;

    private String email;

    private String username;

    private String password;

    private String avaterurl;

    private String telephone;

    private String academy;

    private Integer role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvaterurl() {
        return avaterurl;
    }

    public void setAvaterurl(String avaterurl) {
        this.avaterurl = avaterurl;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}