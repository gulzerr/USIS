import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AdminPanel implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public ComboBox<String> StudentCRUD;
    
    @FXML
    private ComboBox<?> StudentAdvising;
    
    @FXML
    private Label label;

    
    ObservableList<String> list= FXCollections.observableArrayList("Register", "Update", "Remove");
	
	String combovalue="";
	public void selectStudentCRUD(ActionEvent event) throws Exception {
		combovalue = StudentCRUD.getValue();
		if(combovalue.equalsIgnoreCase("Remove")) {
			Stage primaryStage=new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("AdminRemove.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("BRACU USIS");  // Window Name
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		else if(combovalue.equalsIgnoreCase("Register")) {
			Stage primaryStage=new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("AdminRegister.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("BRACU USIS");  // Window Name
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 assert StudentCRUD != null : "fx:id=\"StudentCRUD\" was not injected: check your FXML file 'AdminPanel.fxml'.";
	     assert StudentAdvising != null : "fx:id=\"StudentAdvising\" was not injected: check your FXML file 'AdminPanel.fxml'.";
	     assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'AdminPanel.fxml'.";

		StudentCRUD.setItems(list);
	}
	
}
