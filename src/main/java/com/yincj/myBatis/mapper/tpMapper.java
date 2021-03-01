package com.yincj.myBatis.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface tpMapper {
    //获取表内容
    com.yincj.myBatis.entity.yincjTp selectByTemp(String applCde);//后续优化
    int insertTp(com.yincj.myBatis.entity.yincjTp yt);
   //void insert(com.yincj.myBatis.entity.yincjTp yt);
    int update(com.yincj.myBatis.entity.yincjTp yt);
    int delete(String applCde);//后续优化

}
