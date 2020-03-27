package cn.edu.cqupt.nmid.homeworksystem.service;

import cn.edu.cqupt.nmid.homeworksystem.po.User;
import cn.edu.cqupt.nmid.homeworksystem.po.model.RegisterUser;

public interface UserService {

    /**
     * 登陆
     * @param email 邮箱
     * @param password 密码
     * @return 根据不同角色返回实际User
     */
     User login(String email, String password);




    /**
     * 判断邮箱是否已被注册
     * @param email
     * @return
     */
    boolean isRegistered(String email);

    /**
     * 修改密码
     * @param user
     */
    void updatePassword(RegisterUser user);

    /**
     * 注册
     * @param user
     */
    void register(RegisterUser user);
}
