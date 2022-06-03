package com.wty.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @className AlphaDaoHibernateImpl
 * @summary 加注解：实现自动扫描
 * @date 2022/06/03 15:02:32
 */
@Repository("alphaHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
