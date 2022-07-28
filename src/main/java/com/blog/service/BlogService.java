package com.blog.service;

import com.blog.models.Blog;
import com.blog.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class BlogService {
    public ArrayList<Blog> blogList = new ArrayList<>();

    @Autowired
    IBlogRepo iBlogRepo;

    public Page<Blog> getAll(Pageable pageable) {
        return iBlogRepo.findAll(pageable);
    }
    public Page<Blog> getAllByTitle(Pageable pageable,String title ){
        return iBlogRepo.findByTitleContaining(pageable,title);
    }
    public  void  save(Blog blog){
        iBlogRepo.save(blog);
    }
    public void delete(long id){
        iBlogRepo.deleteById(id);
    }
    public Optional<Blog> findById(long id){
        for (int i = 0; i < blogList.size(); i++) {
            if (blogList.get(i).getId() == id){
            }

        }
        return iBlogRepo.findById(id);
    }

    public Optional<Blog> findByName(String name){
        return iBlogRepo.findByName(name);
    }
}
