package crud;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/**
 * * @date 创建时间：2016年9月14日 上午11:35:38
 * 
 * @version 1.0 * @parameter
 * @since
 * @return
 */
public class MongoDBDelete {
	public static void main(String[] args) {
		try {
			// 连接到 mongodb 服务
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			// 连接到数据库
			MongoDatabase mongoDatabase = mongoClient.getDatabase("runoob");
			System.out.println("Connect to database successfully");
			try {
				mongoDatabase.createCollection("col");
				System.out.println("集合创建成功");
			} catch (Exception e) {
				System.out.println("集合已存在");
			}
			MongoCollection<Document> collection = mongoDatabase
					.getCollection("col");
			System.out.println("集合 test 选择成功");
			// 删除符合条件的第一个文档
			collection.deleteOne(Filters.eq("b", "10"));
			// 删除所有符合条件的文档
			collection.deleteMany(Filters.eq("likes", 200));
			// 检索查看结果
			FindIterable<Document> findIterable = collection.find();
			MongoCursor<Document> mongoCursor = findIterable.iterator();
			while (mongoCursor.hasNext()) {
				System.out.println(mongoCursor.next());
			}
			mongoClient.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}
