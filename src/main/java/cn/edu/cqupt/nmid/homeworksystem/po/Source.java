package cn.edu.cqupt.nmid.homeworksystem.po;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.util.Date;

public class Source {
    @ApiModelProperty(value = "资源id",required = false,notes = "服务器分配，更新时传")
    private Integer id;

    @ApiModelProperty(value = "学科班级id",required = true)
    private Integer subclassId;

    @ApiModelProperty(value = "教师id",required = false,notes = "默认是登陆用户的id")
    private Integer teacherId;

    @ApiModelProperty(value = "资源所在位置",required = true)
    private String url;

    @ApiModelProperty(value = "资源名称",required = true)
    private String name;

    @ApiModelProperty(value = "发布时间",required = false,notes = "服务器设定为当前时间")
    private Date publishtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(Integer subclassId) {
        this.subclassId = subclassId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }
}