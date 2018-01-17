package com.portal.portalbackend;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.portal.portalbackend.dao.BlogDao;
import com.portal.portalbackend.dao.ClientDao;

public class BlogTest {

	AnnotationConfigApplicationContext context;
	ClientDao clientDao;
	Client client;
	BlogDao blogDao;
	Blog blog;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.portal");
		context.refresh();
		clientDao = (ClientDao) context.getBean("clientDao");
		blogDao = (BlogDao) context.getBean("blogDao");
		blog = new Blog();
	}

	@Test
	public void addBlogTest() {
		blog.setBlogName("Abcd");
		blog.setBlogDescription("XYZ");
		blog.setApproved(false);
		blog.setBlogDate(new Date());
		blog.setLikes(0);
		blog.setClient(clientDao.getClient(84));
		Assert.assertEquals("Blog added", true, blogDao.addBlog(blog));

	}

	@Test
	public void deleteBlogTest() {
		blog.getBlogName();
		blog.setBlogId(90);
		Assert.assertEquals("Blog Deleted", true, blogDao.deleteBlog(blog));
	}

	@Test
	public void updateBlogTest() {
		blog = blogDao.getblogById(89);
		blog.setBlogName("123");

		Assert.assertEquals("Blog updated", true, blogDao.updateBlog(blog));

	}

	@Test
	public void getAllBlogsTest() {
		List<Blog> blogs = blogDao.getAllBlogs();
		for (int i = 0; i < blogs.size(); i++) {
			Blog singleBlog = blogs.get(i);
			System.out.println(singleBlog.getBlogName() + "  " + singleBlog.getBlogDescription());
		}
	}

}
