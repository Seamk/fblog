package com.fulei.fblog.repository;


import com.fulei.fblog.domain.UserInfoDo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fulei
 * @Title: UserInfoRepository
 * @ProjectName ferry
 * @Description: UserInfoRepository
 * @date 2019/11/5 16:56
 */
public interface UserInfoRepository extends JpaRepository<UserInfoDo,String> {

  UserInfoDo findByUserName(String userName);

}
