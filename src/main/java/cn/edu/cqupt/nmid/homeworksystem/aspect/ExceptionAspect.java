package cn.edu.cqupt.nmid.homeworksystem.aspect;


import cn.edu.cqupt.nmid.homeworksystem.exception.MyException;
import cn.edu.cqupt.nmid.homeworksystem.utils.ResponseResult;
import cn.edu.cqupt.nmid.homeworksystem.enums.Status;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author MaYunHao
 * @version 1.0
 * @description  异常处理，结果处理，日志打印
 * @date 2020/2/8 13:41
 */

@Aspect
@Component
public class ExceptionAspect {

    private final Logger logger = LoggerFactory.getLogger("ExceptinAspect");

    @Pointcut(value = "execution(* cn.edu.cqupt.nmid.homeworksystem.web.*.*(..))")
    private void myPointcut() {
    }


    /**
     * 环绕通知 用于异常处理、结果处理和日志打印
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "ExceptionAspect.myPointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        String classname = proceedingJoinPoint.getTarget().getClass().getName();
        String methodname = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        logger.info("类:{},方法:{}",classname,methodname);
        logger.info("参数 {}", Arrays.toString(args));
        Object result = null;
        try {
            result =  proceedingJoinPoint.proceed();
            logger.info("执行成功");
            logger.info("返回 {}",result);
            return result;
        } catch (MyException e) {
            logger.error(methodname +"发生异常");
            logger.error(e.getStatus().getMessage());
            return ResponseResult.failure(e.getStatus());
        }catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.error(methodname +"发生异常");
            logger.error(throwable.getMessage());
            return ResponseResult.failure(Status.SysError);
        }
    }
}
