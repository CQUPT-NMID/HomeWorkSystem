package cn.edu.cqupt.nmid.homeworksystem.po;

public class User {
        private Integer id;// 用户id
        private String userName;// 用户名
        private String password;// 用户密码
        private String classNum;//班级
        private String email;// 用户邮箱
          public User() {

          }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String  getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
