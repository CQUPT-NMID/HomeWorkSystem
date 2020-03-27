package cn.edu.cqupt.nmid.homeworksystem.enums;

import io.swagger.annotations.ApiModelProperty;
import javafx.scene.chart.ValueAxis;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 问题类型
 * @date 2020/3/13 15:48
 */

public enum  QuestionType {
    //默认
    @ApiModelProperty(value = "默认查询")
    DEFAULT,
    //我的访问历史
    @ApiModelProperty(value = "我的历史")
    HISTORY,
    //我的提问
    @ApiModelProperty(value = "我的提问")
    MY_QUESTION,
    //我回答过的问题
    @ApiModelProperty(value = "我提出的问题")
    ANSWER_QUESTION;



}
