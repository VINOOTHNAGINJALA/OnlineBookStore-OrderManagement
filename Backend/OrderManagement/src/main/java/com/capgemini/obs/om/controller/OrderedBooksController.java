package com.capgemini.obs.om.controller;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.obs.om.entity.Order;
import com.capgemini.obs.om.entity.OrderedBooks;
import com.capgemini.obs.om.exception.InvalidDetailsException;
import com.capgemini.obs.om.exception.OrderException;
import com.capgemini.obs.om.service.OrderService;
import com.capgemini.obs.om.service.OrderedBooksService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class OrderedBooksController 
{
	@Autowired
	OrderedBooksService orderedBooksService;

	@Autowired
	OrderService orderService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderedBooksController.class);

	@PostMapping(value = "/addBookToPlacedOrder/{orderId}/{bookId}/{quantity}", consumes = "application/json")
	public ResponseEntity<String> addBook(@PathVariable int orderId , @PathVariable int bookId, @PathVariable int quantity) {
		try {
			LOGGER.warn("Request {}", orderId,bookId);
			String str = orderedBooksService.addBookToPlacedOrder(orderId, bookId, quantity);
			return new ResponseEntity<String>(str, HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage() + " cannot be added", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/removeBookFromPlacedOrder/{orderId}/{bookId}")
	public ResponseEntity<String> removeBookFromPlacedOrder(@PathVariable int orderId, @PathVariable int bookId) throws OrderException {
		try {
			orderedBooksService.removeBookFromPlacedOrder(orderId, bookId);
			return new ResponseEntity<>("Order Deleted sucessfully", HttpStatus.OK);
		} catch (Exception exception) { 
			throw new OrderException("Order is not deleted, please try again with a valid ID");
		}
	}

	@GetMapping(value="/getOrders",produces="application/json")
	public List<Order> getOrders()
	{
		return orderService.getOrders();
	}

	@PutMapping(value="/updateShippingInfo",consumes="application/json")
	public ResponseEntity<String> updateShippingInfo(@RequestBody() Order order) throws InvalidDetailsException
	{
		try {
			orderService.updateShippingInfo(order);
			
			return new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception exception) {
			throw new InvalidDetailsException("Details cannot be updated");
		}
	} 

	@PutMapping(value="/updateQuantityInPlacedOrder/{orderId}/{bookId}/{quantity}",consumes="application/json")
	public ResponseEntity<String> updateQuantityInPlacedOrder(@PathVariable int orderId, @PathVariable int bookId,@PathVariable int quantity) throws InvalidDetailsException
	{
		try {
			orderedBooksService.updateQuantityInPlacedOrder(orderId,bookId,quantity);
			return new ResponseEntity<String>("Quantity Updated succesfully",HttpStatus.OK);
		}catch(Exception exception) {
			throw new InvalidDetailsException("Invalid ID");
		}
	}

	@GetMapping(value="/getOrder/{orderId}",produces="application/json")
	public ResponseEntity<Optional<Order>> getOrder(@PathVariable int orderId)
	{
		Optional<Order> order =  orderService.getOrder(orderId);
		if(order.isPresent())
			return new ResponseEntity<Optional<Order>>(order,HttpStatus.OK);
		return new ResponseEntity<Optional<Order>>(order,HttpStatus.NOT_FOUND);
	}

	@GetMapping(value="/getTotalBookCopies",produces="application/json")
	public ResponseEntity<List<Integer>> getTotalBookCopies()
	{
		List<Integer> copies =  orderedBooksService.getTotalBookCopies();
		System.out.println(copies);
		return new ResponseEntity<List<Integer>>(copies, HttpStatus.OK);		
	}
	
	@GetMapping(value="/getBookCopiesById/{orderId}",produces="application/json")
	public ResponseEntity<Integer> getBookCopiesById(@PathVariable int orderId)
	{
		int copies =  orderedBooksService.getBookCopiesById(orderId);
		System.out.println(copies);
		return new ResponseEntity<Integer>(copies, HttpStatus.OK);		
	}

	@GetMapping(value="/getOrderedBooks/{orderId}",produces="application/json")
	public ResponseEntity<Optional<List<OrderedBooks>>> getOrderedBooks(@PathVariable int orderId)
	{
		Optional<List<OrderedBooks>> orderedBooks =  orderedBooksService.getOrderedBooks(orderId);
		if(orderedBooks.isPresent())
			return new ResponseEntity<Optional<List<OrderedBooks>>>(orderedBooks,HttpStatus.OK);
		return new ResponseEntity<Optional<List<OrderedBooks>>>(orderedBooks,HttpStatus.NOT_FOUND);
	}

}

