package crud;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/** * @date 创建时间：2016年9月14日 上午11:35:38 
 * @version 1.0 * @parameter 
 * @since 
 * @return  
 */
public class MongoDBInsert {
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
			MongoCollection<Document> collection = mongoDatabase.getCollection("col");
			System.out.println("集合 test 选择成功");
			 /** 
	         * 1. 创建文档 org.bson.Document 参数为key-value的格式 
	         * 2. 创建文档集合List<Document> 
	         * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
	         * */
	         Document document = new Document("title", "java").  
	         append("description", "database").  
	         append("likes", 200).  
	         append("by", "Fly");  
	         List<Document> documents = new ArrayList<Document>();  
	         documents.add(document);  
	         collection.insertMany(documents);  
	         System.out.println("文档插入成功"); 
	         mongoClient.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}
