package com.wty.community.dao;

import com.wty.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

/**
 * @className LoginTicketMapper
 * @summary
 *      登录凭证相关DAO：
 *      插入、查找、更新状态
 * @date 2022/06/03 15:03:47
 */
@Mapper
public interface LoginTicketMapper {
    @Insert({
            "insert into login_ticket (user_id, ticket, status, expired) "+
            "values (#{userId},#{ticket},#{status},#{expired})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({
            "select id,user_id,ticket,status,expired "+
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    @Update({
            "<script>"+
            "update login_ticket set status=#{status} where ticket=#{ticket} "+
            "<if test=\"ticket!=null\"> "+
            "and 1=1 "+
            "</if>"+
            "</script>"
    })
    int updateStatus(String ticket, int status);
}
