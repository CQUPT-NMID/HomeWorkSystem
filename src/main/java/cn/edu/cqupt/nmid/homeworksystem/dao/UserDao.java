package cn.edu.cqupt.nmid.homeworksystem.dao;

import cn.edu.cqupt.nmid.homeworksystem.po.User;
import cn.edu.cqupt.nmid.homeworksystem.po.model.RegisterUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/3/8 13:50
 */

@Mapper
@Component
public interface UserDao {

    /**
     * 用户登陆
     * @param user
     * @return
     */
    User login(User user);


    /**
     * 通过email查询用户信息
     * @param email
     * @return
     */
    int selectByEmail(String email);

    /**
     * 修改密码
     * @param user
     */
    void updatePassword(RegisterUser user);

    /**
     * 保存新用户
     * @param user
     */
    void saveUser(RegisterUser user);

}
