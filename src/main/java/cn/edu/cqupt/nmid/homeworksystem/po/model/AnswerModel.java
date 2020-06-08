package cn.edu.cqupt.nmid.homeworksystem.po.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/3/24 17:24
 */

public class AnswerModel {

    @ApiModelProperty(value = "回答人姓名")
    private String name;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "回答id")
    private Integer id;

    @ApiModelProperty(value = "问题id")
    private Integer questionId;

    @ApiModelProperty(value = "是否是老师")
    private Integer role;

    @ApiModelProperty(value = "能否修改")
    private Boolean updateAble;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Boolean getUpdateAble() {
        return updateAble;
    }

    public void setUpdateAble(Boolean updateAble) {
        this.updateAble = updateAble;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
