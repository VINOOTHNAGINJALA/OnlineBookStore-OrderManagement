package com.capgemini.obs.om.testcases;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.VerificationCollector;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.capgemini.obs.om.dao.OrderDao;
import com.capgemini.obs.om.dao.OrderedBooksDao;
import com.capgemini.obs.om.entity.Customer;
import com.capgemini.obs.om.entity.Order;
import com.capgemini.obs.om.service.OrderServiceImpl;
import com.capgemini.obs.om.service.OrderedBooksServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
class OrderManagementTestCases 
{
	@Rule
	public VerificationCollector verificationCollector = MockitoJUnit.collector();
	@Mock
	private OrderDao odao;
	@Mock
	private OrderedBooksDao odbdao;
	@Mock
	private OrderServiceImpl orderService;
	@Mock
	private OrderedBooksServiceImpl orderedBooksService;
	@BeforeEach
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void updateShippingInfo_Positive() 
	{
		Order order = new Order(210, new Customer(101,"vinni","vinni@gmail.com","vinoothna",9652472336L,"officers colony","Nakrekal","India",508211),"Babyy",9999999990L,"Officers colony","Nakrekal","India", 508211,"Cash on Delivery","Shipped",null);
		orderService.updateShippingInfo(order);
		verify(orderService, times(1)).updateShippingInfo(order);
	}
	
	@Test
	public void updateShippingInfo_Negative()
	{
		Order order = new Order(210, new Customer(101,"vinni","vinni@gmail.com","vinoothna",9652472336L,"officers colony","Nakrekal","India",508211),"Babyy",9999999990L,"Officers colony","Nakrekal","India", 508211,"Cash on Delivery","Shipped",null);
		orderService.updateShippingInfo(order);
		verify(orderService, times(2)).updateShippingInfo(order);
	}
	
	@Test
	public void addBookToPlacedOrder()
	{
		orderedBooksService.addBookToPlacedOrder(201, 1, 1);
	}
	
	@Test
	public void removeBookFromPlacedOrder_Positive() 
	{
		orderedBooksService.removeBookFromPlacedOrder(201, 1);
		verify(orderedBooksService,times(1)).removeBookFromPlacedOrder(201, 1);
	}
	@Test
	public void removeBookFromPlacedOrder_Negative()
	{
		orderedBooksService.removeBookFromPlacedOrder(201, 1);
		verify(orderedBooksService,times(2)).removeBookFromPlacedOrder(201, 1);
	}
	
	@Test
	public void updateQuantityInPlacedOrder_Positive()
	{
		orderedBooksService.updateQuantityInPlacedOrder(201, 1, 2);
		verify(orderedBooksService,Mockito.times(1)).updateQuantityInPlacedOrder(201, 1, 2);
	}
	@Test
	public void updateQuantityInPlacedOrder_Negative()
	{
		orderedBooksService.updateQuantityInPlacedOrder(201, 1, 2);
		verify(orderedBooksService,Mockito.times(2)).updateQuantityInPlacedOrder(201, 1, 2);
	}
}
