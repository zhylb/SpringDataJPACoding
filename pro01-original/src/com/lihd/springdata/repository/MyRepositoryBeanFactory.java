//package com.lihd.springdata.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
//import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
//import org.springframework.data.repository.core.RepositoryMetadata;
//import org.springframework.data.repository.core.support.RepositoryFactorySupport;
//
//import javax.persistence.EntityManager;
//import java.io.Serializable;
//
///**
// * @author ：葬花吟留别1851053336@qq.com
// * @description：TODO
// * @date ：2022/4/28 19:44
// */
//public class MyRepositoryBeanFactory<R extends JpaRepository<T, ID>,T, ID extends Serializable> extends JpaRepositoryFactoryBean<R, T, ID> {
//    @Override
//    protected RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
//        return new MyRepositoryFactory(em);
//    }
//    private static class MyRepositoryFactory<T, ID extends Serializable> extends JpaRepositoryFactory {
//
//        private final EntityManager em;
//
//        public MyRepositoryFactory(EntityManager em) {
//            super(em);
//            this.em = em;
//        }
//
//        @Override
//        protected Object getTargetRepository(RepositoryMetadata metadata) {
//            return new MyRepositoryImpl<T,ID>((Class<T>) metadata.getDomainType(), em);
//        }
//
//        @Override
//        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
//            return MyRepositoryImpl.class;
//        }
//    }
//
//
//}
