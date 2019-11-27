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

public class MongoMain {

	public static void main(String[]args) {
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("StudentDetails");
				
		System.out.println("Database connected");
			
//		sign signin= new sign();
//		signin.signin();
//		
//		sign signup= new sign();
//		signup.signup();
		
//		System.out.println("Forgot password?");
//		sign forgetpassword= new sign();
//		forgetpassword.resetpassword();
	}
}
