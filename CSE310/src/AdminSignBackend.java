import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.util.JSON;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.*;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class AdminSignBackend {
	
	public boolean signin(String mail, String pass) {
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("AdminInfo");
		
		Document found=(Document) collection.find(new Document("email",mail)).first();
		String temp = found.getString("password");
		
		if(found != null && pass.equals(temp)) {
			return true;
		}
		else {
			return false;
		}
				
	}
	
	List studentNames;
	
	public List sendStuList() {
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("StudentDetails");
		
		DB db = mongoclient.getDB("StudentInfo");
		DBCollection coll=db.getCollection("StudentDetails");
		
		DBCursor cursor=coll.find();
		List<DBObject> prev1 = null;
		
		int i=0;
		
		while(cursor.hasNext()) {
			prev1.add(cursor.next());
			System.out.println(prev1.get(i));
			i++;
		}
		return studentNames;
	}
	
	public List<String> getStudentInfo(String id) {
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("StudentDetails");
		
		Document found=(Document) collection.find(new Document("id",id)).first();
		List<String> studentInfo = new ArrayList<String>();
		
		String temp = found.getString("first name");
		studentInfo.add(temp);
		
		temp = found.getString("surname");
		studentInfo.add(temp);
		
		temp = found.getString("id");
		studentInfo.add(temp);
		
		temp = found.getString("email");
		studentInfo.add(temp);
		
		temp = found.getString("sex");
		studentInfo.add(temp);
		
		temp = found.getString("age");
		studentInfo.add(temp);
		
		temp = found.getString("address");
		studentInfo.add(temp);
		
		temp = found.getString("contact");
		studentInfo.add(temp);
		
		
		return studentInfo;
	}
	
	public void deleteStudent(String ID) {
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("StudentDetails");
		
		Document found=(Document) collection.find(new Document("id",ID)).first();
		collection.deleteOne(found);
	}
	
	
	public void register(List<String> studentInfo) {
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("StudentDetails");
		
		Document found=(Document) collection.find(new Document("email",studentInfo.get(3))).first();
		
		if(found != null) {
			System.out.println("This email address already exists on database, use a different email address to sign up");;
		}
		
		else if(found == null) {
			Document document=new Document("first name", studentInfo.get(0));
			document.append("surname", studentInfo.get(1));
			document.append("id",studentInfo.get(2));
			document.append("email", studentInfo.get(3));
			document.append("password", studentInfo.get(4));
			document.append("sex", studentInfo.get(5));
			document.append("age", studentInfo.get(6));
			document.append("address", studentInfo.get(7));
			document.append("contact", studentInfo.get(8));
			collection.insertOne(document);
			
			System.out.println("Signed up successfully");
		}
		
	}
}
