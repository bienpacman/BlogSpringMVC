package com.blog.controllers;

import com.blog.models.Blog;
import com.blog.models.Category;
import com.blog.service.BlogService;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @ModelAttribute(name = "blog")
    public Blog blog() {
        return new Blog();
    }

    @ModelAttribute(name = "categories")
    public List<Category> categories() {
        return categoryService.getAll();
    }
//
//    @GetMapping("/error.404")
//    public ModelAndView Error() {
//        return ModelAndView("error.404");
//    }


    @GetMapping("/blogs")
    public ModelAndView show(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("blogs", blogService.getAll(PageRequest.of(page, 2, Sort.by("date"))));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        return new ModelAndView("create");

    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("blog") Blog blog, BindingResult bindingResult, @RequestParam MultipartFile upImg) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        String nameImg = upImg.getOriginalFilename();

        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("C:\\Users\\phamv\\Downloads\\Clone - Sao chép\\Case3\\demoBlogForMe\\src\\main\\webapp\\WEB-INF\\img" + nameImg));
        } catch (IOException e) {
            e.printStackTrace();
        }

        blog.setImg("/img/" + nameImg);
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;


    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute("blog") Blog blog, @RequestParam MultipartFile file) {
        String nameImg = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File("C:\\Users\\phamv\\Downloads\\Clone - Sao chép\\Case3\\demoBlogForMe\\src\\main\\webapp\\WEB-INF\\img" + nameImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        blog.setImg("/img/" + nameImg);
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
        return modelAndView;
    }

//
//    @GetMapping("/delete/{id}")
//    public ModelAndView showDelete(@PathVariable Long id) {
//        Optional<Blog> blog = blogService.findById(id);
//        if (blog.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("delete");
//            modelAndView.addObject("blog", blog.get());
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete")
//    public String delete(@ModelAttribute("blog") Blog blog) {
//        blogService.delete(blog.getId());
//        return "redirect:blogs";
//    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
        blogService.delete(id);
        return modelAndView;
    }
}
