package com.goddess.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author ：Arthur
 * @description：异常统一处理器
 * @date ：2020/10/21 13:56
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handle(ValidationException exception) {
		List<String> errorMsg = new ArrayList<>();
		if (exception instanceof ConstraintViolationException) {
			ConstraintViolationException exs = (ConstraintViolationException) exception;

			Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
			for (ConstraintViolation<?> item : violations) {
				/**打印验证不通过的信息*/
				System.out.println(item.getMessage());
				errorMsg.add(item.getMessage());
			}
		}
		return "bad request, " + errorMsg;
	}

	@ResponseBody
	@ExceptionHandler(value = BindException.class)
	public String bindException(Exception e) {
		if (e instanceof BindException) {
			BindException exs = (BindException) e;
			List<FieldError> fieldErrors = exs.getFieldErrors();
			for (FieldError item : fieldErrors) {
				log.error("请求异常：" + item.getDefaultMessage());
			}
		}
		log.error("数据绑定异常：" + e.getMessage());
		return "数据绑定异常";
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
		// 注意哦，这里返回类型是自定义响应体
		return objectError.getDefaultMessage();
	}
}
