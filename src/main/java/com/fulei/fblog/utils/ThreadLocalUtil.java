package com.fulei.fblog.utils;


import com.fulei.fblog.dto.UserInfoDto;

/**
 * @author fulei
 * @Title: ThreadLocalUtil
 * @ProjectName ferry
 * @Description: ThreadLocalUtil
 * @date 2019/11/5 15:59
 */
public class ThreadLocalUtil {

  private ThreadLocalUtil(){}

  public static final String KEY_USER = "user";

  private static final ThreadLocal<UserInfoDto> tlUser = new ThreadLocal<>();

  public static UserInfoDto getUser(){
    return tlUser.get();
  }

  public static void setUser(UserInfoDto userInfoDto){
    tlUser.set(userInfoDto);
  }

  public static void clearThreadLocal() {
    tlUser.remove();
  }

}
