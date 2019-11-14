package com.fulei.fblog.exceptions;

/**
 * @author fulei
 * @Title: CheckException
 * @ProjectName ferry
 * @Description: CheckException
 * @date 2019/11/5 15:08
 */
public class CheckException extends RuntimeException {

  public CheckException() {
    super();
  }

  public CheckException(String message) {
    super(message);
  }

  public CheckException(Throwable cause) {
    super(cause);
  }

  public CheckException(String message, Throwable cause) {
    super(message, cause);
  }

  public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
