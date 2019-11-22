package com.fulei.fblog.cache;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.BitSet;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author fulei
 * @Title: BitSetIndexModel
 * @ProjectName flog
 * @Description: BitSetIndexModel
 * @date 2019/11/21 15:12
 */
@Data
@RequiredArgsConstructor
public class BitSetIndexModel {

  @NonNull
  private String type;

  private ConcurrentMap<String,Integer> indexBsMap = Maps.newConcurrentMap();

  private List<String> typeValueList = Lists.newArrayList();

  private List<BitSet> bsList = Lists.newArrayList();

  public void createIndex(String type,int i){
    BitSet bitSet;
    Integer index = indexBsMap.get(type);
    if(index !=null){
      bitSet = bsList.get(index);
      if(bitSet == null){
         bitSet = new BitSet();
         bsList.add(index,bitSet);
      }
      bitSet.set(i,true);
    }else{
      bitSet  = new BitSet();
      typeValueList.add(type);
      index = typeValueList.size()-1;
      bitSet.set(i,true);
      bsList.add(index,bitSet);
      indexBsMap.put(type,index);
    }

  }

  public BitSet get(String type){
    BitSet bitSet;
    type = type.toLowerCase();
    Integer index = indexBsMap.get(type);
    if(index == null){
      bitSet = new BitSet();
    }else{
      bitSet = bsList.get(index);
    }
    return bitSet;
  }

  public BitSet and(String type,BitSet bitSet){
    if(type!=null){
       type = type.toLowerCase();
       if(bitSet !=null){
          bitSet.and(get(type));
       }else{
         bitSet = new BitSet();
         bitSet.or(get(type));
       }
    }
    return bitSet;
  }

  public BitSet or(String type,BitSet bitSet){
    if(type!=null){
      type = type.toLowerCase();
      if(bitSet!=null){
        bitSet.or(get(type));
      }else{
        bitSet = new BitSet();
        bitSet.or(get(type));
      }
    }
    return bitSet;
  }

  public static List<Integer> getRealIndexs(BitSet bitSet){
    List<Integer> indexs = Lists.newArrayList();
    if(bitSet!=null){
       int i = bitSet.nextSetBit(0);
       if(i!=-1){
         indexs.add(i);
         for(i= bitSet.nextSetBit(i+1);i>=0;i=bitSet.nextSetBit(i+1)){
           int endOfRun = bitSet.nextClearBit(i);
           do{
             indexs.add(i);
           }while(++i<endOfRun);
         }
       }
    }
    return indexs;
  }

  public void clear(Integer index){
    for (BitSet bs : bsList) {
      if (bs != null && index < bs.length()) {
        bs.clear(index);
      }
    }
  }

  public void update(String type,Integer index){
    createIndex(type,index);
  }






































}
