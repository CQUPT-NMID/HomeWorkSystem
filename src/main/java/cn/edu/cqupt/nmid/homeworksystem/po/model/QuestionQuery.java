package cn.edu.cqupt.nmid.homeworksystem.po.model;

import cn.edu.cqupt.nmid.homeworksystem.utils.page.PageRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/3/13 15:40
 */

public class QuestionQuery {
    @ApiModelProperty(value = "学科id")
    private Integer subjectId;

    private PageRequest pageRequest;

    private Integer userId;

}
