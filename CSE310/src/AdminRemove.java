import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class AdminRemove {

	AdminSignBackend StudentInfo = new AdminSignBackend();
    @FXML
    private ResourceBundle resources;
    
    public String sendIdToRemove = "";
    
    @FXML
    private URL location;
    private ComboBox<String> StudentCRUD;
    private ComboBox<?> StudentAdvising;
    
    @FXML
    private TextField searchtxt;
    private Button search;
    
    private AnchorPane searchresult;
    @FXML
    private Text namefield;

    @FXML
    private Text surnamefield;

    @FXML
    private Text idfield;

    @FXML
    private Text mailfield;

    @FXML
    private Text sexfield;

    @FXML
    private Text agefield;

    @FXML
    private Text addressfield;

    @FXML
    private Text mobilefield;

    @FXML
    private Label nameresult;

    @FXML
    private Label surnameresult;

    @FXML
    private Label idresult;

    @FXML
    private Label mailresult;

    @FXML
    private Label sexresult;

    @FXML
    private Label ageresult;

    @FXML
    private Label addressresult;

    @FXML
    private Label mobileresult;
    
    @FXML
    private Label removeStatus;
    
    private Button remove; 

    ObservableList<String> list= FXCollections.observableArrayList("Register", "Update", "Remove");
    
    
    @FXML
    void removeclick(ActionEvent event)  throws Exception {
    	StudentInfo.deleteStudent(sendIdToRemove);
    	removeStatus.setText("Successfully Removed");
    }

    @FXML
    void searchclick(ActionEvent event) throws Exception {
    	String sendid = searchtxt.getText();
    	sendIdToRemove = searchtxt.getText();
    	System.out.println(sendid);
    	List<String> studentInfo = new ArrayList<String>();
    	studentInfo = StudentInfo.getStudentInfo(sendid);
    	System.out.println(studentInfo.get(0));
    	
    	nameresult.setText(studentInfo.get(0));
    	surnameresult.setText(studentInfo.get(1));
    	idresult.setText(studentInfo.get(2));
    	mailresult.setText(studentInfo.get(3));
    	sexresult.setText(studentInfo.get(4));
    	ageresult.setText(studentInfo.get(5));
    	addressresult.setText(studentInfo.get(6));
    	mobileresult.setText(studentInfo.get(7));

    }

    @FXML
    void selectStudentCRUD(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert StudentCRUD != null : "fx:id=\"StudentCRUD\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert StudentAdvising != null : "fx:id=\"StudentAdvising\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert searchtxt != null : "fx:id=\"searchtxt\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert search != null : "fx:id=\"search\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert searchresult != null : "fx:id=\"searchresult\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert namefield != null : "fx:id=\"namefield\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert surnamefield != null : "fx:id=\"surnamefield\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert idfield != null : "fx:id=\"idfield\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert mailfield != null : "fx:id=\"mailfield\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert sexfield != null : "fx:id=\"sexfield\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert agefield != null : "fx:id=\"agefield\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert addressfield != null : "fx:id=\"addressfield\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert mobilefield != null : "fx:id=\"mobilefield\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert nameresult != null : "fx:id=\"nameresult\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert surnameresult != null : "fx:id=\"surnameresult\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert idresult != null : "fx:id=\"idresult\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert mailresult != null : "fx:id=\"mailresult\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert sexresult != null : "fx:id=\"sexresult\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert ageresult != null : "fx:id=\"ageresult\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert addressresult != null : "fx:id=\"addressresult\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert mobileresult != null : "fx:id=\"mobileresult\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert remove != null : "fx:id=\"remove\" was not injected: check your FXML file 'AdminRemove.fxml'.";
        assert removeStatus != null : "fx:id=\"removeStatus\" was not injected: check your FXML file 'AdminRemove.fxml'.";

    }
}
