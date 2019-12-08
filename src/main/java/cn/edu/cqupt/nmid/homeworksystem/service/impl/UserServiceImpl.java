package cn.edu.cqupt.nmid.homeworksystem.service.impl;

import cn.edu.cqupt.nmid.homeworksystem.dao.UserDao;
import cn.edu.cqupt.nmid.homeworksystem.po.User;
import cn.edu.cqupt.nmid.homeworksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2019/12/7 17:22
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String email, String password) {
        return userDao.login(email,password);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    public void saveUser(User user) {
         userDao.saveUser(user);
    }

    @Override
    public boolean isRegistered(String email) {
        return userDao.getUserCount(email) > 0;
    }
}
