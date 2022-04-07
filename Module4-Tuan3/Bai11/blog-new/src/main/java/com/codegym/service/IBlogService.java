package com.codegym.service;

import com.codegym.model.Blog;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();

    Optional<Blog> findById(Long id);

    Blog save(Blog blog);

    void deleteById(Long id);
}
