package cn.edu.cqupt.nmid.homeworksystem.interceptor;

import cn.edu.cqupt.nmid.homeworksystem.annotation.UserLogin;
import cn.edu.cqupt.nmid.homeworksystem.enums.Status;
import cn.edu.cqupt.nmid.homeworksystem.utils.JwtUtil;
import cn.edu.cqupt.nmid.homeworksystem.utils.TokenUser;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureException;
import javafx.beans.property.ReadOnlyListProperty;
import jdk.nashorn.internal.parser.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 登陆校验
 * @date 2020/2/8 11:02
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.判断是否存在注解
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod method = (HandlerMethod)handler;
        UserLogin classLoginAnn = method.getBeanType().getAnnotation(UserLogin.class);
        UserLogin methodLoginAnn = method.getMethod().getAnnotation(UserLogin.class);

        //校验是否需要登陆检验
        //检验对象
        //1.方法上有注解，且为require(优先)
        //2.类上有注解，且为require
        boolean needLogin = false;
        int role = 0;
        if (methodLoginAnn!=null){
            //方法上有注解
            needLogin = methodLoginAnn.required();
            role = methodLoginAnn.role();
        }else if(classLoginAnn!=null){
            //类上有注解
            needLogin = classLoginAnn.required();
            role = classLoginAnn.role();
        }

        Claims claims = null;
        //如果需要检验
        if (needLogin) {
            /** Token 验证 */
            //请求中中获取token
            String token = request.getHeader(jwtUtil.getHeader());
            if(StringUtils.isEmpty(token)){
                //请求参数中获取token
                token = request.getParameter(jwtUtil.getHeader());
            }
            //如果为空
            if(StringUtils.isEmpty(token)){
                throw new SignatureException(jwtUtil.getHeader()+ "不能为空");
            }
            try{
                claims = jwtUtil.getTokenClaim(token);
                if(claims == null || jwtUtil.isTokenExpired(claims.getExpiration())){
                    throw new SignatureException(jwtUtil.getHeader() + "失效，请重新登录。");
                }
            }catch (Exception e){
                throw new SignatureException(jwtUtil.getHeader() + "失效，请重新登录。");
            }

            //类型转换，jwt解析出来时linklistmap
            TokenUser tokenUser = JSON.parseObject(JSON.toJSONString(claims.get(JwtUtil.USER)),TokenUser.class);

            //验证权限
            int userRole = tokenUser.getRole();

            if (userRole < role){
                throw new JwtException("没有权限访问");
            }

            //向后传递用户信息
            request.setAttribute(JwtUtil.USER,tokenUser);
        }
        return true;
    }

}
