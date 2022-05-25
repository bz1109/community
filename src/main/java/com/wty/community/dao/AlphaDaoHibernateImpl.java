package com.wty.community.dao;

import org.springframework.stereotype.Repository;
//加注解：实现自动扫描
@Repository("alphaHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
