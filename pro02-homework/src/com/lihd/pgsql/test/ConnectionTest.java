package com.lihd.pgsql.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/29 17:35
 */
public class ConnectionTest {
    private ClassPathXmlApplicationContext context;

    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testGetConnection(){
        DataSource dataSource = context.getBean(DataSource.class);
        System.out.println(dataSource);
    }
}
