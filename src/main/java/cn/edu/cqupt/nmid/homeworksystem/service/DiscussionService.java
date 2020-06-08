package cn.edu.cqupt.nmid.homeworksystem.service;

import cn.edu.cqupt.nmid.homeworksystem.enums.QuestionType;
import cn.edu.cqupt.nmid.homeworksystem.po.Answer;
import cn.edu.cqupt.nmid.homeworksystem.po.Question;
import cn.edu.cqupt.nmid.homeworksystem.po.Questionhistory;
import cn.edu.cqupt.nmid.homeworksystem.po.model.AnswerModel;
import cn.edu.cqupt.nmid.homeworksystem.po.model.QuestionModel;
import cn.edu.cqupt.nmid.homeworksystem.po.vo.QuestionVo;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/26 21:06
 */

public interface DiscussionService {

    /**
     * 发布问题
     * @param question
     */
    Integer publishQuestion(Question question);

    /**
     * 通过学科id 获取学科问题列表
     * @param subjectId  学科id
     * @return
     */
    List<QuestionVo> listQuetionsBySubjectId(Integer subjectId);

    /**
     * 通过id 获取问题详情
     * @param id
     */
    QuestionVo getQuestionById(Integer id);

    /**
     * 回复问题
     * @param answer
     * @return 返回id
     */
    Integer publishAnswer(Answer answer);

    /**
     * 更新问题
     * @param answer
     * @return
     */
    Integer updateAnswer(Answer answer);

    /**
     * 删除 回答
     * @param id
     */
    void deleteAnswer(Integer id);

    /**
     * 通过学科id 查询问题的回答列表
     * @param id
     */
    List<AnswerModel> listAnswerByQuestionId(Integer id);

    /**
     * 多条件查询
     * @param subjectId
     * @param type
     * @param id
     * @return
     */
    List<QuestionVo> listQuestion(Integer subjectId, QuestionType type, Integer id);

    /**
     * 获取我的提问
     * @param subjectId
     * @param id
     * @return
     */
    List<QuestionVo> getMyQuestion(Integer subjectId, Integer id);

    /**
     * 获得我回答过的问题
     * @param subjectId
     * @param id
     * @return
     */
    List<QuestionVo> getMyAnswer(Integer subjectId, Integer id);

    /**
     * 足迹
     * @param subjectId
     * @param id
     * @return
     */
    List<QuestionVo> getMyHistory(Integer subjectId, Integer id);


    Integer addHistory(Questionhistory questionhistory);
}
