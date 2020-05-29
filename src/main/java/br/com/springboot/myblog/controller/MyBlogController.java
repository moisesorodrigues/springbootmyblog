package br.com.springboot.myblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.springboot.myblog.model.Post;
import br.com.springboot.myblog.service.MyBlogService;

@Controller
public class MyBlogController {
	
	@Autowired
	MyBlogService myBlogService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getAllPost(){
		ModelAndView modelAndView = new ModelAndView("posts");
		List<Post> posts = myBlogService.findAll();
		modelAndView.addObject("posts", posts);
		return modelAndView;
	}
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostById(@PathVariable("id") long id){
		ModelAndView modelAndView = new ModelAndView("postDetails");
		Post post = myBlogService.findVyId(id);
		modelAndView.addObject("post", post);
		return modelAndView;
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String getNewPost(){
		return "newPost";
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public String getSavePost(@Valid Post post, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			redirectAttributes.addFlashAttribute("mensagens", "Um ou mais campos obrigatórios não foi preenchido!");
			return "redirect:/newpost";
		}
		
		post.setData(LocalDate.now());
		
		myBlogService.save(post);
		
		return "redirect:/posts";
	}

}
