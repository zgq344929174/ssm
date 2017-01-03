package com.zgq.mapper;

import java.util.List;

import com.zgq.pojo.Orders;
import com.zgq.pojo.OrdersExt;
import com.zgq.pojo.User;

public interface OrdersMapper {

	public List<OrdersExt> findOrdersAndUser();
	
	public List<OrdersExt> findOrdersAndUserRstMap();
	
	public List<OrdersExt> findOrderDetailRstMap();

	public List<User> findUserAndItemsRstMap();
	
	public List<OrdersExt> findOrderAndUserLazyLoadingRstMap();
}
