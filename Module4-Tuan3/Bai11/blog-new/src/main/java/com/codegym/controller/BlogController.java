package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.BlogForm;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Value("${file-upload}")
    private String uploadPath;

    @GetMapping("/blogs/list")
    public ModelAndView showAllBlog() {
        ModelAndView modelAndView = new ModelAndView("blog/list");
        Iterable<Blog> blogs = blogService.findAll();
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/blogs/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blogs", new BlogForm());
        return modelAndView;
    }

    @PostMapping("/blogs/create")
    public ModelAndView addNewBlog (@ModelAttribute BlogForm blogForm){
        String fileName = blogForm.getImage().getOriginalFilename();
        long currentTime = System.currentTimeMillis();
        fileName = currentTime + fileName;
        try {
            FileCopyUtils.copy(blogForm.getImage().getBytes(), new File(uploadPath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Blog blog = new Blog(blogForm.getId(), blogForm.getName(), blogForm.getContent(), blogForm.getTime(), fileName);
        blogService.save(blog);
        return new ModelAndView("redirect:/blogs");
    }

    @GetMapping("/blogs/edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            return new ModelAndView("error-404");
        } else {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;
        }
    }

    @PostMapping ("/blogs/edit/{id}")
    public ModelAndView editProduct (@PathVariable Long id, @ModelAttribute BlogForm blogForm){
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()){
            Blog oldProduct = blog.get();
            MultipartFile img = blogForm.getImage();
            if (img.getSize()!=0){
                String filename = img.getOriginalFilename();
                long currentTime = System.currentTimeMillis();
                filename = currentTime + filename;
                oldProduct.setImage(filename);
                try {
                    FileCopyUtils.copy(blogForm.getImage().getBytes(), new File(uploadPath + filename));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            oldProduct.setName(blogForm.getName());
            oldProduct.setContent(blogForm.getContent());
            oldProduct.setTime(blogForm.getTime());
            blogService.save(oldProduct);
            return new ModelAndView("redirect:/blogs");
        }
        return new ModelAndView("error-404");
    }

    @GetMapping ("/blogs/delete/{id}")
    public ModelAndView showDeleteForm (@PathVariable Long id){
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()){
            return new ModelAndView("error-404");
        }
        else {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;
        }
    }

    @PostMapping ("/blogs/delete/{id}")
    public ModelAndView deleteProduct (@PathVariable Long id){
        Optional<Blog>blog = blogService.findById(id);
        if (!blog.isPresent()){
            return new ModelAndView("error-404");
        }
        else {
            File file = new File(uploadPath + blog.get().getImage());
            if (file.exists()){
                file.delete();
            }
            blogService.deleteById(id);
            return new ModelAndView("redirect:/blogs");
        }
    }
}
