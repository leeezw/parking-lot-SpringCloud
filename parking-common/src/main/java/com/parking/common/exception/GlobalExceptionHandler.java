package com.parking.common.exception;

import com.parking.common.result.CommonResult;
import com.parking.common.result.ErrorCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局异常处理器
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    // 处理自定义业务异常
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<String> handleBusinessException(BusinessException e) {
        // 使用枚举来获取错误码和错误消息
        ErrorCodeEnum errorCode = ErrorCodeEnum.getByCode(e.getCode());
        return CommonResult.error(errorCode != null ? errorCode.getCode() : 500,
                errorCode != null ? errorCode.getMessage() : "未知错误");
    }

    // 处理系统级异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<String> handleException(Exception e) {
        // 捕获系统异常时，返回系统内部错误的错误码和消息
        return CommonResult.systemError(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getMessage());
    }

    // 处理其他预期异常，如空指针等
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<String> handleNullPointerException(NullPointerException e) {
        return CommonResult.systemError("请求数据缺失或格式错误！");
    }

    // 处理业务请求参数校验异常
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.OK)
    public CommonResult<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return CommonResult.error(400, e.getMessage());
    }
}
