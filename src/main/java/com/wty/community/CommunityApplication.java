package com.wty.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/*
配置类
 */
@SpringBootApplication
public class CommunityApplication {

    @PostConstruct
    public void init() {
        // 解决 Redis 和 Elasticsearch 共用 Netty导致的 Netty 启动冲突问题
        // see Netty4Utils.setAvailableProcessors()
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

    public static void main(String[] args) {
        //底层启动了Tomcat、创建了Spring容器，扫描bean
        SpringApplication.run(CommunityApplication.class, args);
    }

}
