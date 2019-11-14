package com.fulei.fblog.filters;

import com.fulei.fblog.exceptions.CheckException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author fulei
 * @Title: ExceptionFilter
 * @ProjectName ferry
 * @Description: ExceptionFilter
 * @date 2019/11/5 16:50
 */
@RestControllerAdvice
public class ExceptionFilter {

  @ExceptionHandler
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public void defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {

  }

  @ResponseBody
  @ExceptionHandler(CheckException.class)
  public void handleCheckException(HttpServletRequest request, CheckException e) {

  }
}
