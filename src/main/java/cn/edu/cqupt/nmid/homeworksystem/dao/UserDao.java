package cn.edu.cqupt.nmid.homeworksystem.dao;

import cn.edu.cqupt.nmid.homeworksystem.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Select("select * from user where email = #{email} and password = #{password}")
     User login(String email, String password);
    @Select("select * from user where email = #{email}")
    User findUserByEmail(String email);
    @Insert({"insert into user(email,username,password,classnum) values(#{email},#{username},#{password},#{classnum})"})
    void saveUser(User user);
    @Select("select count(*) from user where email = #{email}")
    int getUserCount(String email);
}
