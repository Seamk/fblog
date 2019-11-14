package com.fulei.fblog.utils;

import com.fulei.fblog.exceptions.CheckException;
import java.text.MessageFormat;

/**
 * @author fulei
 * @Title: CheckUtil
 * @ProjectName ferry
 * @Description: CheckUtil
 * @date 2019/11/5 15:02
 */
public class CheckUtil {

  private CheckUtil(){}

  public static void check(boolean condition,String message,String ... params){
    if(condition){
        throw new CheckException(MessageFormat.format(message,params));
    }
  }

}
