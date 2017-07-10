package com.isti.dao;

import java.util.List;

import com.isti.model.Book;

public interface BookDAO {
	public void add(Book book);
	public void edit(Book book);
	public void delete(Book book);
	public Book getBook(int bookId);
	public List getAllBook();
	public List getComputerBook();
	public List getScienceBook();
	public List getNovelBook();
	public List getStoryBook();
	public List getEducationBook();
	public List getMedicalBook();
	public List getEngineeringBook();
	
}
