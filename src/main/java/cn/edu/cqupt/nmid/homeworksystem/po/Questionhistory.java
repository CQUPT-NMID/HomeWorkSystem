package cn.edu.cqupt.nmid.homeworksystem.po;

import java.util.Date;

public class Questionhistory {
    /*
    问题历史id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer uId;

    /**
     * 问题id
     */
    private Integer questionId;

    /**
     * 发布时间
     */
    private Date publishdate;

    /**
     * 收藏
     */
    private Integer collection;

    /**
     * 回答
     */
    private Integer answer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }
}