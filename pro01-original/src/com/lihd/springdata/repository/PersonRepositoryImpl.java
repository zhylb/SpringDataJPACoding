package com.lihd.springdata.repository;

import com.lihd.springdata.dao.PersonDAO;
import com.lihd.springdata.pojo.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/28 19:20
 */
@Repository
public class PersonRepositoryImpl implements PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void getAPerson() {
        Person person = entityManager.find(Person.class, 1);
        System.out.println("person = " + person);
    }
}
