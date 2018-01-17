package com.portal.portalbackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.portalbackend.Blog;
import com.portal.portalbackend.dao.BlogDao;

@Transactional
@Repository("blogDao")
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Blog getblogById(int blogId) {
		try {
			return sessionFactory.getCurrentSession().get(Blog.class, blogId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Blog> getAllBlogs() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog", Blog.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
