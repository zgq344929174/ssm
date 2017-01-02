package com.zgq.pojo;

import java.util.List;

public class OrdersExt extends Orders{

	private String username;
	private String sex;
	
	//用户信息
	private User user;
	
	//订单详情
	private List<OrderDetail> DetailList;
	
	public List<OrderDetail> getDetailList() {
		return DetailList;
	}
	public void setDetailList(List<OrderDetail> detailList) {
		DetailList = detailList;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
