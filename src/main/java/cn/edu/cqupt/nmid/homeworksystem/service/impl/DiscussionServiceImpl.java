package cn.edu.cqupt.nmid.homeworksystem.service.impl;

import cn.edu.cqupt.nmid.homeworksystem.dao.AnswerMapper;
import cn.edu.cqupt.nmid.homeworksystem.dao.QuestionMapper;
import cn.edu.cqupt.nmid.homeworksystem.enums.QuestionType;
import cn.edu.cqupt.nmid.homeworksystem.po.Answer;
import cn.edu.cqupt.nmid.homeworksystem.po.Question;
import cn.edu.cqupt.nmid.homeworksystem.po.model.AnswerModel;
import cn.edu.cqupt.nmid.homeworksystem.po.model.QuestionModel;
import cn.edu.cqupt.nmid.homeworksystem.po.vo.QuestionVo;
import cn.edu.cqupt.nmid.homeworksystem.service.DiscussionService;
import cn.edu.cqupt.nmid.homeworksystem.utils.TokenUser;
import cn.edu.cqupt.nmid.homeworksystem.utils.TokenUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/26 21:10
 */
@Service
public class DiscussionServiceImpl implements DiscussionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public Integer publishQuestion(Question question) {
        questionMapper.insertSelective(question);
        return question.getId();
    }


    @Override
    public List<QuestionVo> listQuetionsBySubjectId(Integer subjectId) {
        return questionMapper.listQuetionsBySubjectId(subjectId);
    }

    @Override
    public Question getQuestionById(Integer id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        return question;
    }

    @Override
    public Integer publishAnswer(Answer answer) {
        return answerMapper.insertSelective(answer);
    }

    @Override
    public Integer updateAnswer(Answer answer) {
        return answerMapper.updateByPrimaryKey(answer);
    }

    @Override
    public void deleteAnswer(Integer id) {
        answerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<AnswerModel> listAnswerByQuestionId(Integer id) {
        List<AnswerModel> models = answerMapper.selectByQuestionId(id);
        TokenUser user = TokenUserUtil.getTokenUser();
        if (user != null){
            Integer userId = user.getId();
            int size = models.size();
            for (int i = 0; i < size; i++) {
                AnswerModel model = models.get(i);
                if (model.getId()!= null && userId.equals(model.getId())){
                    model.setUpdateAble(true);
                }else {
                    model.setUpdateAble(false);
                }
            }
        }
        return models;
    }

    @Override
    public List<QuestionVo> listQuestion(Integer subjectId, QuestionType type, Integer id) {
        return questionMapper.selectQuestion(subjectId,type,id);
    }


}
