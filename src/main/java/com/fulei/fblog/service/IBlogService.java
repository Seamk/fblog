package com.fulei.fblog.service;

import com.fulei.fblog.dto.BlogDto;

/**
 * @author fulei
 * @Title: IBlogService
 * @ProjectName fblog
 * @Description: TODO
 * @date 2019/11/14 17:06
 */
public interface IBlogService {

   BlogDto lookUpBlog(String uuid);

}
