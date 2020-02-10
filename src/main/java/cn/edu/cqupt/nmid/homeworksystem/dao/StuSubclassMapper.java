package cn.edu.cqupt.nmid.homeworksystem.dao;

import cn.edu.cqupt.nmid.homeworksystem.po.StuSubclass;

public interface StuSubclassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StuSubclass record);

    int insertSelective(StuSubclass record);

    StuSubclass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuSubclass record);

    int updateByPrimaryKey(StuSubclass record);
}