package cn.edu.cqupt.nmid.homeworksystem.po.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;


/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/27 21:58
 */

@ApiModel(description = "问题")
public class QuestionVo {

    @ApiModelProperty(value = "问题id")
    private Integer id;

    @ApiModelProperty(value = "问题标题")
    private String title;

    @ApiModelProperty(value = "问题内容")
    private String content;

    @ApiModelProperty(value = "查看数")
    private Integer view;

    @ApiModelProperty(value = "评论数")
    private Integer answer;

    @ApiModelProperty(value = "提问的人名字")
    private String name;

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
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "QuestionVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", view=" + view +
                ", answer=" + answer +
                ", name='" + name + '\'' +
                '}';
    }
}
