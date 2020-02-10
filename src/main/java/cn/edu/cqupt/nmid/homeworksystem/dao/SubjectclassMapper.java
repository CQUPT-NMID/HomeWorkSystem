package cn.edu.cqupt.nmid.homeworksystem.dao;

import cn.edu.cqupt.nmid.homeworksystem.po.Subjectclass;

public interface SubjectclassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Subjectclass record);

    int insertSelective(Subjectclass record);

    Subjectclass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Subjectclass record);

    int updateByPrimaryKey(Subjectclass record);
}