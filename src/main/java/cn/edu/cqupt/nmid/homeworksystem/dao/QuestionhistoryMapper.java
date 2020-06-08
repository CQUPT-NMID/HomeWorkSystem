package cn.edu.cqupt.nmid.homeworksystem.dao;

import cn.edu.cqupt.nmid.homeworksystem.po.Questionhistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QuestionhistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Questionhistory record);

    int insertSelective(Questionhistory record);

    Questionhistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Questionhistory record);

    int updateByPrimaryKey(Questionhistory record);
}