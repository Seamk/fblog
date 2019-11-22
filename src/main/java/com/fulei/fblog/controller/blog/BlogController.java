package com.fulei.fblog.controller.blog;

import com.fulei.fblog.domain.BlogDo;
import com.fulei.fblog.dto.BlogDto;
import com.fulei.fblog.service.IBlogService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fulei
 * @Title: BlogController
 * @ProjectName fblog
 * @Description: BlogController
 * @date 2019/11/14 17:05
 */
@RestController
public class BlogController {

  @Resource
  private IBlogService blogService;

  @GetMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public BlogDto lookUpBlog(String uuid){
    return blogService.lookUpBlog(uuid);
  }

  @GetMapping("/test")
  @ResponseStatus(HttpStatus.OK)
  public void test(String name){
    blogService.test(name);
  }

}
