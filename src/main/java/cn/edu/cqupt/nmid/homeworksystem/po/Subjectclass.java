package cn.edu.cqupt.nmid.homeworksystem.po;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

public class Subjectclass {
    @ApiModelProperty(value = "班级id")
    private Integer id;

    @ApiModelProperty(value = "学科id")
    private Integer subjectId;

    @ApiModelProperty(value = "教师id")
    private Integer teacherId;

    @ApiModelProperty(value = "班级代号")
    private String classcode;

    @ApiModelProperty(value = "班级上课时间")
    private String classdate;

    @ApiModelProperty(value = "班级图标")
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