package com.capgemini.obs.om.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.obs.om.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{
}
