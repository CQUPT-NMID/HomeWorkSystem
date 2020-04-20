package cn.edu.cqupt.nmid.homeworksystem.service.impl;


import cn.edu.cqupt.nmid.homeworksystem.dao.StudentDao;
import cn.edu.cqupt.nmid.homeworksystem.dao.TeacherMapper;
import cn.edu.cqupt.nmid.homeworksystem.dao.UserDao;
import cn.edu.cqupt.nmid.homeworksystem.po.Teacher;
import cn.edu.cqupt.nmid.homeworksystem.po.User;
import cn.edu.cqupt.nmid.homeworksystem.po.model.RegisterUser;
import cn.edu.cqupt.nmid.homeworksystem.service.UserService;
import cn.edu.cqupt.nmid.homeworksystem.utils.USER_ROLE;
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

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public User login(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        if ((user = userDao.login(user)) != null) {
            user = studentDao.queryByEmail(user.getEmail());
            return user;
        }
        return null;
    }



    @Override
    public boolean isRegistered(String email) {
        return userDao.selectByEmail(email) > 0;
    }

    @Override
    public void updatePassword(RegisterUser user) {
        userDao.updatePassword(user);
    }

    @Override
    public void register(RegisterUser user) {
        userDao.saveUser(user);
    }
}
