package com.capgemini.obs.om.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.capgemini.obs.om.entity.OrderedBooks;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderedBooksDao extends JpaRepository<OrderedBooks, Integer>
{
	@Query("select odb from OrderedBooks odb where odb.order.orderId=:orderId and odb.book.bookId=:bookId")
	public Optional<OrderedBooks> getOdbBook(@Param("orderId") int orderId, @Param("bookId") int bookId);
	
	@Query("select odb from OrderedBooks odb where odb.order.orderId=:orderId")
	public Optional<List<OrderedBooks>> getOrderedBooks(@Param("orderId") int orderId);
	
	@Query("select sum(quantity) from OrderedBooks odb group by odb.order.orderId")
	public List<Integer> getBookCopies();
	
	@Query("select sum(quantity) from OrderedBooks odb where odb.order.orderId=:orderId group by odb.order.orderId")
	public int getBookCopiesById(@Param("orderId") int orderId);
}
