package com.codegym.demospringboot.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProductForm {
    private Long id;

    @NotEmpty(message = "Không được phép để trống")
    @Size(min = 5, max = 20, message = "Tên sản phẩm phải từ 5 -> 20 ký tự")
    private String name;

    @NotNull
    private double price;

    @NotBlank
    private String description;

    private MultipartFile image;

    private Category category;

    public ProductForm() {
    }

    public ProductForm(Long id, String name, double price, String description, MultipartFile image, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }


}
