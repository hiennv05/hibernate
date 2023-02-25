package com.vti.rw41.entity;

import com.vti.rw41.entity.enumuraton.ProductStatus;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(generator = "productIdSq") // Su dung sequence
    @SequenceGenerator( // Khai bao sequence
            name = "productIdSq",
            sequenceName = "productIdSq",
            initialValue = 1,
            allocationSize = 2)
    // Auto increment
    private Integer id;
    @Column(name = "name", length = 255)
    private String name;
    private String productName;
    private Double price;
    private LocalDateTime createDate;
    private LocalDateTime updateTime;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
