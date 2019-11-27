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
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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
		List prev = (List) new ArrayList();
		int i=0;
		
		while(cursor.hasNext()) {
			prev.add(cursor.next());
			System.out.println(prev.get(i));
			i++;
		}
		
		for(int i=0; i<prev.size(); i++) {
			System.out.println(prev);
		}
		
		String temp = found.getString("password");
		return studentNames;
	}
}
