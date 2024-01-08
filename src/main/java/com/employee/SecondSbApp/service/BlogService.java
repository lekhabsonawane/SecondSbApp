package com.employee.SecondSbApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.SecondSbApp.model.Blog;
import com.employee.SecondSbApp.repo.BlogRepository;


@Service
public class BlogService {
	 @Autowired
    private BlogRepository blogRepository;

   
  
	 public Iterable<Blog> getAllBlogs() {
			return blogRepository.findAll();
		}
 

public Blog createBlog(Blog blogObj) {

	return blogRepository.save(blogObj);
   
    }




}


