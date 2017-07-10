package com.isti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isti.dao.BookDAO;
import com.isti.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDao;
	
	@Transactional
	public void add(Book book) {
		bookDao.add(book);

	}

	@Transactional
	public void edit(Book book) {
		bookDao.edit(book);

	}

	@Transactional
	public void delete(Book book) {
		bookDao.delete(book);

	}

	@Transactional
	public Book getBook(int bookId) {
		return bookDao.getBook(bookId);
	}

	@Transactional
	public List getAllBook() {
		return bookDao.getAllBook();
	}

	@Transactional
	public List getComputerBook() {
		return bookDao.getComputerBook();
	}
	
	@Transactional
	public List getScienceBook() {
		return bookDao.getScienceBook();
	}
	
	@Transactional
	public List getNovelBook() {
		return bookDao.getNovelBook();
	}
	
	@Transactional
	public List getStoryBook() {
		return bookDao.getStoryBook();
	}
	
	
	@Transactional
	public List getEducationBook() {
		return bookDao.getEducationBook();
	}
	
	
	@Transactional
	public List getMedicalBook() {
		return bookDao.getMedicalBook();
	}
	
	
	@Transactional
	public List getEngineeringBook() {
		return bookDao.getEngineeringBook();
	}
	
}
