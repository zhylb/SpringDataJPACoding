package com.lihd.springdata.repository;

import com.lihd.springdata.dao.PersonDAO;
import com.lihd.springdata.pojo.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/28 9:03
 */
//@RepositoryDefinition(domainClass = Person.class,idClass = Integer.class)
public interface PersonRepository extends JpaRepository<Person,Integer> , JpaSpecificationExecutor<Person> , PersonDAO{

    Person getByAge(Integer age);

    //where age > ? and name like ?
    List<Person> getByAgeGreaterThanAndNameLike(Integer age,String name);

    //where name like %? and age <= ?
    List<Person> getByNameEndingWithAndAgeLessThanEqual(String name,Integer age);

    //where name in (?,?,..) and birth > ?
    List<Person> getByNameInOrBirthDayLessThan(List<String > names, Date birth);

//    //where a.id > ?
    List<Person> getByAddressIdGreaterThan(Integer id);

    List<Person> getByAddress_IdGreaterThan(Integer id);

    @Query("select p from Person p where p.id = (select max(p2.id) from Person p2)")
    Person getMaxIdPerson();

    @Query("select p from Person p where p.name = ?1 and p.email = ?2")
    List<Person> testQueryAnnotationParam(String name,String email);

    @Query("select p from Person p where p.name = :name and p.email = :email")
    List<Person> testQueryAnnotationParam2(@Param("name") String name,@Param("email") String email);


    @Query("select p from Person p where p.name like %?1% and p.email like %?2%")
    List<Person> testQueryAnnotationLikeParam(String name,String email);

    @Query("select p from Person p where p.name like %:name% and p.email like %:email%")
    List<Person> testQueryAnnotationLikeParam2(@Param("name") String name,@Param("email") String email);


    @Query(value = "select count(*) from t_person",nativeQuery = true)
    Long testNativeQuery();


    @Modifying
    @Query("update Person p set p.name = :name where p.id = :id")
    void updateNameById(@Param("id") Integer id,@Param("name") String name);




}
