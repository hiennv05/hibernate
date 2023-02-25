package com.vti.rw41.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
@AllArgsConstructor
@Data
public class DepartmentDTO {
    private Integer id;
    private String departmentName;
    private String name;
}
