package cn.edu.cqupt.nmid.homeworksystem.po;

public class Subjectclass {
    private Integer id;

    private Integer subjectId;

    private Integer teacherId;

    private String classcode;

    private String classdate;

    private String classavater;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode == null ? null : classcode.trim();
    }

    public String getClassdate() {
        return classdate;
    }

    public void setClassdate(String classdate) {
        this.classdate = classdate == null ? null : classdate.trim();
    }

    public String getClassavater() {
        return classavater;
    }

    public void setClassavater(String classavater) {
        this.classavater = classavater == null ? null : classavater.trim();
    }
}