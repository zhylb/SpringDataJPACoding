package com.lihd.springdata.test;

import com.lihd.springdata.pojo.Person;
import com.lihd.springdata.repository.PersonRepository;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/28 8:52
 */
public class PersonTest {
    private ClassPathXmlApplicationContext context;

    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }


    /**
     * Test03 :
     */
    @Test
    public void test03 (){
        PersonRepository personRepository = context.getBean(PersonRepository.class);

        System.out.println(personRepository.getClass().getName());

        Person person = personRepository.getByAge(13);
        System.out.println(person);
    }

    /**
     * Test02 :
     */
    @Test
    public void test02 (){

    }

    @Test
    public void test01(){
        DataSource dataSource = context.getBean(DataSource.class);
        System.out.println(dataSource);
    }
}
