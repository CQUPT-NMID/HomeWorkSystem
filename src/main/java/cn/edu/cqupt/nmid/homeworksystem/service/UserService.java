package cn.edu.cqupt.nmid.homeworksystem.service;

import cn.edu.cqupt.nmid.homeworksystem.po.User;

public interface UserService {

     User login(String email, String password);

    User findUserByEmail(String email);

    void saveUser(User user);

    boolean isRegistered(String email);
}
