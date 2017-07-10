package com.isti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.isti.model.Book;
import com.isti.service.AccountsService;
import com.isti.service.BookService;


@Controller
public class CatageryController {
	@Autowired
	private BookService bookService;
	@Autowired
	private AccountsService accountService;
	
	 @RequestMapping("/catagoryComputer")
	    public ModelAndView catagory_Computer() {
	    	ModelAndView model = new ModelAndView("home");
			Book book = new Book();
			model.addObject("book", book);
			model.addObject("bookList", bookService.getComputerBook());
			return model;

	    }
	    
	    @RequestMapping("/catagoryScience")
	    public ModelAndView catagoryScience() {
	    	ModelAndView model = new ModelAndView("home");
			Book book = new Book();
			model.addObject("book", book);
			model.addObject("bookList", bookService.getScienceBook());
			return model;

	    }
	    
	    @RequestMapping("/catagoryNovel")
	    public ModelAndView catagoryNovel() {
	    	ModelAndView model = new ModelAndView("home");
			Book book = new Book();
			model.addObject("book", book);
			model.addObject("bookList", bookService.getNovelBook());
			return model;

	    }
	    
	    
	    @RequestMapping("/catagoryStory")
	    public ModelAndView catagoryStory() {
	    	ModelAndView model = new ModelAndView("home");
			Book book = new Book();
			model.addObject("book", book);
			model.addObject("bookList", bookService.getStoryBook());
			return model;

	    }
	    
	    @RequestMapping("/catagoryEducation")
	    public ModelAndView catagoryEducation() {
	    	ModelAndView model = new ModelAndView("home");
			Book book = new Book();
			model.addObject("book", book);
			model.addObject("bookList", bookService.getEducationBook());
			return model;

	    }
	    
	    
	    @RequestMapping("/catagoryMedical")
	    public ModelAndView catagoryMedical() {
	    	ModelAndView model = new ModelAndView("home");
			Book book = new Book();
			model.addObject("book", book);
			model.addObject("bookList", bookService.getMedicalBook());
			return model;

	    }
	    
	    
	    @RequestMapping("/catagoryEngineering")
	    public ModelAndView catagoryEngineering() {
	    	ModelAndView model = new ModelAndView("home");
			Book book = new Book();
			model.addObject("book", book);
			model.addObject("bookList", bookService.getEngineeringBook());
			return model;

	    }
}
