package com.fulei.fblog.service.impl.jpa;

import com.fulei.fblog.cache.BitSetIndexModel;
import com.fulei.fblog.cache.BlogIndexStore;
import com.fulei.fblog.domain.BlogDo;
import com.fulei.fblog.dto.BlogDto;
import com.fulei.fblog.repository.BlogRepository;
import com.fulei.fblog.service.IBlogService;
import com.fulei.fblog.utils.CheckUtil;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author fulei
 * @Title: BlogServiceImpl
 * @ProjectName fblog
 * @Description: BlogServiceImpl
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
    if(blogDoOptional.isPresent()){
      BeanUtils.copyProperties(blogDoOptional.get(),blogDto);
    }
    return blogDto;
  }

  @Override
  public void test(String name) {
    List<BlogDo> blogDos = blogRepository.findAll();
    BlogIndexStore.INSTANCE.createIndex(blogDos);
    long time = System.nanoTime();
    List<Integer> blogIndexList =  BitSetIndexModel.getRealIndexs(BlogIndexStore.INSTANCE.query(name,"0"));
    List<BlogDo> blogDos2 = Lists.newArrayList();
    for(Integer index:blogIndexList){
      blogDos2.add(BlogIndexStore.INSTANCE.getBlog(index));
    }
    System.out.println("结果："+blogDos2);
    long nowtime = System.nanoTime();
    System.out.println("bitSet时间差："+(nowtime-time));
    long time1 = System.nanoTime();
    List<BlogDo> blogDos1 = blogDos.stream().filter(value->value.getAuthor().equals(name)).filter(value->value.getStatus().intValue()==0).collect(Collectors.toList());
    System.out.println("结果："+blogDos1);
    long time2 = System.nanoTime();
    System.out.println("stream时间差:"+(time2-time1));
  }
}
