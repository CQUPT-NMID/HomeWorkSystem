package cn.edu.cqupt.nmid.homeworksystem.po;

public class Question {
    private Integer id;

    private String content;

    private Integer stuId;

    private Integer subjectId;

    private String title;

    private Integer view;

    private Integer answernum;

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

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getAnswernum() {
        return answernum;
    }

    public void setAnswernum(Integer answernum) {
        this.answernum = answernum;
    }
}