package com.vti.rw41.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(generator = "StudentIdGenerator") //Su dung
    @GenericGenerator( //Khai bao
            name = "StudentIdGenerator", strategy = "com.vti.rw41.entity.generator.StudentIdGenerator")
    private String id; // SYYYxxxx

    private String name;
}
