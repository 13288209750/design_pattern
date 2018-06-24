package com.hdg.pattern.proxy;

import com.hdg.dao.IUserDao;
import com.hdg.model.User;

/**
 * 用户代理类(代理对象,静态代理)
 */
public class UserDaoProxy implements IUserDao {

    /**
     * 接收目标对象
     */
    private IUserDao iUserDao;

    public UserDaoProxy(IUserDao userDao){
        this.iUserDao=userDao;
    }

    @Override
    public void save(User user) {
        System.out.println("开始事务...");
        iUserDao.save(user);
        System.out.println("提交事务...");
    }
}
