package com.wty.community.dao;

import com.wty.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @className UserMapper
 * @summary
 *      用户相关DAO
 *      增删改查
 * @date 2022/06/03 15:04:30
 */
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
