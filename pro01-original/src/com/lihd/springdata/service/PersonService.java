package com.lihd.springdata.service;

import com.lihd.springdata.pojo.Person;
import com.lihd.springdata.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/28 15:27
 */
@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public void updateNameById(Integer id,String name){
        personRepository.updateNameById(id, name);
    }

    public void save(Iterable<? extends Person> iterable){

        personRepository.save(iterable);
    }
}
