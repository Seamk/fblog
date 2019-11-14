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
 * @Title: BlogDo
 * @ProjectName BlogDo
 * @Description: BlogDo
 * @date 2019/11/14 16:54
 */
@Entity
@Data
@Table(name = "blog")
public class BlogDo extends BaseDo{

  @Id
  @GeneratedValue(generator="blog_uuid")
  @GenericGenerator(name="blog_uuid",strategy="uuid")
  @Column(unique = true, nullable = false, length = 20)
  private String uuid;

  private String title;

  private String author;

}
