package com.isti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Book {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookId;
	@Column
	private String name;
	@Column
	private String author;
	@Column
	private String publisher;
	@Column
	private int price;
	@Column
	private int storeId;
	@Column
	private String genra;
	
	@Lob
	@Column
	private byte[] image;
	
	public Book(){}
	
	public Book(int bookId, String name, String author, String publisher,
			int price, int storeId, byte[] image) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.storeId = storeId;
		this.image = image;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getGenra() {
		return genra;
	}

	public void setGenra(String genra) {
		this.genra = genra;
	}
	

}
