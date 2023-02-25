package com.vti.rw41.util;

import com.vti.rw41.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(ProductEntity.class);
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(Position.class);
        configuration.addAnnotatedClass(TestTable.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Category.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(registry);
    }
}
