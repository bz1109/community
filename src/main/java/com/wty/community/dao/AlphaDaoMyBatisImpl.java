package com.wty.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @className AlphaDaoMyBatisImpl
 * @summary Primary注解，加载Bean时，优先加载
 * @date 2022/06/03 15:02:45
 */
@Repository
@Primary
public class AlphaDaoMyBatisImpl implements AlphaDao{
    @Override
    public String select() {
        return "MyBatis";
    }
}
