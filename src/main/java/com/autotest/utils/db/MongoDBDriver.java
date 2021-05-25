package com.autotest.utils.db;

import java.util.ArrayList;
import java.util.Set;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.ServerAddress;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

/**
 * MongoDBDriver
 *
 */
public class MongoDBDriver {

	/**
	 * db
	 */
	private DB db;

	/**
	 * 当前选择的collection collection
	 */
	public DB getDb() {
		return db;
	}

	public DBCollection getCollection() {
		return collection;
	}

	private DBCollection collection;

	/**
	 * 初始化MongoDB
	 * 
	 * @param host
	 *            MongoDB host 127.0.0.1 localhost
	 * @param port
	 *            MongoDB port 27017
	 * @param dbname
	 *            MongoDB name
	 * @throws Exception
	 */

	public MongoDBDriver(String host, int port, String dbname) throws Exception {
		Mongo mongo = new Mongo(new ServerAddress(host, port));
		db = mongo.getDB(dbname);
	}

	/**
	 * 默认初始化MongoDB
	 * 
	 * @param dbname
	 *            MongoDB name
	 * @throws Exception
	 */
	public MongoDBDriver(String dbname) throws Exception {
		Mongo mongo = new Mongo();
		db = mongo.getDB(dbname);
	}

	/**
	 * 选择DB collection
	 * 
	 * @param collectionname
	 *            collection名
	 * @return DBCollection
	 */
	public void selectCollection(String collectionname) {
		collection = db.getCollection(collectionname);
	}

	/**
	 * 获取DB的collection name列表
	 * 
	 * @return Set<String> collection name
	 */
	public Set<String> getCollectionNames() {
		Set<String> names = db.getCollectionNames();
		return names;
	}

	/**
	 * 插入一串JSON串到选中的collection
	 * 
	 * @param json
	 * @throws Exception
	 */
	public void insertJSON(String json) throws Exception {
		if (collection != null) {
			DBObject dbobjct = (DBObject) JSON.parse(json);
			collection.insert(dbobjct);
		} else {
			throw new Exception("no select collection!");
		}
	}

	/**
	 * 遍历查询所有
	 * 
	 * @throws Exception
	 */
	public ArrayList<String> selectAll() throws Exception {
		ArrayList<String> all = new ArrayList<String>();
		if (collection != null) {
			DBCursor cursor = collection.find();
			while (cursor.hasNext()) {
				all.add(cursor.next().toString());
			}
		} else {
			throw new Exception("no select collection!");
		}
		return all;
	}
	/**
	 * 遍历查询所有 返回限制数量的结果
	 * @param len 结果数量
	 * @throws Exception
	 */
	public ArrayList<String> selectLimit(int len) throws Exception {
		ArrayList<String> all = new ArrayList<String>();
		int temp=0;
		if (collection != null) {
			DBCursor cursor = collection.find();
			while (cursor.hasNext()&&temp<len) {
				all.add(cursor.next().toString());
				temp++;
			}
		} else {
			throw new Exception("no select collection!");
		}
		return all;
	}
	/**
	 * 根据条件查询
	 * @param Json
	 *            查找条件
	 * @throws Exception
	 */
	public ArrayList<String> selectPart(String json) throws Exception {
		ArrayList<String> all = new ArrayList<String>();
		if (collection != null) {
			BasicDBObject queryObject = (BasicDBObject) JSON.parse(json);
			DBCursor querycursor = collection.find(queryObject);
			while (querycursor.hasNext()) {
				all.add(querycursor.next().toString());
			}
		} else {
			throw new Exception("no select collection!");
		}
		return all;
	}
	/**
	 * 根据条件查询符合条件的记录数量
	 * @param Json
	 *            查找条件
	 * @throws Exception
	 */
	public int selectCount(String json) throws Exception {
		int count=0;
		if (collection != null) {
			BasicDBObject queryObject = (BasicDBObject) JSON.parse(json);
			count= collection.find(queryObject).count();
		} else {
			throw new Exception("no select collection!");
		}
		return count;
	}
	/**
	 * 根据条件查询,返回限制长度的结果集
	 * @param findJson
	 *            查找条件
	 * @param len 结果数量           
	 * @throws Exception
	 */
	public ArrayList<String> selectPartLimit(String json,int len) throws Exception {
		ArrayList<String> all = new ArrayList<String>();
		int temp=0;
		if (collection != null) {
			BasicDBObject queryObject = (BasicDBObject) JSON.parse(json);
			DBCursor querycursor = collection.find(queryObject);
			while (querycursor.hasNext()&&temp<len) {
				all.add(querycursor.next().toString());
				temp++;
			}
		} else {
			throw new Exception("no select collection!");
		}
		return all;
	}
	/**
	 * 更新操作 更新一条记录
	 * 
	 * @param findJson
	 *            查找条件
	 * @param updateJson
	 *            更新内容
	 * @return WriteResult 更新结果
	 * @throws Exception
	 */

	public WriteResult update(String findJson, String updateJson)
			throws Exception {
		WriteResult wr = null;

		if (collection != null) {
			BasicDBObject queryObject = (BasicDBObject) JSON.parse(findJson);
			BasicDBObject updateObject = (BasicDBObject) JSON.parse(updateJson);
			wr = collection.update(queryObject, updateObject);
		}

		else {
			throw new Exception("no select collection!");
		}
		return wr;
	}

	/**
	 * 按条件删除文档
	 * 
	 * @param findJson
	 *            查找条件
	 * @throws Exception
	 * @return WriteResult 删除结果
	 */
	public WriteResult delete(String findJson) throws Exception {
		WriteResult wr = null;
		if (collection != null) {
			BasicDBObject queryObject = (BasicDBObject) JSON.parse(findJson);
			wr = collection.remove(queryObject);
		}
		else {
			throw new Exception("no select collection!");
		}
		return wr;
	}

	public static void main(String[] args) throws Exception {
		MongoDBDriver mdd = new MongoDBDriver("172.16.100.104", 27018,
				"ShoppingCart");
		mdd.selectCollection("Ymt_ShoppingCart");
		Set<String> names = mdd.getCollectionNames();
		for (String name : names) {
		 System.out.println("CollectionName"+name);
		 }
		
//		WriteResult r = mdd.update("{\"_id\":\"553ddb482d1e67163cbc7695\"}", "{\"pname\":\"测试一下修改pname\"}");
//		System.out.println("update:"+r.getN());
//		ArrayList<String> part = mdd
//				.selectPart("{\"_id\":\"553ddb482d1e67163cbc7695\"}");
//		System.out.println("selectPart:"+part.get(0));
		ArrayList<String> all = mdd.selectLimit(2);
		for (String s : all) {
			System.out.println("selectLimit 2:"+s);
		}
	}

}