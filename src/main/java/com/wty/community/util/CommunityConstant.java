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

    /*
     * 实体类型：帖子、评论、用户
     */
    int ENTITY_TYPE_POST = 1;
    int ENTITY_TYPE_COMMENT = 2;
    int ENTITY_TYPE_USER=3;

    /*
     * kafka主题：评论、点赞、关注、删帖、分享
     */
    String TOPIC_COMMENT = "comment";
    String TOPIC_LIKE = "like";
    String TOPIC_FOLLOW = "follow";
    String TOPIC_PUBLISH = "publish";
    String TOPIC_DELETE = "delete";
    String TOPIC_SHARE = "share";

    /*
     * 系统用户ID
     */
    int SYSTEM_USER_ID = 1;

    /*
     * 权限：普通用户、管理员、版主
     */
    String AUTHORITY_USER = "user";
    String AUTHORITY_ADMIN = "admin";
    String AUTHORITY_MODERATOR = "moderator";

}
