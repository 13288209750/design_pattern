package com.hdg.pattern.proxy;

import com.hdg.dao.IStudentDao;
import com.hdg.dao.IUserDao;
import com.hdg.dao.impl.CGLIBStudentDao;
import com.hdg.dao.impl.StudentDaoImpl;
import com.hdg.dao.impl.UserDaoImpl;
import com.hdg.model.Student;
import com.hdg.model.User;
import com.hdg.pattern.CglibProxyFactory;
import com.hdg.pattern.ProxyFactory;

/**
 * 测试类--代理模式
 */
public class ProxyPattern {


    public static void main(String[] args) {
        //静态
        //staticProxy();
        //dynamicProxy();
        cglibProxy();
    }

    /**
     * 静态代理模式
     * 代理对象与目标对象要实现相同的接口,然后通过调用相同的方法来调用目标对象的方法
     * 静态代理总结:
         1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
         2.缺点:

         因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
         如何解决静态代理中的缺点呢?答案是可以使用动态代理方式
     */
    private static void staticProxy(){
        User user=new User();
        user.setAge(23);
        user.setDescribe("我是大学生");
        user.setName("张三");
        IUserDao userDao=new UserDaoImpl();
        IUserDao userDaoProxy=new UserDaoProxy(userDao);
        userDaoProxy.save(user);
    }

    /**
     * 动态代理模式
     * 动态代理有以下特点:
         1.代理对象,不需要实现接口
         2.代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
         3.动态代理也叫做:JDK代理,接口代理
     */
    private static void dynamicProxy(){
        User user=new User();
        user.setAge(26);
        user.setDescribe("我是研究生");
        user.setName("李四");
        //目标对象
        IUserDao userDao=new UserDaoImpl();
        //【原始的类型  com.hdg.dao.impl.UserDaoImpl】
        System.out.println(userDao.getClass());
        //给目标对象，创建代理对象
        IUserDao proxy1= (IUserDao) new ProxyFactory(userDao).getProxyInstance();
        //class $proxy 内存中动态生成代理的代理对象
        //执行方法
        proxy1.save(user);

        //代理学生
        Student student=new Student();
        student.setAge(25);
        student.setName("王五");
        IStudentDao studentDao=new StudentDaoImpl();
        IStudentDao proxy2= (IStudentDao) new ProxyFactory(studentDao).getProxyInstance();
        proxy2.save(student);
    }

    private static void cglibProxy(){
        Student student=new Student();
        student.setAge(25);
        student.setName("王五");
        CGLIBStudentDao iStudentDao= new CglibProxyFactory().getProxyInstance(CGLIBStudentDao.class);
        iStudentDao.save(student);
    }


}
