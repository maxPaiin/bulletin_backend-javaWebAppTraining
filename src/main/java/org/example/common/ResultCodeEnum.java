package org.example.common;

public enum ResultCodeEnum {

    SUCCESS(200,"success"),
    LGOIN_IDERROR(501,"login_idError"),
    PASSWORD_ERROR(503,"passwordError"),
    NOTLOGIN(504,"notLogin"),
    LOGIN_IDUSED(505,"login_idUsed")
    ;

    private Integer code;
    private String message;
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
