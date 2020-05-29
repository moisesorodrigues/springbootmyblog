package br.com.springboot.myblog.service;

import java.util.List;

import br.com.springboot.myblog.model.Post;

public interface MyBlogService {
	
	List<Post> findAll();
	
	Post findVyId(long id);
	
	Post save(Post post);

}
