package com.zgq.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zgq.pojo.User;
import com.zgq.pojo.UserQueryVO;

public interface UserMapper {

	public User selectById(int aa);

	@Select("select * from user where id=#{id}")
	public User selectByIdforanno(int id);

	int insertBatchUser(List<User> list);

	List<User> selectAllUser();

	List<User> selectUserByName(String value);

	int updateUserByid(User user);

	int insertOneUserGetId(User user);

	List<User> selectUserQueryVO(UserQueryVO userQueryVO);

	List<User> selectUserByMap(HashMap<?, ?> map);

	int selectUserCount(User user);

	List<User> selectUserRstMap();

	List<User> selectUserByDyn(User user);

	List<User> selectUserByForeach(List list);

}
