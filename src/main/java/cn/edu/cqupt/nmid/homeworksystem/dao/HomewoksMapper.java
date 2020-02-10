package cn.edu.cqupt.nmid.homeworksystem.dao;

import cn.edu.cqupt.nmid.homeworksystem.po.Homewoks;

public interface HomewoksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Homewoks record);

    int insertSelective(Homewoks record);

    Homewoks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Homewoks record);

    int updateByPrimaryKey(Homewoks record);
}