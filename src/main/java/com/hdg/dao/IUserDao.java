package com.hdg.dao;

import com.hdg.model.User;

/**
 * 用户持久化接口
 */
public interface IUserDao {

    /**
     * 保存
     */
    void save(User user);
}
