package com.vti.rw41;


import com.vti.rw41.dto.ProductDTO;
import com.vti.rw41.entity.Category;
import com.vti.rw41.entity.ProductEntity;
import com.vti.rw41.entity.Student;
import com.vti.rw41.entity.TestTable;
import com.vti.rw41.entity.enumuraton.ProductStatus;
import com.vti.rw41.repository.CategoryRepository;
import com.vti.rw41.repository.ProductRepository;
import com.vti.rw41.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
//        Student student = session.find(Student.class, "S202300055");
//        student.setName(student.getName().toUpperCase());
//        session.saveOrUpdate(student);
//        session.getTransaction().commit();
        Query<ProductDTO> query = session.createQuery("" +
                "select new com.vti.rw41.dto.ProductDTO(p.productName, p.price, c.name)" +
                "from ProductEntity p " +
                "join p.category c ", ProductDTO.class);
        List<ProductDTO> results = query.getResultList();
        for (ProductDTO result : results) {
            System.out.println(result);
        }

//        testSelectAndDelete();
//        testInsert();
//        testSelectAndUpdate();
//        List<ProductEntity> products = ProductRepository.findByName("Iphone 13");
//        for (ProductEntity product : products
//        ) {
//            System.out.println(product);
//        }
//        Account account = AccountRepository.findById(1);
//        System.out.println(account);
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        for (int i = 0; i < 10; i++) {
//            TestTable testTable = new TestTable();
//            Student student = new Student();
//            student.setName("st" + i);
//            session.save(student);
//        }
//        session.beginTransaction();
//        session.getTransaction().commit();
//        System.out.printf("%05d", 12);

//        Optional<Category> category = CategoryRepository.findByName("Book");
//
//        List<ProductEntity> products = ProductRepository.findAll();
//        for (ProductEntity product : products
//        ) {
//            if (category.isPresent()) {
//                product.setCategory(category.get());
//            }
//            ProductRepository.saveOrUpdate(product);
//            System.out.println(product);
//        }
//        if (category.isPresent()) {
//            Category category1 = category.get();
//            System.out.println("category:" + category1.getName());
//
//            for (ProductEntity p: category1.getProducts()
//                 ) {
//                System.out.println(p.getId() + "--" + p.getName());
//            }
//        }

    }

    static void testInsert() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); // Start a transaction =>> important

        ProductEntity product = new ProductEntity();
        product.setName("Iphone 15");
        product.setPrice(150.0);
        product.setCreateDate(LocalDateTime.now());
        product.setUpdateTime(LocalDateTime.now());
        product.setStatus(ProductStatus.ACTIVE);
        session.save(product); // Save object into database

//        Department department1 = new Department();
//        department1.setName("Sale");
//        Position position = new Position();
//        position.setName("DEV");

//        Account account = new Account();
//            account.setEmail("hiennv@gmail.com");
//            account.setFullName("nvh");
//            account.setUserName("hnv");
//            account.setDepartment(department1);
//            account.setPosition(position);
//            account.setCreateDate(LocalDateTime.now());
//
//        session.saveOrUpdate(department1);
//        session.saveOrUpdate(position);
//        session.saveOrUpdate(account);
        session.getTransaction().commit(); // Commit transaction
    }
    static void testSelectAndUpdate() {
        ProductEntity product = ProductRepository.findProductById(3);
        if (product != null) {
            product.setPrice(200.5);
            product.setName("Ipad");
            product.setUpdateTime(LocalDateTime.now());
            product.setStatus(ProductStatus.INACTIVE);

            ProductRepository.saveOrUpdate(product);
            System.out.println(product);
        }
    }
    static void testSelectAndDelete() {
        ProductEntity product = ProductRepository.findProductById(2);
        if (product != null) {
            ProductRepository.delete(product);
        }
    }
}
