package cn.edu.cqupt.nmid.homeworksystem.po;

/**
 * @author MaYunHao
 * @version 1.0
 * @description  学生
 * @date 2020/2/10 14:59
 */

public class Student extends User {

    private String classnum;

    private String snumber;

    private Integer age;

    public String getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
