package com.vti.rw41.repository;

import com.vti.rw41.entity.Product;
import com.vti.rw41.util.HibernateUtil;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductRepository {
    public static Product findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        return session.find(Product.class, id);
    }

    public static List<Product> findByName(String name) {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        Query<Product> query = session.createQuery("From Product Where name = :name", Product.class);
        query.setParameter("name", name);
       return query.getResultList();
    }

    public static Product saveOrUpdate(Product product) {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        session.beginTransaction();
        session.saveOrUpdate(product);

        session.getTransaction().commit();
        return product;
    }

    public static Product delete(Product product) {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        session.beginTransaction();
        session.delete(product);

        session.getTransaction().commit();
        return product;
    }
}
