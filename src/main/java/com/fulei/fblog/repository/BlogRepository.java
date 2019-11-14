package com.fulei.fblog.repository;

import com.fulei.fblog.domain.BlogDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author fulei
 * @Title: BlogRepository
 * @ProjectName ferry
 * @Description: BlogRepository
 * @date 2019/11/4 16:47
 */
@Repository
public interface BlogRepository extends JpaRepository<BlogDo,String> {

}
