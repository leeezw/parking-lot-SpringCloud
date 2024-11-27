package com.parking.common.result;

/**
 * 错误码和错误消息的枚举类
 */
public enum ErrorCodeEnum {

    SUCCESS(200, "成功"),
    INVALID_PARAMETERS(400, "无效的参数"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源未找到"),
    INTERNAL_SERVER_ERROR(500, "系统内部错误"),
    DATABASE_ERROR(600, "数据库操作错误"),
    NETWORK_ERROR(601, "网络异常"),
    INVALID_MOBILE(1001, "无效的手机号码"),
    USER_NOT_FOUND(1002, "用户不存在"),
    DUPLICATE_USER(1003, "用户已存在"),
    SYSTEM_MAINTENANCE(9999, "系统正在维护，请稍后重试");

    // 错误码
    private final int code;
    // 错误消息
    private final String message;

    // 构造方法
    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // 获取错误码
    public int getCode() {
        return code;
    }

    // 获取错误消息
    public String getMessage() {
        return message;
    }

    /**
     * 根据错误码获取对应的错误消息
     * @param code 错误码
     * @return 错误消息
     */
    public static String getMessageByCode(int code) {
        for (ErrorCodeEnum errorCode : ErrorCodeEnum.values()) {
            if (errorCode.getCode() == code) {
                return errorCode.getMessage();
            }
        }
        return "未知错误";
    }

    /**
     * 根据错误码获取错误枚举
     * @param code 错误码
     * @return 错误枚举
     */
    public static ErrorCodeEnum getByCode(int code) {
        for (ErrorCodeEnum errorCode : ErrorCodeEnum.values()) {
            if (errorCode.getCode() == code) {
                return errorCode;
            }
        }
        return null;
    }
}
