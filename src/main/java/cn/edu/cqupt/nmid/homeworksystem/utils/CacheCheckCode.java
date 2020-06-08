package cn.edu.cqupt.nmid.homeworksystem.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 用于临时保存验证码
 * @date 2020/3/3 19:26
 */

@Component
public class CacheCheckCode {

    private final Logger logger = LoggerFactory.getLogger(CacheCheckCode.class);

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    /**
     * 保存验证码
     * @param email
     * @param code
     */
    public void addCheckCode(String email,String code){
        logger.info("保存验证码 {} : {}",email,code);
        String checkCode = getCheckCode(email);
        if (checkCode != null){
            //删除以前的
            redisTemplate.delete(email);
        }
        redisTemplate.opsForValue().set(email,code,3, TimeUnit.MINUTES);
    }

    /**
     * 获取验证码
     * @param email
     * @return
     */
    public String getCheckCode(String email){
        logger.info("获取验证码 {}",email);
        String code = redisTemplate.opsForValue().get(email);
        return code;
    }

    public void deleteCheckCode(String email){
        logger.info("删除验证码 {}",email);
        redisTemplate.delete(email);
    }



}
