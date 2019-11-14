package com.fulei.fblog.domain;

import java.util.Date;
import javax.persistence.MappedSuperclass;
import lombok.Data;

/**
 * @author fulei
 * @Title: BaseDo
 * @ProjectName fblog
 * @Description: TODO
 * @date 2019/11/14 17:00
 */
@Data
@MappedSuperclass
public class BaseDo {

  private Long createdBy;

  private Date createdTime;

  private Long updatedBy;

  private Date updatedTime;

}
