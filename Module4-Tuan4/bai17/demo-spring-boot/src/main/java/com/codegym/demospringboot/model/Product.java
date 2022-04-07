package com.codegym.demospringboot.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity//Tạo bảng
@Table(name = "products")
@Data
public class Product {
    @Id//Khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Tự tăng
    private Long id;

    @Column(columnDefinition = "Varchar(50)", nullable = false)
    @NotEmpty
    private String name; //khi tạo bảng string => varchar(255)

    @Column(nullable = false)
    @NotNull
    private double price;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    @NotNull
    private String description;

    private String image;

    @ManyToOne //Tạo khóa ngoại và thêm 1 cột category_id
    private Category category;

    public Product() {
    }

    public Product(Long id, String name, double price, String description, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

}
