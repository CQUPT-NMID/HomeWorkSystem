package cn.edu.cqupt.nmid.homeworksystem.dao;

import cn.edu.cqupt.nmid.homeworksystem.enums.QuestionType;
import cn.edu.cqupt.nmid.homeworksystem.po.Question;
import cn.edu.cqupt.nmid.homeworksystem.po.vo.QuestionVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<QuestionVo> listQuetionsBySubjectId(Integer subjectId);




    List<QuestionVo> getMyQuestion(Integer subjectId, Integer uid);

    List<QuestionVo> getMyAnswer(Integer subjectId, Integer uid);

    /**
     * 获取历史
     * @param subjectId
     * @param id
     * @return
     */
    List<QuestionVo> getMyHistory(Integer subjectId, Integer id);

    QuestionVo queryByQuestionId(Integer id);
}