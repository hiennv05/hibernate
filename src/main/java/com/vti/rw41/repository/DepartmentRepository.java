package com.vti.rw41.repository;

import com.vti.rw41.dto.DepartmentDTO;
import com.vti.rw41.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentRepository {
    //Phan trang, search theo ten..
//    public static List<DepartmentDTO> getAllDepartments(String search, int page, int pageSize) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        Query<DepartmentDTO> query = session.createQuery("select " +
//                "new com.vti.rw41.dto.DepartmentDTO(d.id, d.departmentName, a.name) " +
//                "from  Department  d join aa a " +
//                "where d.departmentName like :departmentName " +
//                "order by d.departmentName ", DepartmentDTO.class);
//        query.setParameter("departmentName", "%" + search+ "%");
//        query.setMaxResults(pageSize);
//        query.setFirstResult((page-1)* pageSize);
//
//        return query.getResultList();
//    }
//    Lay total theo search
    public static int getTotal(String search) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("" +
                        "select count(d) " +
                        "from Department d " +
                        "where d.name like :name")
                .setParameter("name", "%" + search + "%");

        return ((Number)query.getSingleResult()).intValue();
    }
}
