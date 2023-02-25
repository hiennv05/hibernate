package com.vti.rw41.repository;

import com.vti.rw41.entity.Account;
import com.vti.rw41.util.HibernateUtil;
import org.hibernate.Session;

public class AccountRepository {
    public static Account findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.find(Account.class, id);
    }
}
