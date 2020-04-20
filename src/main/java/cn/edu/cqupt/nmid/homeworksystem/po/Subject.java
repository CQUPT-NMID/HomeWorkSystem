package cn.edu.cqupt.nmid.homeworksystem.po;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

public class Subject {
    @ApiModelProperty(value = "学科id")
    private Integer id;

    @ApiModelProperty(value = "学科名称")
    private String suname;

    @ApiModelProperty(value = "主管老师id",notes = "目前可以不要")
    private Integer tid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuname() {
        return suname;
    }

    public void setSuname(String suname) {
        this.suname = suname == null ? null : suname.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}