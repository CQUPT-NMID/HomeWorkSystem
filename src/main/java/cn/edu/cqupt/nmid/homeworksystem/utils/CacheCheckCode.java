package cn.edu.cqupt.nmid.homeworksystem.utils;

import java.util.HashMap;
import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 用于临时保存验证码
 * @date 2020/3/3 19:26
 */

public class CacheCheckCode {

    private static HashMap<String,String> codes;

    static {
        codes = new HashMap<>();
    }

    public static void addCheckCode(String email,String code){
        codes.put(email,code);
    }

    public static String getCheckCode(String email){
        return codes.get(email);
    }

    /**
     * 定时器任务，到点删除超过时间得验证码
     */
    public void removeTiming(){

    }


}
