package com.fulei.fblog.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author fulei
 * @Title: UserInfoDo
 * @ProjectName ferry
 * @Description: UserInfoDo
 * @date 2019/11/5 16:05
 */
@Entity
@Data
@Table(name = "user_info")
public class UserInfoDo {

  @Id
  @GeneratedValue(generator="user_uuid")
  @GenericGenerator(name="user_uuid",strategy="uuid")
  @Column(unique = true, nullable = false, length = 20)
  private String uuid;

  private String userName;

  private String realName;

  private String password;
}
