package com.capgemini.obs.om.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="orderedbooks")
public class OrderedBooks 
{
	@Id
	@Column(name="issueId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "issue_seq")
    @SequenceGenerator(name = "issue_seq", sequenceName = "issue_sequence", allocationSize=1)
    int issueId;
	
	@OneToOne
	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	private Order order;
	
	@OneToOne
	@JoinColumn(name = "bookId", referencedColumnName = "bookId")
	private Book book;
	
	@Column(name="quantity",length=3)
	private int quantity;
	
	@Column(name="amount",length=6)
	private float amount;
	
	public OrderedBooks() {}
	public OrderedBooks(int issueId, Order order, Book book, int quantity, float amount) {
		super();
		this.issueId = issueId;
		this.order = order;
		this.book = book;
		this.quantity = quantity;
		this.amount = amount;
	}
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
}
