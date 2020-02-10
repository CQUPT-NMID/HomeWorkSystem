package cn.edu.cqupt.nmid.homeworksystem.annotation;
import java.lang.annotation.*;

/**
 * @author MaYunHao
 * @version 1.0
 * @description  判断是否需要登陆
 * @date 2020/2/8 10:57
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface UserLogin {
    boolean required() default true;
}
