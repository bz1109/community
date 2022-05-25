package com.wty.community.dao;

import com.wty.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // @Param用于参数取别名
    // 如果动态拼接条件<if>里使用，并且只有一个参数，必须取别名
    int selectDiscussPostRows(@Param("userId") int userId);
}