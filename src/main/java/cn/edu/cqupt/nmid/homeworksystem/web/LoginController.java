package cn.edu.cqupt.nmid.homeworksystem.web;

import cn.edu.cqupt.nmid.homeworksystem.enums.ResultStatus;
import cn.edu.cqupt.nmid.homeworksystem.po.User;
import cn.edu.cqupt.nmid.homeworksystem.service.UserService;
import cn.edu.cqupt.nmid.homeworksystem.service.mail.MailService;
import cn.edu.cqupt.nmid.homeworksystem.utils.CheckCode;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;


/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2019/12/7 17:26
 */

@RestController
public class LoginController {

    public final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @ApiOperation("登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", required = true, value = "用户邮箱"),
            @ApiImplicitParam(name = "password", required = true, value = "用户密码")
    })
    @PostMapping("/user/login")
    public String loginIn(@RequestParam String email, @RequestParam String password, HttpSession session) {
        JSONObject returnData = new JSONObject();
        ResultStatus status = null;
        try {
            User user = userService.login(email, password);
            if (user == null) {
                status = ResultStatus.FAILED;
            } else {
                status = ResultStatus.SUCCESS;
                session.setAttribute("user", user);
            }
        } catch (Exception e) {
            logger.error("服务器在登陆方法出错");
            status = ResultStatus.FAILED;
        }
        returnData.put("status", status.getCode());
        returnData.put("JSESSIONID", session.getId());
        return returnData.toJSONString();
    }

    @ApiOperation("注销")
    @PostMapping("/user/loginOut")
    public String loginOut(@RequestParam HttpSession session) {
        JSONObject returnData = new JSONObject();
        ResultStatus status = null;
        try {
            session.removeAttribute("user");
            status = ResultStatus.SUCCESS;
        } catch (Exception e) {
            logger.error("服务器在注销方法出错");
            status = ResultStatus.SYSERROR;
        }
        returnData.put("status", status.getCode());
        return returnData.toJSONString();
    }

    @ApiOperation("发送验证码")
    @GetMapping("/user/register/sendCheckCode")
    public String sendCheckCode(@RequestParam String email, HttpSession session) {
        JSONObject returnData = new JSONObject();
        ResultStatus status = null;
        try {
            //检查邮箱是否已经注册
            if (userService.isRegistered(email)) {
                returnData.put("status", 201);
                return returnData.toJSONString();
            }
            String checkcode = CheckCode.getCheckCode(5);
            mailService.sendMail(new String[]{email}, "尚课邮我验证码", "<h2>您好,您的注册验证码是" + checkcode + "</h2>");
            session.setMaxInactiveInterval(120);
            session.setAttribute("checkcode", checkcode);
            session.setAttribute("usermail", email);
            status = ResultStatus.SUCCESS;
        } catch (Exception e) {
            status = ResultStatus.SYSERROR;
        }
        returnData.put("status", status.getCode());
        returnData.put("JSESSIONID", session.getId());
        return returnData.toJSONString();
    }

    @ApiOperation("注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="username",required = true),
            @ApiImplicitParam(name ="password",required = true),
            @ApiImplicitParam(name ="classnum",required = true),
            @ApiImplicitParam(name ="email",required = true),
            @ApiImplicitParam(name ="checkcode",required = true),
    })
    @PostMapping("/user/register")
    public String register(
                           @RequestParam String checkcode,
                           @RequestParam String classnum,
                           @RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String username,
                            HttpSession session) {
        JSONObject returnData = new JSONObject();
        ResultStatus status = null;
        String message = "";
        try {
            System.out.println(session.getAttribute("checkcode"));
            if (checkcode.equals(session.getAttribute("checkcode"))) {
                User user = new User(username, password, classnum, email);
                userService.saveUser(user);
                status = ResultStatus.SUCCESS;
                message = "注册成功";
            } else {
                message = "验证码错误";
                status = ResultStatus.FAILED;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            status = ResultStatus.SYSERROR;
            message = "服务器故障";
            logger.info("服务器遇到位置错误");
        }
        returnData.put("status", status.getCode());
        returnData.put("JSESSIONID", session.getId());
        returnData.put("message",message);
        return returnData.toJSONString();
    }
}
