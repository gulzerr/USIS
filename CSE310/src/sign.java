import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.util.JSON;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSONParseException;

import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.*;

public class sign {
	
//	sign in


	public String signin(String mail, String pass) {
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("StudentDetails");
		
		Scanner sc=new Scanner(System.in);
		
//		System.out.println("Enter your email address");
//		String mail=mail;
		
//		System.out.println("Enter your password");
//		String pass=password;
		
		Document found=(Document) collection.find(new Document("email",mail)).first();
		
		if(found != null) {
			return "Sign in successfull";
		}
		
		else {
			return "Email or password doesn't match with database";
		}
				
	}
	
//	sign up
	
	public void signup() {
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("StudentDetails");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter your name");
		String name=sc.nextLine();
		
		System.out.println("Enter your email address");
		String mail=sc.nextLine();
		
		System.out.println("Enter your password");
		String pass=sc.nextLine();
		
		System.out.println("Enter your sex");
		String sex=sc.nextLine();
		
		System.out.println("Enter your age");
		String age=sc.nextLine();
		
		System.out.println("Enter your address");
		String address=sc.nextLine();
		
		Document found=(Document) collection.find(new Document("email",mail)).first();
		
		if(found != null) {
			System.out.println("This email address already exists on database, use a different email address to sign up");;
		}
		
		else if(found == null) {
			Document document=new Document("name", name);
			document.append("email", mail);
			document.append("password",pass);
			document.append("Sex", sex);
			document.append("age", age);
			document.append("address", address);
			collection.insertOne(document);
			
			System.out.println("Signed up successfully");
		}
		
	}
	
//	reset password
	
	public void resetpassword() {
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("StudentDetails");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your email address");
		String mail=sc.nextLine(); //gulzer.deb@gmail.com
		
		System.out.println("Enter new password");
		String pass=sc.nextLine();
		
		Document found=(Document) collection.find(new Document("email",mail)).first();
		List<String> prev;
		
		boolean match=false;
		
		if(found != null) {
			System.out.println("Found USer");
			
			Bson updatedvalue = new Document("password", pass);
			Bson updateoperation = new Document("$set", updatedvalue);
			Bson test= new Document("prevpass","riasatKhan");
			Bson updateTest= new Document("$push",test);
			System.out.println(found);
			collection.updateOne(found,updateTest);
			System.out.println(found);
			collection.updateOne(found, updateoperation);
			
//			prev=found.getList("prevpass", String.class);
			
//			for(int n=0; n<prev.size(); n++) {
//				if(prev.get(n) == pass) {
//					System.out.println("You cannot use your previous Password, Choose a different one");
//					pass=sc.nextLine();
//					n=0;
//				}
//			}
//			
//			DBObject listItem = new BasicDBObject("scores", new BasicDBObject("type","quiz").append("score",99));
//			DBObject updateQuery = new BasicDBObject("$push", listItem);
//			StudentDetails.update(findQuery, updateQuery);
		}
	}
}
