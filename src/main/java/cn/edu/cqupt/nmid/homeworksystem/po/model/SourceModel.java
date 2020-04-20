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
    private Date publishTime;

}
