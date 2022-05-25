package com.wty.community.dao;

import com.wty.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
//@Repository 也行
public interface UserMapper {
    User selectById(int id);

    User selectByName(String userName);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);
}
