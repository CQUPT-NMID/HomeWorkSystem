package cn.edu.cqupt.nmid.homeworksystem.utils;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 用来获取request 中传来的user
 * @date 2020/3/13 15:05
 */

public class TokenUserUtil {

    public static TokenUser getTokenUser(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return (TokenUser) request.getAttribute(JwtUtil.USER);
    }
}
