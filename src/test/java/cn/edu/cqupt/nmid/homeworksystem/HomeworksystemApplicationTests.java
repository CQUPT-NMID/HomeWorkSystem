package cn.edu.cqupt.nmid.homeworksystem;

import cn.edu.cqupt.nmid.homeworksystem.service.DiscussionService;
import cn.edu.cqupt.nmid.homeworksystem.utils.JwtUtil;
import cn.edu.cqupt.nmid.homeworksystem.utils.ResponseResult;
import cn.edu.cqupt.nmid.homeworksystem.utils.page.PageRequest;
import cn.edu.cqupt.nmid.homeworksystem.utils.page.PageResult;
import cn.edu.cqupt.nmid.homeworksystem.web.DiscussionController;
import io.jsonwebtoken.Jwt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HomeworksystemApplicationTests {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private DiscussionService discussionService;

    @Autowired
    private DiscussionController discussionController;

    @Test
    void contextLoads() {

    }

    @Test
    void answerTest(){

    }

    @Test
    void qustionListTest() {

        ResponseResult question = discussionController.listQuestions(2,new PageRequest());
        Object data = question.getData();
        PageResult pageResult = (PageResult) data;
        System.out.println(pageResult.getContent());

    }


}
