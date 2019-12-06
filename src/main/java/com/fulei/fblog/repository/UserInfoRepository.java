package com.fulei.fblog.repository;


import com.fulei.fblog.domain.UserInfoDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author fulei
 * @Title: UserInfoRepository
 * @ProjectName ferry
 * @Description: UserInfoRepository
 * @date 2019/11/5 16:56
 */
@RepositoryRestResource(path="user")
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoDo,String> {

  UserInfoDo findByUserName(String userName);

}
