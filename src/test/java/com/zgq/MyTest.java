package com.zgq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.zgq.mapper.UserMapper;
import com.zgq.pojo.User;
import com.zgq.pojo.UserQueryVO;
import com.zgq.tools.DBUtils;

public class MyTest {
	// 使用xml
	@Test
	public void selectByid() {
		SqlSession sqlSession = DBUtils.getSession();
		User user = sqlSession.selectOne("com.zgq.mapper.UserMapper.selectById", 10);
		System.out.println(user);
		sqlSession.close();
	}

	// 使用注解
	@Test
	public void selectByIdforanno() {
		SqlSession sqlSession = DBUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.selectByIdforanno(1);
		System.out.println(user);
		sqlSession.close();
	}

	/**
	 * 查询所有User
	 */
	@Test
	public void selectAllUser() {
		SqlSession sqlSession = DBUtils.getSession();
		List<User> list = sqlSession.selectList("com.zgq.mapper.UserMapper.selectAllUser");
		String json = JSON.toJSONString(list);
		System.out.println(json);
		sqlSession.close();
	}

	/**
	 * 根据名称模糊查询User
	 */
	@Test
	public void selectUserByName() {
		SqlSession sqlSession = DBUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = mapper.selectUserByName("张");
		System.out.println(JSON.toJSONString(list));
		sqlSession.close();
	}

	/**
	 * 使用注解查询所有User
	 */
	@Test
	public void selectAllUseranno() {
		SqlSession sqlSession = DBUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = mapper.selectAllUser();
		System.out.println(JSON.toJSONString(list));
		sqlSession.close();
	}

	/**
	 * 插入一条记录
	 */
	@Test
	public void insertOneUser() {
		SqlSession sqlSession = DBUtils.getSession();
		User user = new User();
		user.setUsername("张刚强");
		user.setSex(1);
		int count = sqlSession.insert("com.zgq.mapper.insertOneUser", user);
		sqlSession.commit();
		System.out.println(count);
	}

	/**
	 * 插入一条记录，获取插入的id 插入成功后，自动将id封装到user里面
	 */
	@Test
	public void insertOneUserGetId() {
		SqlSession sqlSession = DBUtils.getSession();
		User user = new User();
		user.setUsername("张刚强22");
		user.setSex(1);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		int getId = mapper.insertOneUserGetId(user);
		System.out.println(getId);
		System.out.println("userId=" + user.getId());
		sqlSession.commit();
	}

	/**
	 * 批量插入User
	 */
	@Test
	public void insertBatchUser() {
		SqlSession sqlSession = DBUtils.getSession();
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setUsername("张刚强2");
		user.setSex(1);
		User user1 = new User();
		user1.setUsername("张刚强3");
		user1.setSex(1);
		list.add(user1);
		list.add(user1);
		int count = sqlSession.insert("com.zgq.mapper.UserMapper.insertBatchUser", list);
		sqlSession.commit();
		System.out.println(count);
	}

	/**
	 * 根据id修改地址
	 */
	@Test
	public void updateUserById() {
		SqlSession sqlSession = DBUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(26);
		user.setAddress("北京海淀东平庄");
		int updatecount = mapper.updateUserByid(user);
		System.out.println(updatecount);
		sqlSession.commit();
		sqlSession.close();
	}

	/**
	 * 使用包装pojo查询用户 ,包装pojo使用都多表关联增删改查
	 */
	@Test
	public void selectUserQueryVO() {
		SqlSession sqlSession = DBUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVO userQueryVO = new UserQueryVO();
		User user = new User();
		user.setId(10);
		user.setUsername("张三");
		userQueryVO.setUser(user);
		List<User> list = mapper.selectUserQueryVO(userQueryVO);
		System.out.println(JSON.toJSONString(list));
		sqlSession.close();
	}

	/**
	 * 使用hashmap类型查询
	 */
	@Test
	public void selectUserByMap(){
		SqlSession sqlSession = DBUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		HashMap map = new HashMap<String, Object>();
		map.put("id",10);
		map.put("username", "张三");
		List<User> list = mapper.selectUserByMap(map);
		System.out.println(list);
		sqlSession.close();
	}
	
	/**
	 * 查询用户总数
	 */
	@Test
	public void selectUserCount(){
		SqlSession sqlSession = DBUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("张");
		int userCount = mapper.selectUserCount(user);
		System.out.println(userCount);
		sqlSession.close();
	}
	
	/**
	 * 使用resultMap定义查询结果列名称和pojo名称不一致
	 */
	@Test
	public void selectUserRstMap(){
		SqlSession sqlSession = DBUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = mapper.selectUserRstMap();
		System.out.println(list);
		sqlSession.close();
	}
	
	/**
	 * 动态sql应用
	 */
	@Test
	public void selectUserByDyn(){
		SqlSession sqlSession = DBUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("张刚强");
		user.setSex(2);
		List<User> list = mapper.selectUserByDyn(user);
		System.out.println(list);
		sqlSession.close();
	}
	
	/**
	 * foreach
	 */
	@Test
	public void selectUserByForeach(){
		SqlSession sqlSession = DBUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(16);
		list.add(22);
		List<User> userlist = mapper.selectUserByForeach(list);
		System.out.println(JSON.toJSONString(userlist));
		sqlSession.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

