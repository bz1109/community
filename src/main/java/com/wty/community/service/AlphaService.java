package com.wty.community.service;

import com.wty.community.dao.AlphaDao;
import com.wty.community.dao.DiscussPostMapper;
import com.wty.community.dao.UserMapper;
import com.wty.community.entity.DiscussPost;
import com.wty.community.entity.User;
import com.wty.community.util.CommunityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;


/**
 * @className AlphaService
 * @summary Spring容器管理示例
 * @date 2022/06/03 14:55:04
 */
@Service
//默认为单例并且启动时初始化："singleton"，单例可能有线程安全问题
//加"prototype"，每次getBean实例化一次，且不销毁
@Scope("prototype")
public class AlphaService {

    private Logger logger = LoggerFactory.getLogger(AlphaService.class);

    @Autowired
    private AlphaDao alphaDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public AlphaService() {
//        System.out.println("实例化AlphaService");
    }

    @PostConstruct  //构造器之后调用
    public void init() {
//        System.out.println("初始化AlphaService");
    }

    @PreDestroy //对象销毁之前
    public void destroy() {
//        System.out.println("销毁AlphaService");
    }

    public String find() {
        return alphaDao.select();
    }


    /**
     * 声明式事务：XML、注解
     * <p>
     * A事务 之中 调用 B事务，B事务注解给出propagation
     * REQUIRED     ：支持当前事务（外部事务），如果不存在外部事务，创建新事务
     * REQUIRES_NEW ：创建新事务，并且暂停外部事务
     * NESTED       ：如果当前存在外部事务，则嵌套在该事务中执行（独立的提交和回滚），否则与 REQUIRED 一样
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Object save1() {
        // 新增用户
        User user = new User();
        user.setUsername("alpha");
        user.setSalt(CommunityUtil.generateUUID().substring(0, 5));
        user.setPassword(CommunityUtil.md5("123" + user.getSalt()));
        user.setEmail("alpha@qq.com");
        user.setHeaderUrl("http://image.nowcoder.com/head/99y.png");
        user.setCreateTime(new Date());
        userMapper.insertUser(user);
        // 新增帖子
        DiscussPost post = new DiscussPost();
        post.setUserId(user.getId());
        post.setTitle("hello transaction");
        post.setContent("transaction management");
        post.setCreateTime(new Date());
        discussPostMapper.insertDiscussPost(post);

        int n = Integer.parseInt("abc");

        return "ok";
    }

    // 编程式 事务管理
    public Object save2() {
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        return transactionTemplate.execute(new TransactionCallback<Object>() {

            @Override
            public Object doInTransaction(TransactionStatus status) {
                // 新增用户
                User user = new User();
                user.setUsername("beta");
                user.setSalt(CommunityUtil.generateUUID().substring(0, 5));
                user.setPassword(CommunityUtil.md5("123" + user.getSalt()));
                user.setEmail("beta@qq.com");
                user.setHeaderUrl("http://image.nowcoder.com/head/999t.png");
                user.setCreateTime(new Date());
                userMapper.insertUser(user);
                // 新增帖子
                DiscussPost post = new DiscussPost();
                post.setUserId(user.getId());
                post.setTitle("你好 transaction");
                post.setContent("你好 事务管理");
                post.setCreateTime(new Date());
                discussPostMapper.insertDiscussPost(post);

                int n = Integer.parseInt("abc");

                return "ok";
            }
        });
    }

    // 可以让该方法再多线程环境下，被异步调用
    @Async
    public void execute1() {
        logger.debug("execute1");
    }
//    定时任务线程池
//    @Scheduled(initialDelay = 1000 * 10, fixedRate = 1000)
//    public void execute2() {
//        logger.debug("execute2");
//    }

}
