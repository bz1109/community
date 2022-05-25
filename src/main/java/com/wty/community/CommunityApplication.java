package com.wty.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
配置类
 */
@SpringBootApplication
public class CommunityApplication {

	public static void main(String[] args) {
		//底层启动了Tomcat、创建了Spring容器，扫描bean
		SpringApplication.run(CommunityApplication.class, args);
	}

}
