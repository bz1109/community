# community
社区网页项目课

项目基于Spring Boot实现，重点是**Spring MVC**、**Spring MyBatis**、**Spring Security**，实现的功能和技术如下：

## 用户权限管理
注册、登录、退出、状态、个人设置、授权等
#### 重点：
1. Spring web的三层架构：Controller、Service、DAO；
2. Interceptor拦截器；
3. 会话管理（cookie、session）；
4. 考虑到分布式部署，后期采用redis缓存来替代session以规避session共享问题；
5. 权限管理Spring Security，底层是一系列filter。

## 核心功能
首页、帖子、评论、私信、异常、日志
#### 重点：
1. Advice统一异常处理；
2. AOP面向切面编程，做日志记录；
3. Transaction事务管理；
4. 敏感词，字典树。

## 缓存技术
点赞、关注、网站统计、利用缓存优化性能
#### 重点
1. Redis缓存；
2. Redis的高级数据结构HyperLogLog、bitMap。

## 系统通知
#### 重点
1. Kafka消息队列，Event事件触发；
2. 生产者与消费者模式。

## 搜索功能
#### 重点
1. Elasticsearch，它的索引结构

## 其他
热帖排行、服务器部署、服务器缓存、网站监控
#### 重点
1. Quartz定时Job，底层是线程池技术；
2. Caffeine缓存；
3. Spring Actuator端点监控。

## 总结：
通过这个项目，加深了对Spring的整体框架、MySQL数据库技术和Redis缓存技术以及多并发线程的了解，后续还需要慢慢深入学习~
