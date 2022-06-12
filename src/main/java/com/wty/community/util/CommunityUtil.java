package com.wty.community.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @className CommunityUtil
 * @summary 常用工具包封装：
 * 随机字符串生成
 * MD5加密
 * 检查密码是否符合要求
 * JSON字符串获取
 * @date 2022/06/03 14:56:31
 */
public class CommunityUtil {
    // 生成随机字符串
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    // MD5对密码进行加密
    // 只能加密，但是不能解密，且同样的原文加密结果一致
    // 因此原文过于简单也会被破解（黑客掌握一些简单的原文的加密后的结果）
    // 例如 hello -> abc123def435
    // hello + 3e4a8（salt 字段 随机字符串） 再次加密 ->  abc123def346125，提高加密性
    public static String md5(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

    // 检查密码是否符合要求
    // 要求密码在 8 - 12 位，并且至少含有大、小写字母和数字中的两种
    public static boolean isAvailablePassword(String password) {
        int len = password.length();
        if (len < 8 || len > 12) {
            return false;
        }
        boolean hasDigit = false;
        boolean hasLetter = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (Character.isLetter(c)) {
                hasLetter = true;
            }
        }
        String regex = "^\\w{8,12}$";
        return hasDigit && hasLetter && password.matches(regex);

    }

    // 转为json字符串
    public static String getJSONString(int code, String msg, Map<String, Object> map) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        if (map != null) {
            for (String key : map.keySet()) {
                json.put(key, map.get(key));
            }
        }
        return json.toJSONString();
    }

    public static String getJSONString(int code, String msg) {
        return getJSONString(code, msg, null);
    }

    public static String getJSONString(int code) {
        return getJSONString(code, null, null);
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", 23);
        System.out.println(getJSONString(0, "ok", map));
    }
}
