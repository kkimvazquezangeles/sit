package mx.edu.utec.dto;

/**
 * Created by kkimvazquezangeles on 25/04/15.
 */
public class ResponseDTO {

    public static final String CODE_SUCCESS = "success";
    public static final String CODE_ERROR = "error";

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
