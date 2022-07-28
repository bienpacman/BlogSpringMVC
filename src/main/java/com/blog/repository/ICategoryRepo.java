package com.blog.repository;

import com.blog.models.Blog;
import com.blog.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ICategoryRepo extends CrudRepository <Category,Long> {
}
