package br.com.springboot.myblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.myblog.model.Post;
import br.com.springboot.myblog.repository.MyBlogRepository;

@Service
public class MyBlogServiceImpl implements MyBlogService{

	@Autowired
	MyBlogRepository myBlogRepository;
	
	@Override
	public List<Post> findAll() {
		return myBlogRepository.findAll();
	}

	@Override
	public Post findVyId(long id) {
		return myBlogRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return myBlogRepository.save(post);
	}

}
