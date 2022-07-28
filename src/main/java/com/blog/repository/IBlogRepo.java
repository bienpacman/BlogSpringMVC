package com.blog.repository;

import com.blog.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface IBlogRepo extends PagingAndSortingRepository<Blog,Long> {
    Page<Blog> findByTitleContaining(Pageable pageable, String name);
    Optional<Blog> findByName (String name);


}
