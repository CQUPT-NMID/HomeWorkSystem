package cn.edu.cqupt.nmid.homeworksystem.exception;


import cn.edu.cqupt.nmid.homeworksystem.enums.Status;

/**
 * @author MaYunHao
 * @version 1.0
 * @description  异常处理
 * @date 2020/2/8 11:03
 */

public class MyException extends Exception {
    private Status status;

   public MyException(Status status){
       this.status = status;
   }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
