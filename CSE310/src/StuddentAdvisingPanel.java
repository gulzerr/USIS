import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StuddentAdvisingPanel {
	
	StudentAdvising getinfo = new StudentAdvising();
	List<String> getcourse = getinfo.ShowCourses();

	
	StudentAdvising toadd = new StudentAdvising();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button advisingButton;

    @FXML
    private ListView<String> allCourses;
    
    ObservableList<String> list = FXCollections.observableArrayList(getcourse);
    ObservableList<String> selectedList = FXCollections.observableArrayList();
//    String selectedCourse;
    String droppedCourse;

    @FXML
    private ListView<String> takenCourses;

    @FXML
    private Button courseAddButton;

    @FXML
    private TextField retypemail;
    
    @FXML
    private Button courseDropButton;
 
    @FXML
    void addCourse(ActionEvent event) {
    	selectedList.add(allCourses.getSelectionModel().getSelectedItem());
    	String selectedCourse = allCourses.getSelectionModel().getSelectedItem();
//    	MainController getsessionid = new MainController();
    	String sessionid = retypemail.getText();
    	System.out.println(sessionid+" "+ selectedCourse);
    	toadd.addcourse( sessionid , selectedCourse);
    }

    @FXML
    void dropCourse(ActionEvent event) {
    	selectedList.remove(takenCourses.getSelectionModel().getSelectedItem());
    	droppedCourse = takenCourses.getSelectionModel().getSelectedItem();
    }

    @FXML
    void showAdvisingPanel(ActionEvent event) throws Exception {
    	Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("StuddentAdvisingPanel.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("BRACU USIS");  // Window Name
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    @FXML
    void initialize() {
        assert advisingButton != null : "fx:id=\"advisingButton\" was not injected: check your FXML file 'StuddentAdvisingPanel.fxml'.";
        assert allCourses != null : "fx:id=\"allCourses\" was not injected: check your FXML file 'StuddentAdvisingPanel.fxml'.";
        assert takenCourses != null : "fx:id=\"takenCourses\" was not injected: check your FXML file 'StuddentAdvisingPanel.fxml'.";
        assert courseAddButton != null : "fx:id=\"courseAddButton\" was not injected: check your FXML file 'StuddentAdvisingPanel.fxml'.";
        assert courseDropButton != null : "fx:id=\"courseDropButton\" was not injected: check your FXML file 'StuddentAdvisingPanel.fxml'.";
        assert retypemail != null : "fx:id=\"retypemail\" was not injected: check your FXML file 'StuddentAdvisingPanel.fxml'.";
        
        allCourses.setItems(list);
        takenCourses.setItems(selectedList);
    }
}

