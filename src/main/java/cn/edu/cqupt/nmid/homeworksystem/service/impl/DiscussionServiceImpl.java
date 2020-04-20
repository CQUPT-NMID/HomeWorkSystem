package cn.edu.cqupt.nmid.homeworksystem.service.impl;

import cn.edu.cqupt.nmid.homeworksystem.dao.AnswerMapper;
import cn.edu.cqupt.nmid.homeworksystem.dao.QuestionMapper;
import cn.edu.cqupt.nmid.homeworksystem.enums.QuestionType;
import cn.edu.cqupt.nmid.homeworksystem.po.Answer;
import cn.edu.cqupt.nmid.homeworksystem.po.Question;
import cn.edu.cqupt.nmid.homeworksystem.po.model.AnswerModel;
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
    public QuestionVo getQuestionById(Integer id) {
        QuestionVo question = questionMapper.queryByQuestionId(id);
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
       List<QuestionVo> list = null;
       switch (type){
           case DEFAULT:list = questionMapper.listQuetionsBySubjectId(subjectId);break;
           case MY_QUESTION:list = questionMapper.getMyQuestion(subjectId,id);break;
           case ANSWER_QUESTION:list = questionMapper.getMyAnswer(subjectId,id);break;
           case HISTORY:list = questionMapper.getMyHistory(subjectId,id);break;
           default:break;
       }
       return list;
    }

    @Override
    public List<QuestionVo> getMyQuestion(Integer subjectId, Integer id) {
        return questionMapper.getMyQuestion(subjectId,id);
    }

    @Override
    public List<QuestionVo> getMyAnswer(Integer subjectId, Integer id) {
        return questionMapper.getMyAnswer(subjectId,id);
    }

    @Override
    public List<QuestionVo> getMyHistory(Integer subjectId, Integer id) {
        return questionMapper.getMyHistory(subjectId,id);
    }


}
