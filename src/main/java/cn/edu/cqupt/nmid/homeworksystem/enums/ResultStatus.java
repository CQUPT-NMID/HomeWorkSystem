package cn.edu.cqupt.nmid.homeworksystem.enums;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2019/12/7 17:42
 */
public enum ResultStatus {
    SUCCESS(200,"成功"),
    FAILED(400,"失败"),
    SYSERROR(500,"错误");

    private Integer code;
    private String message;

    ResultStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
