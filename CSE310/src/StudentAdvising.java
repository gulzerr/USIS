import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class StudentAdvising {
//	public String sessionid= "";
	
	public List<String> ShowCourses(){
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("CourseSchedule");
		
		MainController getsessionid = new MainController();
		String sessionid=getsessionid.sessionid;
		
		List<Document> courses = (List<Document>) collection.find().into(new ArrayList<Document>());
		List<String> courseCode = new ArrayList<String>();
		
		for(Document course : courses) {
			List<Document> sections = (List<Document>) course.get("sections");
			for (Document section : sections) {
				courseCode.add((String) section.get("section"));
			}
		}
		return courseCode;
	}
	
	public void addcourse(String sessionid , String courseName) {

    	System.out.println(sessionid+" "+courseName);
		MongoClient mongoclient= new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoclient.getDatabase("StudentInfo");
		MongoCollection collection = mongoDatabase.getCollection("StudentDetails");
		MongoCollection collectionCourse = mongoDatabase.getCollection("AllSections");
		
		Document foundCourseSection = (Document) collectionCourse.find(new Document("section",courseName)).first();
		
//		String sectionname = foundCourseSection.getString("courseName");
		List<Integer> theoryTime = foundCourseSection.getList("theorytime", Integer.class);
		List<Integer> labTime = foundCourseSection.getList("labtime", Integer.class);
		
		Document query = new Document();
        query.append("email" , sessionid);
        
        Document setData = new Document();
        setData.append("courseSection", courseName);
        setData.append("theorytime", theoryTime);
        setData.append("labtime", labTime);
        
        Document setarray = new Document();
        setarray.append("takenCourses", setData);
        
        Document update = new Document();
        update.append("$push", setarray);
        collection.updateOne(query, update);
	}
}
