package com.capgemini.obs.om.testcases;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.capgemini.obs.om.dao.BookDao;
import com.capgemini.obs.om.entity.Customer;
import com.capgemini.obs.om.entity.Order;
import com.capgemini.obs.om.service.OrderService;
import com.capgemini.obs.om.service.OrderedBooksService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class OMTestCases 
{
	@Autowired
	OrderService orderService;

	@Autowired
	OrderedBooksService orderedBooksService;

	@Autowired
	BookDao bdao;

	@Test
	public void addBookToPlacedOrder_Positive(){
		String str = orderedBooksService.addBookToPlacedOrder(201, 2, 1);
		Assertions.assertEquals("Book added successfully",str);
	}

	@Test
	public void addBookToPlacedOrder_Negative(){
		String str = orderedBooksService.addBookToPlacedOrder(201, 10, 1);
		assertEquals("Invalid ID",str);
	}

	@Test
	public void removeBookFromPlacedOrder_Positive(){
		String str = orderedBooksService.removeBookFromPlacedOrder(201, 2);
		Assertions.assertEquals("Book removed",str);
	}

	@Test
	public void removeBookFromPlacedOrder_Negative(){
		String str = orderedBooksService.removeBookFromPlacedOrder(201, 52);
		Assertions.assertEquals("Invalid ID",str);
	}

	@Test
	public void updateShippingInfo_Positive() 
	{
		Order order = new Order(210, new Customer(101,"vinni","vinni@gmail.com","vinoothna",9652472336L,"officers colony","Nakrekal","India",508211),"Babyy",9999999990L,"Officers colony","Nakrekal","India", 508211,"Cash on Delivery","Shipped",null);
		String o = orderService.updateShippingInfo(order);
		Assertions.assertEquals("Updated",o);
	}

	@Test
	public void updateShippingInfo_Negative()
	{
		Order order = new Order(210, new Customer(101,"vinni","vinni@gmail.com","vinoothna",9652472336L,"officers colony","Nakrekal","India",508211),"Babyy",9999999990L,"Officers colony","Nakrekal","India", 508211,"Cash on Delivery","Shipped", null);
		String o = orderService.updateShippingInfo(order);
		Assertions.assertEquals("Updated",o);
	}

	@Test
	public void updateQuantityInPlacedOrder_Positive() 
	{
		String str = orderedBooksService.updateQuantityInPlacedOrder(201, 1,10);
		Assertions.assertEquals("Quantity updated",str);
	}

	@Test
	public void updateQuantityInPlacedOrder_Negative() 
	{
		String str = orderedBooksService.updateQuantityInPlacedOrder(201, 91,10);
		Assertions.assertEquals("Invalid ID, Quantity is not updated",str);
	}
}
