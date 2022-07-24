package com.lihd.springdata.test;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.lihd.springdata.pojo.Person;
import com.lihd.springdata.repository.PersonRepository;
import com.lihd.springdata.service.PersonService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/28 15:43
 */
public class PersonRepositoryTest2 {
    private ClassPathXmlApplicationContext context;
    private PersonRepository personRepository;
    private PersonService personService;
    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        personRepository = context.getBean(PersonRepository.class);
        personService = context.getBean(PersonService.class);
    }

    @Test
    public void testCrudSave(){

        ArrayList<Person> personArrayList = new ArrayList<>();

        for (int i = 'A'; i < 'Z'; i++) {
            String name =  (char) i + UUID.randomUUID().toString().substring(0, 9);
            Person person = new Person();
            person.setAddressId(i);
            person.setAge(i - 30);
            person.setBirthDay(new Date());
            person.setEmail(name + "@gmail.com");
            person.setName(name);

            personArrayList.add(person);
        }

        personService.save(personArrayList);

    }


    @Test
    public void testPagingAndSortingRepository(){

        int pageNum = 3 - 1;//pageNum从0开始
        int pageSize = 5;

        Pageable pageable = new PageRequest(pageNum,pageSize);
        Page<Person> page = personRepository.findAll(pageable);

        int totalPages = page.getTotalPages();
        long totalElements = page.getTotalElements();
        Sort pageSort = page.getSort();
        int size = page.getSize();
        int numberOfElements = page.getNumberOfElements();
        int number = page.getNumber() + 1;//上面-1 这里应该+1

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("pageSort = " + pageSort);
        System.out.println("size = " + size);
        System.out.println("numberOfElements = " + numberOfElements);
        System.out.println("number = " + number);

        for (Person person : page.getContent()) {
            System.out.println(person);
        }

    }

    @Test
    public void testPagingAndSortingRepository2(){

        int pageNum = 3 - 1;
        int pageSize = 5;

        Sort.Order nameOrder = new Sort.Order(Sort.Direction.DESC, "name");
        Sort.Order ageOrder = new Sort.Order(Sort.Direction.ASC, "age");
        Sort sort = new Sort(nameOrder,ageOrder);

        Pageable pageable = new PageRequest(pageNum,pageSize,sort);
        Page<Person> page = personRepository.findAll(pageable);

        for (Person person : page.getContent()) {
            System.out.println(person);
        }
    }

    @Test
    public void testJpaRepository(){
        Person person = new Person();
        person.setName("jpa");
        person.setBirthDay(new Date());
        person.setAge(26);
        person.setEmail("JPA@SpringData");

        person.setId(30);

        Person person1 = personRepository.saveAndFlush(person);
        System.out.println(person1 == person);
    }

    @Test
    public void testJpaSpecificationExecutor(){


        int pageNum = 3 - 1;
        int pageSize = 5;


        Sort.Order nameOrder = new Sort.Order(Sort.Direction.DESC, "name");
        Sort.Order ageOrder = new Sort.Order(Sort.Direction.ASC, "age");
        Sort sort = new Sort(nameOrder,ageOrder);

        PageRequest pageRequest = new PageRequest(pageNum,pageSize,sort);

        Specification<Person> specification = new Specification<Person>() {
            /**
             * @param *root: 代表查询的实体类.
             * @param query: 可以从中可到 Root 对象, 即告知 JPA Criteria 查询要查询哪一个实体类. 还可以
             * 来添加查询条件, 还可以结合 EntityManager 对象得到最终查询的 TypedQuery 对象.
             * @param *cb: CriteriaBuilder 对象. 用于创建 Criteria 相关对象的工厂. 当然可以从中获取到 Predicate 对象
             * @return: *Predicate 类型, 代表一个查询条件.
             */
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path id = root.get("id");

                Predicate predicate = cb.gt(id, 5);

                return predicate;
            }
        };

        Page<Person> page = personRepository.findAll(specification, pageRequest);

        int totalPages = page.getTotalPages();
        long totalElements = page.getTotalElements();
        Sort pageSort = page.getSort();
        int size = page.getSize();
        int numberOfElements = page.getNumberOfElements();
        int number = page.getNumber() + 1;//上面-1 这里应该+1

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("pageSort = " + pageSort);
        System.out.println("size = " + size);
        System.out.println("numberOfElements = " + numberOfElements);
        System.out.println("number = " + number);



        for (Person person : page.getContent()) {
            System.out.println(person);
        }


    }

    @Test
    public void testMyRepository(){
        personRepository.getAPerson();
    }

//    @Test
//    public void testLog(){
//        personRepository.log();
//    }

}
