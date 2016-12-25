package com.zgq.tools;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtils {
	
	
	public static SqlSessionFactory sqlsessionFactory;
	
	static {
		Reader config;
		try {
			config = Resources.getResourceAsReader("config.xml");
			sqlsessionFactory = new SqlSessionFactoryBuilder().build(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSession getSession(){
		return sqlsessionFactory.openSession();
	}

}
