package com.hdg.dao.impl;

import com.hdg.dao.IUserDao;
import com.hdg.model.User;

/**
 * 接口实现对象
 */
public class UserDaoImpl implements IUserDao {


    @Override
    public void save(User user) {
        System.out.println("---保存数据---");
        System.out.println(user);
        System.out.println("---保存成功---");
    }
}
