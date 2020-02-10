package cn.edu.cqupt.nmid.homeworksystem.po;

import java.util.Date;

public class Source {
    private Integer id;

    private Integer subclassId;

    private Integer teacherId;

    private String url;

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

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }
}