import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.*;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBObject;

public class Store {

	public static void main(String[]args) {
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("StudentDetails");
		
		
//		BasicDBObject whereQuery=new BasicDBObject();
//		whereQuery.put("email", "jabed@gmail.com");
//		MongoCursor<Document> cursor = collection.find(whereQuery).iterator();
//		while (cursor.hasNext()) {
//		    Document str = cursor.next();
//
//		    List<Document> list = (List<Document>)str.get("previousPass");
//		    Object str1=str.get(1);
//		    System.out.println(str1);
//		    try {
//		    System.out.println(list.get(2)); // display specific field
//		    System.out.println(list.get(3));
//		    }
//		    catch (Exception e) {
//		    }
//		}
		
		System.out.println("Database connected");
//		System.out.println("signin or signup?");
//		String chosen=sc.nextLine();
//		
		
//		sign signin= new sign();
//		signin.signin();
//		
//		sign signup= new sign();
//		signup.signup();
		
//		System.out.println("Forgot password?");
//		sign forgetpassword= new sign();
//		forgetpassword.resetpassword();
			
		
//		create document
//		List<String> prevpass=Arrays.asList("gulzer123");
//		Document document=new Document("name", "Bulbul Gulzer Deb");
//		document.append("email", "gulzer.deb@gmail.com");
//		document.append("password", "gulzer123");
//		document.append("Sex", "male");
//		document.append("age", "19");
//		document.append("address", "Narinda, Dhaka");
//		document.append("prevpass", prevpass);	
//		collection.insertOne(document); 
		
		
//		DBObject listItem = new BasicDBObject("scores", new BasicDBObject("type","quiz").append("score",99));
//		DBObject updateQuery = new BasicDBObject("$push", listItem);
//		myCol.update(findQuery, updateQuery);
		
//		update document
		
		Document found=(Document) collection.find(new Document("email","gulzer.deb@gmail.com")).first();
		List<String> prev;
		
		if(found != null) {
			System.out.println("Found USer");
			prev=found.getList("prevpass", String.class);
//			System.out.println("Name:"+found.get("name"));
//			System.out.println("Previous Passwords: "+found.getList("prevpass", String.class));
			List<String> prevpass=Arrays.asList("gulzer123");
//			document.append("prevpass", prevpass);
			for(int n=0; n<prev.size(); n++) {
				System.out.println(prev.get(n));
			}
//			
//			Bson updatedvalue = new Document("previousPass", "jabed123");
//			Bson updateoperation = new Document("$set", updatedvalue);
//			collection.updateOne(found, updateoperation);
//			System.out.println("User updated");
		}
//		
//	    document aggregated		
		
//		Block<Document> printBlock = document -> System.out.println(document.toJson());
//
//        collection.aggregate(
//                Arrays.asList(
//                        Aggregates.match(Filters.eq("age", 27)),
//                        Aggregates.group("$color", Accumulators.sum("count", 1)
//                        ))
//        ).forEach(printBlock);
//
//        System.out.println("Collection Aggregrated.");
		
	}
}
