package com.wty.community.util;

/**
 * @className CommunityConstant
 * @summary
 *      自定义常量接口
 * @date 2022/06/03 14:55:50
 */
public interface CommunityConstant {
    /*
    激活成功
     */
    int ACTIVATION_SUCCESS = 0;

    /*
    重复激活
     */
    int ACTIVATION_REPEAT = 1;

    /*
    激活失败
     */
    int ACTIVATION_FAILURE = 2;

    /*
    默认状态登录凭证超时时间，12小时
     */
    int DEFAULT_EXPIRED_SECONDS = 3600 * 12;

    /*
    记住我状态 登录凭证超时时间，100天
     */
    int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 100;
}
