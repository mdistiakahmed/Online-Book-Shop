package com.isti.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isti.model.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Book book) {
		session.getCurrentSession().save(book);

	}

	@Override
	public void edit(Book book) {
		session.getCurrentSession().update(book);
		 this.session.getCurrentSession().flush();

	}

	@Override
	public void delete(Book book) {
		//System.out.println("dao "+bookId);
		session.getCurrentSession().delete(book);
		this.session.getCurrentSession().flush();

	}

	@Override
	public Book getBook(int bookId) {
		//session.getCurrentSession().get
		return (Book)session.getCurrentSession().get(Book.class,bookId);
	}

	@Override
	public List getAllBook() {
		return session.getCurrentSession().createQuery("from Book").list();
	}
	
	@Override
	public List getComputerBook() {
		return session.getCurrentSession().createQuery("from Book where genra='computer' ").list();
	}
	
	@Override
	public List getScienceBook() {
		return session.getCurrentSession().createQuery("from Book where genra='science' ").list();
	}
	
	
	@Override
	public List getNovelBook() {
		return session.getCurrentSession().createQuery("from Book where genra='novel' ").list();
	}

	
	@Override
	public List getStoryBook() {
		return session.getCurrentSession().createQuery("from Book where genra='story' ").list();
	}

	
	
	@Override
	public List getEducationBook() {
		return session.getCurrentSession().createQuery("from Book where genra='education' ").list();
	}

	
	
	@Override
	public List getMedicalBook() {
		return session.getCurrentSession().createQuery("from Book where genra='medical' ").list();
	}

	
	@Override
	public List getEngineeringBook() {
		return session.getCurrentSession().createQuery("from Book where genra='engineering' ").list();
	}


}
