package cn.edu.cqupt.nmid.homeworksystem.po;

import io.swagger.annotations.ApiModelProperty;

public class Answer {

    @ApiModelProperty(value = "回答id",notes = "更新答案的时候传入")
    private Integer id;

    @ApiModelProperty(value = "回答内容",required = true)
    private String content;

    @ApiModelProperty(value = "问题id",required = true)
    private Integer questionId;

    @ApiModelProperty(value = "用户id",required = false,notes = "服务器可以获取")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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