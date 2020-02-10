package cn.edu.cqupt.nmid.homeworksystem;

import cn.edu.cqupt.nmid.homeworksystem.utils.JwtUtil;
import io.jsonwebtoken.Jwt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HomeworksystemApplicationTests {

    @Autowired
    private JwtUtil jwtUtil;

    @Test
    void contextLoads() {
        System.out.println(jwtUtil.getExpire());
        System.out.println(jwtUtil.getHeader());
    }

}
