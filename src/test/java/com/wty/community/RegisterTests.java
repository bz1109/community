package com.wty.community;

import com.wty.community.util.CommunityUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class RegisterTests {

    @Test
    public void checkPassword() {
        System.out.println(CommunityUtil.isAvailablePassword("1111"));
        System.out.println(CommunityUtil.isAvailablePassword("123456789"));
        System.out.println(CommunityUtil.isAvailablePassword("123ad1789"));
        System.out.println(CommunityUtil.isAvailablePassword("12ad1AA8_@9"));
        System.out.println(CommunityUtil.isAvailablePassword("123ad1AA81249"));
        System.out.println(CommunityUtil.isAvailablePassword("123ad1AA81"));
    }
}
