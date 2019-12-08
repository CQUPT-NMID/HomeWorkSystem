package cn.edu.cqupt.nmid.homeworksystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.edu.cqupt.nmid.homeworksystem.dao")
public class HomeworksystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworksystemApplication.class, args);
    }

}
