package com.lihd.springdata.test;

import com.lihd.springdata.pojo.Person;
import com.lihd.springdata.repository.PersonRepository;
import com.lihd.springdata.service.PersonService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PersonRepositoryTest {
    private ClassPathXmlApplicationContext context;
    private PersonRepository personRepository;
    private PersonService personService;
    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        personRepository = context.getBean(PersonRepository.class);
        personService = context.getBean(PersonService.class);
    }


    @Test
    public void getByAge() {
        Person byAge = personRepository.getByAge(18);
        System.out.println(byAge);
    }

    @Test
    public void getByAgeGreaterThanAndNameLike() {
        List<Person> personList = personRepository.getByAgeGreaterThanAndNameLike(11, "%太%");
        System.out.println(personList);
    }

    @Test
    public void getByNameEndingWithAndAgeLessThanEqual() {
        List<Person> personList = personRepository.getByNameEndingWithAndAgeLessThanEqual("白", 18);
        System.out.println(personList);
    }

    @Test
    public void getByNameInAndBirthDayAfter() {
        ArrayList<String> list = new ArrayList<>();
        list.add("李太白");
        list.add("大白");

        List<Person> personList = personRepository.getByNameInOrBirthDayLessThan(list, new Date());
        System.out.println(personList);


    }

    @Test
    public void getByAddressIdGreaterThan() {
        List<Person> personList = personRepository.getByAddressIdGreaterThan(1);
        System.out.println(personList);
    }

    @Test
    public void getByAddress_IdGreaterThan() {
        List<Person> personList = personRepository.getByAddress_IdGreaterThan(1);
        System.out.println(personList);
    }

    @Test
    public void getMaxIdPerson(){
        Person maxIdPerson = personRepository.getMaxIdPerson();
        System.out.println(maxIdPerson);
    }

    @Test
    public void testQueryAnnotationParam() {
        List<Person> 大白 = personRepository.testQueryAnnotationParam("大白", "654");
        System.out.println(大白);
    }

    @Test
    public void testQueryAnnotationParam2() {
        List<Person> 大白 = personRepository.testQueryAnnotationParam("大白", "654");
        System.out.println(大白);
    }

    @Test
    public void testQueryAnnotationLikeParam() {
        List<Person> personList = personRepository.testQueryAnnotationLikeParam("太", "2");
        System.out.println(personList);
    }

    @Test
    public void testQueryAnnotationLikeParam2() {
        List<Person> personList = personRepository.testQueryAnnotationLikeParam("太", "2");
        System.out.println(personList);
    }

    @Test
    public void testNativeQuery() {
        Long aLong = personRepository.testNativeQuery();
        System.out.println(aLong);
    }

    @Test
    public void updateNameById(){
        personRepository.updateNameById(3,"我就是太阳");
    }

    @Test
    public void updateNameById2(){
        personService.updateNameById(3,"我就是太阳");
    }

}