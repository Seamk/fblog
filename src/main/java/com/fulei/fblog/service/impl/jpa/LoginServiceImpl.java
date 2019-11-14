package com.fulei.fblog.service.impl.jpa;


import com.fulei.fblog.domain.UserInfoDo;
import com.fulei.fblog.dto.UserInfoDto;
import com.fulei.fblog.repository.UserInfoRepository;
import com.fulei.fblog.service.ILoginService;
import com.fulei.fblog.utils.CheckUtil;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author fulei
 * @Title: LoginServiceImpl
 * @ProjectName ferry
 * @Description: LoginServiceImpl
 * @date 2019/11/5 16:55
 */
@Service
public class LoginServiceImpl implements ILoginService {

  @Resource
  private UserInfoRepository userInfoRepository;

  @Override
  public void login(UserInfoDto userInfoDto) {
      CheckUtil.check(StringUtils.isEmpty(userInfoDto.getUserName()),"账号密码不正确");
      UserInfoDo userInfoDo = userInfoRepository.findByUserName(userInfoDto.getUserName());
      CheckUtil.check(userInfoDo==null,"账号密码不正确");

  }
}
