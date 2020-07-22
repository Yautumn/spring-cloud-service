package com.yautumn.common.reflect;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class BaseService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 通过反射调用mapper中的方法
     * @param list
     * @param clazz
     * @param methodName
     */
    public void batch(List<?> list, Class clazz,String methodName) {
        try {
            Class c = Class.forName(clazz.getName());
            Object obj = Proxy.newProxyInstance(c.getClassLoader(),
                    new Class[]{c},
                    new MyInvocationHandler(sqlSessionFactory.openSession().getMapper(c)));

            Method m = obj.getClass().getDeclaredMethod(methodName,List.class);
            m.invoke(obj,list);

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
