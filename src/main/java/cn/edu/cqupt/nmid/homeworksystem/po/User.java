package cn.edu.cqupt.nmid.homeworksystem.po;

public class User {
        private String username;// 用户名
        private String password;// 用户密码
        private String classnum;//班级
        private String email;// 主键
          public User() {

          }

    public User(String username, String password, String classnum, String email) {
        this.username = username;
        this.password = password;
        this.classnum = classnum;
        this.email = email;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String  getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
