package br.com.springboot.myblog.utils;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.springboot.myblog.model.Post;
import br.com.springboot.myblog.repository.MyBlogRepository;

@Component
public class DummyData {
	
	@Autowired
	MyBlogRepository myBlogRepository;
	
	//@PostConstruct
	public void AdicionarPost(){
		for(int i = 1; i <=5; i++){
			Post post = new Post();
			post.setTitulo("Título " + i);
			post.setAutor("Autor " + i);
			post.setData(LocalDate.now());
			post.setTexto("Texto " + i);
			myBlogRepository.save(post);
		}
	}

}
