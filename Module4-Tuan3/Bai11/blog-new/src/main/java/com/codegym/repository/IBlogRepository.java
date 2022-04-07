package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.repository.CrudRepository;

public interface IBlogRepository extends CrudRepository<Blog, Long> {
}
