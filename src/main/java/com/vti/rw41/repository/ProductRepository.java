package com.vti.rw41.repository;

import com.vti.rw41.entity.ProductEntity;
import com.vti.rw41.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductRepository {
    public static List<ProductEntity> findAll() {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
       return session.createQuery("from ProductEntity").getResultList();
    };

    public static ProductEntity findProductById(Integer id) {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        return session.find(ProductEntity.class, id);
    }

    public static List<ProductEntity> findByName(String name) {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        Query<ProductEntity> query = session.createQuery("From ProductEntity Where name = :name", ProductEntity.class);
        query.setParameter("name", name);
       return query.getResultList();
    }

    public static ProductEntity saveOrUpdate(ProductEntity product) {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        session.beginTransaction();
        session.saveOrUpdate(product);

        session.getTransaction().commit();
        return product;
    }

    public static ProductEntity delete(ProductEntity product) {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        session.beginTransaction();
        session.delete(product);

        session.getTransaction().commit();
        return product;
    }
}
