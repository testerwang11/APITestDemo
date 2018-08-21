package com.autotest.utils.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory = null;
	private static SqlSession sess;
	private static String openenv="";

	/**
	 * 初始化Session工厂
	 * 
	 * @return SqlSession
	 * 
	 * @throws IOException
	 */
	public static SqlSession initialFactory(String env) throws IOException {
        System.out.println(env);
		try {
			//如果env不是最后一次链接
			if (openenv!=env) {
				// resource默认为 dbconfig.xml
				InputStream in =ClassLoader.getSystemResourceAsStream("dbconfig.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build((in), env);
				sess = sqlSessionFactory.openSession();
				openenv=env;
			}
			return sess;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return sess;
	}
	public static void close(){
		openenv=null;
		sess.close();
	}

    public static void main(String[] args) throws IOException, SQLException {
        SqlSession myBatisUtil = MyBatisUtil.initialFactory("springtest");
        myBatisUtil.getConnection().isClosed();
        myBatisUtil.close();
    }

}
