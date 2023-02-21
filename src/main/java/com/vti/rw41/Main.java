package com.vti.rw41;


import com.vti.rw41.entity.Product;
import com.vti.rw41.repository.ProductRepository;
import com.vti.rw41.util.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        testSelectAndDelete();
//        testInsert();
//        testSelectAndUpdate();
        List<Product> products = ProductRepository.findByName("Iphone 13");
        for (Product product : products
        ) {
            System.out.println(product);
        }
    }

    static void testInsert() {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        session.beginTransaction(); // Start a transaction =>> important

        Product product = new Product();
        product.setName("Iphone 13");
        product.setPrice(150.0);
        product.setCreateDate(LocalDateTime.now());
        product.setUpdateTime(LocalDateTime.now());
        session.save(product); // Save object into database

        session.getTransaction().commit(); // Commit transaction
    }

    static void testSelectAndUpdate() {
        Product product = ProductRepository.findById(3);
        if (product != null) {
            product.setPrice(200.5);
            product.setName("Samsung");
            product.setUpdateTime(LocalDateTime.now());

            ProductRepository.saveOrUpdate(product);
            System.out.println(product);
        }
    }

    static void testSelectAndDelete() {
        Product product = ProductRepository.findById(2);
        if (product != null) {
            ProductRepository.delete(product);
        }
    }

}
