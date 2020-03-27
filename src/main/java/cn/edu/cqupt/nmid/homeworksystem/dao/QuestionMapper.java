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


    /**
     * 查询历史，未完成
     * @param subjectId
     * @param type
     * @param id
     * @return
     */
    List<QuestionVo> selectQuestion(Integer subjectId, QuestionType type, Integer id);
}