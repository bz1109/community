package com.wty.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary    //加载Bean时，优先加载
public class AlphaDaoMyBatisImpl implements AlphaDao{
    @Override
    public String select() {
        return "MyBatis";
    }
}
