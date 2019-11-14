package com.fulei.fblog.service.impl.jpa;

import com.fulei.fblog.domain.BlogDo;
import com.fulei.fblog.dto.BlogDto;
import com.fulei.fblog.repository.BlogRepository;
import com.fulei.fblog.service.IBlogService;
import com.fulei.fblog.utils.CheckUtil;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author fulei
 * @Title: BlogServiceImpl
 * @ProjectName fblog
 * @Description: TODO
 * @date 2019/11/14 17:07
 */
@Service
public class BlogServiceImpl implements IBlogService {

  @Resource
  private BlogRepository blogRepository;

  @Override
  public BlogDto lookUpBlog(String uuid) {
    BlogDto blogDto = new BlogDto();
    CheckUtil.check(StringUtils.isEmpty(uuid),"");
    Optional<BlogDo> blogDoOptional = blogRepository.findById(uuid);
    BeanUtils.copyProperties(blogDoOptional.get(),blogDto);
    return blogDto;
  }
}
