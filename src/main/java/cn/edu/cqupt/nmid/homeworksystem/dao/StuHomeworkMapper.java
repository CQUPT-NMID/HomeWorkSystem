package cn.edu.cqupt.nmid.homeworksystem.dao;

import cn.edu.cqupt.nmid.homeworksystem.po.StuHomework;

public interface StuHomeworkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StuHomework record);

    int insertSelective(StuHomework record);

    StuHomework selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuHomework record);

    int updateByPrimaryKey(StuHomework record);
}