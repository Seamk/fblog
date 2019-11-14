package com.fulei.fblog.service;


import com.fulei.fblog.dto.UserInfoDto;

/**
 * @author fulei
 * @Title: ILoginService
 * @ProjectName ferry
 * @Description: ILoginService
 * @date 2019/11/5 16:55
 */
public interface ILoginService {
  void login(UserInfoDto userInfoDto);
}
