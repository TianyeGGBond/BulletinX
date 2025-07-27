package com.wildfield.BulletinX.exception;

import com.wildfield.BulletinX.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//    这是一个公开的方法，用来处理所有类型的异常，它不能被子类改写。
//    它接收一个错误对象（ex）和当前请求的信息（request），
//    然后返回一个 HTTP 响应对象（ResponseEntity），包装了你想要返回给前端的错误内容。
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetail> handleAllExceptions(Exception ex, WebRequest request){
        ErrorDetail errorDetail = new ErrorDetail(
                LocalTime.now(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<ErrorDetail>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR); //500
    }


    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetail> handleUserNotFoundExceptions(Exception ex, WebRequest request){
        ErrorDetail errorDetail = new ErrorDetail(
                LocalTime.now(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<ErrorDetail>(errorDetail, HttpStatus.NOT_FOUND); //404
    }

    //新增user格式不对时返回自定义消息
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        // 创建自定义错误信息对象
        ErrorDetail errorDetails = new ErrorDetail(
                LocalTime.now(), // 当前时间
                "Total error(s): " + ex.getErrorCount() + ". First error: " + ex.getFieldError().getDefaultMessage(), // 拿到校验失败的提示信息（message=）
                request.getDescription(false) // 获取请求的路径等信息
        );

        // 返回错误信息 + 400 状态码
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
