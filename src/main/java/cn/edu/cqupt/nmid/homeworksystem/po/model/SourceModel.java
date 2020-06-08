package cn.edu.cqupt.nmid.homeworksystem.po.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/4/14 16:45
 */

public class SourceModel {
    @ApiModelProperty(value = "文件id")
    private Integer id;

    @ApiModelProperty(value = "文件名")
    private String name;

    @ApiModelProperty(value = "文件所在地址")
    private String url;

    @ApiModelProperty(value = "发布时间")
    private Date publishtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }
}
