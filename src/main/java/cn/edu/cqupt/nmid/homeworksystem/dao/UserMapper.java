package cn.edu.cqupt.nmid.homeworksystem.dao;

import cn.edu.cqupt.nmid.homeworksystem.po.User;

public interface UserMapper {
    int deleteByPrimaryKey(String email);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String email);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}