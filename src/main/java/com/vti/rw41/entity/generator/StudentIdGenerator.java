package com.vti.rw41.entity.generator;

import com.vti.rw41.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.NativeQuery;

import java.io.Serializable;
import java.time.Year;

public class StudentIdGenerator implements IdentifierGenerator {
    @Override
//    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//      session.createNativeQuery("update studentSq set next_val = next_val + 1").executeUpdate();
//        Number next_val = (Number) session.createNativeQuery("SELECT next_val FROM hibernate_test.studentSq")
//                .getSingleResult();
//        System.out.println(next_val);
//        session.getTransaction().commit();
//        String stt = String.format("%05d", next_val.intValue());
//        return "S"+ Year.now() + stt;
//    }
    public Serializable generate(SharedSessionContractImplementor session, Object o) throws HibernateException {
//        session.beginTransaction();

      session.createNativeQuery("update studentSq set next_val = next_val + 1")
              .executeUpdate();
        Number next_val = (Number) session.createNativeQuery("SELECT next_val FROM hibernate_test.studentSq")
                .getSingleResult();
//        session.getTransaction().commit();

        String stt = String.format("%05d", next_val.intValue());
        return "S"+ Year.now() + stt;
    }
}
