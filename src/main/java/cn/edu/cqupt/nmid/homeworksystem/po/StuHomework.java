package cn.edu.cqupt.nmid.homeworksystem.po;

public class StuHomework {
    private Integer id;

    private Integer stuId;

    private Integer homeworkId;

    private Integer status;

    private Integer grade;

    private String attachurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getAttachurl() {
        return attachurl;
    }

    public void setAttachurl(String attachurl) {
        this.attachurl = attachurl == null ? null : attachurl.trim();
    }
}