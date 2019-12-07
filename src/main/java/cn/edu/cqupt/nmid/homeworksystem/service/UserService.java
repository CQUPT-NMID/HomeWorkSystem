package cn.edu.cqupt.nmid.homeworksystem.service;

import cn.edu.cqupt.nmid.homeworksystem.po.User;

public interface UserService {

     User login(String email, String password);

    User findUserById(Integer id);

    User saveUser();

    boolean isRegistered(String mail);
}
