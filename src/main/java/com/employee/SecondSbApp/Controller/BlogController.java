package com.employee.SecondSbApp.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.SecondSbApp.model.Blog;
import com.employee.SecondSbApp.service.BlogService;
	@RestController
	@RequestMapping("/Blogs")
	@CrossOrigin(origins = "*")
	public class BlogController {

		@Autowired
		private BlogService blogService;

		
		 //http://localhost:8080/Blogs/all
		@GetMapping(value ="/all")
		public Iterable<Blog> getAllBlogs() {
			return blogService.getAllBlogs();
		}
		
		//Create Blog
		@PostMapping(value = "/save") // http://localhost:8080/Blogs/save
		// http://localhost:8080/tickets/create==> ticketCont.createTicket();
		public Blog createBlog( @RequestBody Blog tob) {
			return blogService.createBlog(tob);
		}
		
	 
	}

