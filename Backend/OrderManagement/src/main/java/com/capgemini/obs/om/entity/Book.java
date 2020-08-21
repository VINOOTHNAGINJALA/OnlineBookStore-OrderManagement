package com.capgemini.obs.om.entity;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="book")
public class Book 
{
	@Id
	@Column(name="bookId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
	@SequenceGenerator(sequenceName = "book_sequence", allocationSize = 1, name = "book_seq")
	private Integer bookId;

	@NotEmpty(message = "title is mandatory")
	@Column(name="title")
	@Length(min=2 , max=128)
	private String title;

	@NotEmpty(message = "author name is mandatory")
	@Column(name="author")
	@Length(min=2 , max=65)
	private String author;

	@NotEmpty(message = "description is mandatory")
	@Column(name="description")
	@Length(min=2 , max=2000)
	private String description;

	@Column(name="isbn", length=15)
	private Long isbn;

	@Column(name="price")
	private  Float price;

	@Column(name="publishDate")
	private LocalDate publishDate;

	public Book() {}

	public Book(Integer bookId, @NotEmpty(message = "title is mandatory") @Length(min = 2, max = 128) String title,
			@NotEmpty(message = "author name is mandatory") @Length(min = 2, max = 65) String author,
			@NotEmpty(message = "description is mandatory") @Length(min = 2, max = 2000) String description, Long isbn,
			Float price, LocalDate publishDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.price = price;
		this.publishDate = publishDate;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	@Override
	public String toString() {
		return "BookInfo [bookId=" + bookId + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", isbn=" + isbn + ", price=" + price + ", publishDate=" + publishDate + "]";
	}
}
