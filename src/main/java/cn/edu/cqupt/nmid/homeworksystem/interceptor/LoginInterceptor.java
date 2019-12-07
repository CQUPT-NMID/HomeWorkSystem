package cn.edu.cqupt.nmid.homeworksystem.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2019/12/7 18:15
 */

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            request.getSession().setAttribute("message","请先登陆");
            response.sendRedirect("/login");
            return false ;
        }
        return true;
    }
}
