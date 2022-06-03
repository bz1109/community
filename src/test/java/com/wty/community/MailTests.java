package com.wty.community;

import com.wty.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {
        mailClient.sendMail("1437421011@qq.com", "TEST","test");
    }

    @Test
    public void testHtmlMail() {
        // org.thymeleaf.context.Context;
        // 模板负责格式化html内容
        Context context = new Context();
        context.setVariable("username","Cyndi Wang");
        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);
        mailClient.sendMail("1437421011@qq.com", "HTML",content);
    }
}
