package cn.edu.cqupt.nmid.homeworksystem.po;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Homewoks {
    @ApiModelProperty(value = "作业id",required = false,notes = "新增时不传，更新时传")
    private Integer id;

    @ApiModelProperty(value = "作业标题",required = true)
    private String title;

    @ApiModelProperty(value = "课程id",required = true)
    private Integer subclassId;

    @ApiModelProperty(value ="发布时间",required = false,notes = "默认为当前时间")
    private Date publishtime;

    @ApiModelProperty(value = "最后期限",required = true)
    private Date deadline;

    @ApiModelProperty(value = "详细信息",required = true)
    private String info;

    @ApiModelProperty(value = "附件",required = true)
    private String attachment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getSubclassId() {
        return subclassId;
    }

    public void setSubclassId(Integer subclassId) {
        this.subclassId = subclassId;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }
}