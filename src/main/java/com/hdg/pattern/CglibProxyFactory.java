package com.hdg.pattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory implements MethodInterceptor{

    //private Object target;

    public CglibProxyFactory(){
        //this.target=target;
    }

    public <T> T getProxyInstance(Class<T> superClass){
        //工具类
//        Enhancer enhancer=new Enhancer();
//        //设置父类
//        enhancer.setSuperclass(target.getClass());
//        //设置回调函数
//        enhancer.setCallback(this);
//        return (T) enhancer.create();
       return (T) Enhancer.create(superClass,this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务...");
        Object returnValue=methodProxy.invokeSuper(o,objects);
        System.out.println("提交事务...");
        return returnValue;
    }
}
