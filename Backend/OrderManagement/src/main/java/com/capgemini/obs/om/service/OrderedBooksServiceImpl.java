package com.capgemini.obs.om.service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.obs.om.dao.BookDao;
import com.capgemini.obs.om.dao.OrderDao;
import com.capgemini.obs.om.dao.OrderedBooksDao;
import com.capgemini.obs.om.entity.Book;
import com.capgemini.obs.om.entity.Order;
import com.capgemini.obs.om.entity.OrderedBooks;

@Service
public class OrderedBooksServiceImpl implements OrderedBooksService
{
	@Autowired
	OrderedBooksDao obdao;

	@Autowired
	OrderDao odao;

	@Autowired
	BookDao bdao;

	@Override
	public String addBookToPlacedOrder(int orderId, int bookId, int quantity) {
		OrderedBooks newodb = new OrderedBooks();
		Optional<OrderedBooks> orderedBooks = obdao.getOdbBook(orderId, bookId);
		Optional<Order> order = odao.findById(orderId);
		Optional<Book> book = bdao.findById(bookId);
		
		if(order.isPresent() && book.isPresent())
		{
			if(orderedBooks.isPresent())
			{
				orderedBooks.get().setQuantity(orderedBooks.get().getQuantity()+quantity);
				orderedBooks.get().setAmount(book.get().getPrice() * quantity);
				obdao.save(orderedBooks.get());
				return "Book already exists, quantity updated";
			}
			else
			{
				newodb.setOrder(order.get());
				newodb.setBook(book.get());
				newodb.setQuantity(quantity);
				newodb.setAmount(book.get().getPrice() * quantity);
				obdao.save(newodb);
				return "Book added successfully";
			}
		}
		return "Invalid ID";
	}

	@Override
	public String removeBookFromPlacedOrder(int orderId, int bookId)
	{
		Optional<OrderedBooks> orderedBooks = obdao.getOdbBook(orderId, bookId);
		if(orderedBooks.isPresent())
		{
			obdao.deleteById(orderedBooks.get().getIssueId());
			return "Book removed";
		}
		return "Invalid ID";
	}

	@Override
	public String updateQuantityInPlacedOrder(int orderId, int bookId, int quantity) 
	{
		Optional<OrderedBooks> orderedBooks = obdao.getOdbBook(orderId, bookId);
		if(orderedBooks.isPresent())
		{
			orderedBooks.get().setQuantity(quantity);
			float amount = orderedBooks.get().getBook().getPrice() * quantity;
			BigDecimal value = new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP);
			orderedBooks.get().setAmount(value.floatValue());
			obdao.save(orderedBooks.get());
			return "Quantity updated";
		}
		return "Invalid ID, Quantity is not updated";
	}

	@Override
	public List<Integer> getTotalBookCopies() 
	{
		List<Integer> tbc = obdao.getBookCopies();
		return tbc;
	}

	@Override
	public Optional<List<OrderedBooks>> getOrderedBooks(int orderId)
	{
		Optional<List<OrderedBooks>> orderedBooks = obdao.getOrderedBooks(orderId);
		return orderedBooks;
	}

	@Override
	public int getBookCopiesById(int orderId) {
		int tbc = obdao.getBookCopiesById(orderId);
		return tbc;
	} 
}
