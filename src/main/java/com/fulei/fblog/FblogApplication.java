package com.fulei.fblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author fulei
 * @Title: FblogApplication
 * @ProjectName fblog
 * @Description: FblogApplication
 * @date 2019/11/14 17:16
 */
@SpringBootApplication
@ComponentScan(value = {"com.fulei.fblog.controller","com.fulei.fblog.service.impl.jpa"})
@EnableJpaRepositories("com.fulei.fblog.repository")
@EntityScan("com.fulei.fblog.domain")
public class FblogApplication {

  public static void main(String[] args) {
    SpringApplication.run(FblogApplication.class,args);
  }
}
