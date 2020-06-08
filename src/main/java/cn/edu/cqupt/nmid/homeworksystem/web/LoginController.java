
package cn.edu.cqupt.nmid.homeworksystem.web;
import cn.edu.cqupt.nmid.homeworksystem.enums.ResultStatus;
import cn.edu.cqupt.nmid.homeworksystem.enums.Status;
import cn.edu.cqupt.nmid.homeworksystem.po.User;
import cn.edu.cqupt.nmid.homeworksystem.po.model.LoginUserModel;
import cn.edu.cqupt.nmid.homeworksystem.po.model.RegisterUser;
import cn.edu.cqupt.nmid.homeworksystem.service.UserService;
import cn.edu.cqupt.nmid.homeworksystem.service.mail.MailService;
import cn.edu.cqupt.nmid.homeworksystem.utils.CacheCheckCode;
import cn.edu.cqupt.nmid.homeworksystem.utils.CheckCode;
import cn.edu.cqupt.nmid.homeworksystem.utils.JwtUtil;
import cn.edu.cqupt.nmid.homeworksystem.utils.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.xml.ws.Response;
import java.util.HashMap;


/**
 * @author MaYunHao
 * @version 1.0
 * @description  登陆业务相关
 * @date 2019/12/7 17:26
 */

@RestController
@Api(tags = "登陆 注册 修改密码相关")
@RequestMapping("/api")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CacheCheckCode cacheCheckCode;


    @ApiOperation("登陆")
    @PostMapping("/login")
    public ResponseResult loginIn(@RequestBody @ApiParam(required = true) LoginUserModel loginUser) {

        User user = userService.login(loginUser.getEmail(), loginUser.getPassword());
            if (user == null) {
                return ResponseResult.failure(Status.FAULT_PASSWORD);
            } else {
                String token = jwtUtil.createToken(user);
                HashMap<String, Object> map = new HashMap<>();
                //返回用户信息
                map.put("user",user);
                //返回token
                map.put("token",token);
                return ResponseResult.success(map);
            }
}

//    @ApiOperation("注销")
//    @PostMapping("/loginOut")
//    public String loginOut() {
//        return null;
//    }

    @ApiOperation("发送验证码")
    @GetMapping("register/sendCheckCode")
    public ResponseResult sendCheckCode(@RequestParam String email) {
        try {
            //检查邮箱是否已经注册
            if (userService.isRegistered(email)) {
                return ResponseResult.failure(Status.USER_EXIST);
            }

            String checkcode = CheckCode.getCheckCode(5);
            mailService.sendMail(new String[]{email}, "尚课邮我验证码", "<h2>您好,您的注册验证码是" + checkcode + "</h2>");

            // redis 暂存验证码
            cacheCheckCode.addCheckCode(email,checkcode);
            //不使用session
/*            session.setMaxInactiveInterval(120);
            session.setAttribute("checkcode", checkcode);
            session.setAttribute("usermail", email);
            */

            logger.info("发送成功");
            return ResponseResult.success(checkcode);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseResult.failure(Status.SysError);
        }
    }

    /**
     * 需要修改,问题在与ui图需要修改
     */
    @ApiOperation("注册")
    @PostMapping("/user/register")
    public ResponseResult register(@RequestBody RegisterUser user) {
        String code = cacheCheckCode.getCheckCode(user.getEmail());
        if (code != null && code.equals(user.getCheckCode())){
            userService.register(user);
            logger.info("{} 注册成功",user.getEmail());
            return ResponseResult.success();
        } else {
            return ResponseResult.failure("验证码错误");
        }
    }

    @ApiOperation("更新密码")
    @PostMapping("/updatePassword")
    private ResponseEntity updatePassword(@RequestBody RegisterUser user){
        HashMap<String, Object> map = new HashMap<>();
        try {
            String code =  cacheCheckCode.getCheckCode(user.getEmail());
            if (!user.getCheckCode().equals(code)){
                //验证码错误
                return ResponseEntity.badRequest().body("验证码错误");
            }
            userService.updatePassword(user);
            return ResponseEntity.ok("SUCCESS");
        }catch (Exception e){
         return ResponseEntity.status(HttpStatus.valueOf(500)).build();
        }
}

}
