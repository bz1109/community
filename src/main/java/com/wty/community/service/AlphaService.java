package com.wty.community.service;

import com.wty.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * @className AlphaService
 * @summary
 *      Spring容器管理示例
 * @date 2022/06/03 14:55:04
 */
@Service
//默认为单例并且启动时初始化："singleton"，单例可能有线程安全问题
//加"prototype"，每次getBean实例化一次，且不销毁
@Scope("prototype")
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;

    public AlphaService() {
        System.out.println("实例化AlphaService");
    }

    @PostConstruct  //构造器之后调用
    public void init() {
        System.out.println("初始化AlphaService");
    }

    @PreDestroy //对象销毁之前
    public void destroy() {
        System.out.println("销毁AlphaService");
    }

    public String find(){
        return alphaDao.select();
    }
}
