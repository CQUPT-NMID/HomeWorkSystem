package cn.edu.cqupt.nmid.homeworksystem.dao;

import cn.edu.cqupt.nmid.homeworksystem.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/2/10 15:47
 */

@Mapper
public interface UserDao {

    User login(User user);
}
