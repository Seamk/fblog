package com.fulei.fblog.cache;

import com.fulei.fblog.domain.BlogDo;
import com.google.common.collect.Maps;
import java.util.BitSet;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import org.springframework.util.CollectionUtils;

/**
 * @author fulei
 * @Title: BlogIndexStore
 * @ProjectName flog
 * @Description: BlogIndexStore
 * @date 2019/11/21 17:39
 */
public class BlogIndexStore {
  private static final String BLOGAUTOR = "blogAutor";
  private static final String BLOGSTATUS = "blogStatus";

  private BitSetIndexModel authorModel;
  private BitSetIndexModel statusModel;

  private ConcurrentMap<Integer,BlogDo> blogMap;
  private ConcurrentMap<String,Integer> uuidMap;

  public static final BlogIndexStore INSTANCE = getInstance();

  private static BlogIndexStore getInstance(){
     return BlogIndexStoreHolder.instance;
  }

  private static class BlogIndexStoreHolder{
    private static BlogIndexStore instance = new BlogIndexStore();
  }

  private BlogIndexStore(){
    init();
  }

  private void init(){
    authorModel = new BitSetIndexModel(BLOGAUTOR);
    statusModel = new BitSetIndexModel(BLOGSTATUS);
    blogMap = Maps.newConcurrentMap();
    uuidMap = Maps.newConcurrentMap();
  }

  public void createIndex(List<BlogDo> blogs){
    if(!CollectionUtils.isEmpty(blogs)){
      for(int index =0;index<blogs.size();index++){
        BlogDo blog = blogs.get(index);
        createIndex(blog,index);
      }
    }
  }

  private void createIndex(BlogDo blog, int index) {
    authorModel.createIndex(blog.getAuthor(),index);
    statusModel.createIndex(blog.getStatus().toString(),index);
    blogMap.put(index,blog);
    uuidMap.put(blog.getUuid(),index);
  }

  public BitSet query(String author,String status){
    BitSet bitSet = null;
    bitSet = authorModel.and(author,bitSet);
    bitSet = statusModel.and(status,bitSet);
    return bitSet;
  }

  public BlogDo getBlog(Integer index){
    return blogMap.get(index);
  }

  public void updateIndex(BlogDo blogDo){
    Integer index = uuidMap.get(blogDo.getUuid());
    if(index!=null){
      /*更新*/
      clear(index);
      update(blogDo,index);
      blogMap.put(index,blogDo);
      uuidMap.put(blogDo.getUuid(),index);
    }else{
      /*添加*/
      synchronized (this) {
        createIndex(blogDo, blogMap.size()+1);
      }
    }
  }

  private void clear(Integer index){
      authorModel.clear(index);
      statusModel.clear(index);
  }

  private void update(BlogDo blogDo,Integer index){
    blogMap.put(index,blogDo);
    authorModel.update(blogDo.getAuthor(),index);
  }

}
