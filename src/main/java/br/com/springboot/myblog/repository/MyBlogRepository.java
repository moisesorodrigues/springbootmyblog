package br.com.springboot.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.myblog.model.Post;

public interface MyBlogRepository extends JpaRepository<Post, Long>{

}
