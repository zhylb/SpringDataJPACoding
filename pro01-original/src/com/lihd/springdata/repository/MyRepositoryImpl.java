//package com.lihd.springdata.repository;
//
//import com.sun.xml.internal.bind.v2.model.core.ID;
//import org.springframework.data.jpa.repository.support.JpaEntityInformation;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//import org.springframework.data.repository.NoRepositoryBean;
//
//import javax.persistence.EntityManager;
//import java.io.Serializable;
//
///**
// * @author ：葬花吟留别1851053336@qq.com
// * @description：TODO
// * @date ：2022/4/28 19:34
// */
//@NoRepositoryBean
//public class MyRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID>{
//
//
//    private  Class<T> domainClass;
////    public MyRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
////        super(entityInformation, entityManager);
////    }
//
//    public MyRepositoryImpl(Class<T> domainClass, EntityManager em) {
//        super(domainClass, em);
//        this.domainClass = domainClass;
//    }
//
////    public MyRepositoryImpl() {
////        this(null,null);
////
////    }
//
//
//
//    @Override
//    public void log() {
//        System.out.println("MyRepositoryImpl.log" + System.currentTimeMillis());
//    }
//}
