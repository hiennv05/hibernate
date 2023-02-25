package com.vti.rw41.repository;

import com.vti.rw41.entity.Category;
import com.vti.rw41.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class CategoryRepository {
    public static Optional<Category> findByName(String name) {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        Query<Category> query = session.createQuery("From Category Where name = :name", Category.class);
        query.setParameter("name", name);
        return query.getResultStream().findFirst();
    }
}
