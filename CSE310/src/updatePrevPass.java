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

public class updatePrevPass {
	
	public void updatePreviousPassArray(String mail, String pass) {
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("StudentDetails");
		
		Document found=(Document) collection.find(new Document("email",mail)).first();
		
		if(found != null) {
			Bson test= new Document("prevpass",pass);
			Bson updatePrevPass= new Document("$push",test);
			collection.updateOne(found,updatePrevPass);
		}
		
	}
}
