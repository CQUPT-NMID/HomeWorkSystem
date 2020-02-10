package cn.edu.cqupt.nmid.homeworksystem.dao;

import cn.edu.cqupt.nmid.homeworksystem.po.Subject;

public interface SubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);
}