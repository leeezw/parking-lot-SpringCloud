package com.parking.common.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用响应结果封装类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    // 状态码，200表示成功，其他的根据具体情况设定
    private Integer code;

    // 响应消息，例如成功的提示或错误的描述
    private String message;

    // 响应的数据
    private T respData;

    // 成功的返回方法
    public static <T> CommonResult<T> success(T data) {
        return CommonResult.<T>builder()
                .code(200)
                .message("成功")
                .respData(data)
                .build();
    }

    // 失败的返回方法
    public static <T> CommonResult<T> error(Integer code, String message) {
        return CommonResult.<T>builder()
                .code(code)
                .message(message)
                .respData(null)
                .build();
    }

    // 系统错误返回方法
    public static <T> CommonResult<T> systemError(String message) {
        return CommonResult.<T>builder()
                .code(500)
                .message(message)
                .respData(null)
                .build();
    }
}
