package com.capgemini.obs.om.service;
import java.util.List;
import java.util.Optional;
import com.capgemini.obs.om.entity.OrderedBooks;

public interface OrderedBooksService
{
	public String addBookToPlacedOrder(int orderId, int bookId, int quantity);
	
	public String removeBookFromPlacedOrder(int orderId, int bookId);
	
	public String updateQuantityInPlacedOrder(int orderId, int bookId, int quantity);	 
	
	public List<Integer> getTotalBookCopies();
	
	public int getBookCopiesById(int orderId);
	
	public Optional<List<OrderedBooks>> getOrderedBooks(int orderId);
}
