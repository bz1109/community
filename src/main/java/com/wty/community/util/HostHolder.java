package com.wty.community.util;

import com.wty.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * @className HostHolder
 * @summary
 *      用户容器：
 *      持有用户信息，用于代替session对象，实现线程隔离
 * @date 2022/06/03 14:59:43
 */
@Component
public class HostHolder {

    private final ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }

}
