package com.fulei.fblog.controller.login;


import com.fulei.fblog.dto.UserInfoDto;
import com.fulei.fblog.service.ILoginService;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fulei
 * @Title: LoginController
 * @ProjectName ferry
 * @Description: LoginController
 * @date 2019/11/5 16:32
 */
@RestController
public class LoginController {

  @Resource
  private ILoginService loginService;

    @PostMapping("/session")
    @ResponseStatus(HttpStatus.OK)
    public void login(UserInfoDto userInfoDto){
       loginService.login(userInfoDto);
    }
}
