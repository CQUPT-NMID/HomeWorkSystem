package cn.edu.cqupt.nmid.homeworksystem.dao;

import cn.edu.cqupt.nmid.homeworksystem.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

     User login(String email, String password);

    User findUserById(Integer id);

    User saveUser();

    int getUserCount(String mail);
}
