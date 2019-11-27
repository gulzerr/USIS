import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.*;
import java.lang.Object;
import com.mongodb.util.JSON;

public class sign {
	
//	sign in


	public boolean signin(String mail, String pass) {
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("StudentDetails");
		
		Document found=(Document) collection.find(new Document("email",mail)).first();
		String temp = found.getString("password");
		
		if(found != null && pass.equals(temp)) {
			return true;
		}
		else {
			return false;
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
	
	public int resetpassword(String mail, String pass) {
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("StudentDetails");
		
		Document found=(Document) collection.find(new Document("email",mail)).first();
		List<String> prev;
		
		updatePrevPass update=new updatePrevPass();
		String match="";
		int resetstatuscode=10;
		
		if(found != null) {
			System.out.println("Found User");		
			prev=found.getList("prevpass", String.class);
			for(int n=0; n<prev.size(); n++) {
				match=prev.get(n);				
				if(match.equals(pass)) {
					System.out.println("You cannot use your previous Password, Choose a different one");
					resetstatuscode=2;
					return 0;
				}
			}
			if (resetstatuscode != 2) {
			Bson updatedvalue = new Document("password", pass);
			Bson updateoperation = new Document("$set", updatedvalue);
			collection.updateOne(found, updateoperation);
			update.updatePreviousPassArray(mail,pass);	
			return resetstatuscode;
			}
		}
		
		return 1;
	}
}
