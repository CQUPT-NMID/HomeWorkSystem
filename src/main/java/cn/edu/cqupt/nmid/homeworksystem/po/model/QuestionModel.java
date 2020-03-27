package cn.edu.cqupt.nmid.homeworksystem.po.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 接收问题请求体数据
 * @date 2020/2/26 20:48
 */

@ApiModel(description = "问题")
public class QuestionModel {

    @ApiModelProperty(value = "标题",required = true)
    private String title;

    @ApiModelProperty(value = "学科id",required = true)
    private Integer subjectId;

    @ApiModelProperty(value = "问题",required = true)
    private String content;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSubject() {
        return subjectId;
    }

    public void setSubject(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
