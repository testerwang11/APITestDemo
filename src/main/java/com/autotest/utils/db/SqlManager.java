package com.autotest.utils.db;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class SqlManager {
	public SqlSession session = null;

	/**
	 * 初始化SqlSession
	 * @param env 环境参数 environment id，默认ymtalpha
	 */
	public SqlManager(String env) {
		if (env == null) {
			try {
				session=MyBatisUtil.initialFactory("springtest");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				session=MyBatisUtil.initialFactory(env);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取sqlsession
	 * @return sqlsession
	 */
	public SqlSession getSession() {
		return session;
	}
	/**
	 * 
	 * 执行select语句
	 * @param mapperMethodName 例如 com.autotest.database.dao.ApiRunHistoryMapper.selectBySActionId
	 * @param param 参数，多个参数时可用Map
	 * @return List results 结果集List
	 */
	@SuppressWarnings("rawtypes")
	public List getSelectResults(String mapperMethodName,Object param){
		List results = session.selectList(mapperMethodName,param);
		return results;
	}
	/**
	 * @param mapperMethodName
	 * @param param 参数，多个参数时可用Map
	 * @return update 影响行数
	 */
	public int update(String mapperMethodName,Object param){
		int result = session.update(mapperMethodName,param);
		return result;
	}
	
	/**
	 * 执行delete语句
	 * @param mapperMethodName
	 * @param param 参数，多个参数时可用Map
	 * @return delete 影响行数
	 */
	public int delete(String mapperMethodName,Object param){
		int result = session.delete(mapperMethodName,param);
		return result;
	}
	/**
	 * 执行insert语句
	 * @param mapperMethodName
	 * @param param 参数，多个参数时可用Map
	 * @return insert 影响行数
	 */
	public int insert(String mapperMethodName,Object param){
		int result = session.insert(mapperMethodName,param);
		return result;
	}
	/**
	 * 提交commit
	 */
	public void commit(){
		session.commit();
	}
	/**
	 * 回滚rollback
	 */
	public void rollback(){
		session.rollback();
	}
	/**
	 * close关闭数据库连接
	 */
	public void close(){
		MyBatisUtil.close();
	}
	
}
