package com.zgq;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zgq.mapper.OrdersMapper;
import com.zgq.pojo.OrdersExt;
import com.zgq.pojo.User;
import com.zgq.tools.DBUtils;

public class OrderTest {
	
	/**
	 * 查询所有订单信息及用户信息
	 * 用户和订单直接的关系，使用resultType
	 */
	@Test
	public void findOrdersAndUser(){
		SqlSession sqlSession = DBUtils.getSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrdersExt> ordersExt = mapper.findOrdersAndUser();
		System.out.println(ordersExt);
		sqlSession.close();
	}
	
	/**
	 * 查询所有订单信息及用户信息
	 * 用户和订单之间的关系，使用resultMap
	 */
	@Test
	public void findOrdersAndUserRstMap(){
		SqlSession sqlSession = DBUtils.getSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrdersExt> ordersExt = mapper.findOrdersAndUserRstMap();
		System.out.println(ordersExt);
		sqlSession.close();
	}
	
	/**
	 * 查询订单信息、用户及订单详情
	 * 用户和明细之间的关系
	 */
	@Test
	public void findOrderDetailRstMap(){
		SqlSession sqlSession = DBUtils.getSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrdersExt> ordersExt = mapper.findOrderDetailRstMap();
		System.out.println(ordersExt);
		sqlSession.close();
	}
	
	/**
	 * 查询用户信息，关联查询该用户购买的商品信息
	 * 用户和商品之间的关系(多对多)
	 */
	@Test
	public void findUserAndItemsRstMap(){
		SqlSession sqlSession = DBUtils.getSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<User> user = mapper.findUserAndItemsRstMap();
		System.out.println(user);
		sqlSession.close();
	}
	
	/**
	 *查询订单信息，如果需要时，再去查询用户信息。
	 *延迟加载
	 */
	@Test
	public void findOrderAndUserLazyLoadingRstMap(){
		SqlSession sqlSession = DBUtils.getSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrdersExt> ordersExts = mapper.findOrderAndUserLazyLoadingRstMap();
		//System.out.println(ordersExts);
		
		/*for(OrdersExt ode:ordersExts){
			System.out.println(ode.getUser());
		}*/
		sqlSession.close();
	}
}

