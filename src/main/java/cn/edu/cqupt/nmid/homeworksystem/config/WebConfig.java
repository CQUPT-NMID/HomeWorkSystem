package cn.edu.cqupt.nmid.homeworksystem.config;

import cn.edu.cqupt.nmid.homeworksystem.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author MaYunHao
 * @version 1.0
 * @description  配置拦截路径
 * @date 2019/12/7 18:18
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
     //   registry.addInterceptor(new LoginInterceptor());
    }
}
