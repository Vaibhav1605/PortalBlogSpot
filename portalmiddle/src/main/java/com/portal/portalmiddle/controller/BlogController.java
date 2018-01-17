package com.portal.portalmiddle.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.portalbackend.Blog;
import com.portal.portalbackend.dao.BlogDao;

@RestController
public class BlogController {

	@Autowired
	BlogDao blogDao;

	@PostMapping("/addblog")
	public ResponseEntity<?> addblog(@RequestBody Blog blog) {
		System.out.println(blog.getClient());
		try {

			blog.setBlogDate(new Date());

			blogDao.addBlog(blog);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error in adding  blog", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@GetMapping("/blogslist")
	public ResponseEntity<?> blogslist(){
		try{
			return new ResponseEntity<List<Blog>>(blogDao.getAllBlogs(),HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
