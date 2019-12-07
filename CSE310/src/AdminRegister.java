import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

public class AdminRegister {
	
	AdminSignBackend sendStudentInfo = new AdminSignBackend();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> StudentCRUD;

    @FXML
    private ComboBox<?> StudentAdvising;

    @FXML
    private AnchorPane surnameinput;

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
    private TextField firstnameinput;

    @FXML
    private TextField surNameInput;

    @FXML
    private TextField uIdInput;

    @FXML
    private TextField emailInput;
    
    @FXML
    private PasswordField passInput;

    @FXML
    private TextField genderInput;

    @FXML
    private TextField ageInput;

    @FXML
    private TextField addressInput;

    @FXML
    private TextField contactNoInput;

    @FXML
    private Button registerClick;
    
    @FXML
    private Label registerStatus;

    @FXML
    void selectStudentCRUD(ActionEvent event) {

    }

    @FXML
    void submitRegister(ActionEvent event) {
    	List<String> studentInfo = new ArrayList<String>();
    	studentInfo.add(firstnameinput.getText());
    	studentInfo.add(surNameInput.getText());
    	studentInfo.add(uIdInput.getText());
    	studentInfo.add(emailInput.getText());
    	studentInfo.add(passInput.getText());
    	studentInfo.add(genderInput.getText());
    	studentInfo.add(ageInput.getText());
    	studentInfo.add(addressInput.getText());
    	studentInfo.add(contactNoInput.getText());
    	
    	sendStudentInfo.register(studentInfo);
    	registerStatus.setText("Student Registered Successfully");
    }

    @FXML
    void initialize() {
        assert StudentCRUD != null : "fx:id=\"StudentCRUD\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert StudentAdvising != null : "fx:id=\"StudentAdvising\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert surnameinput != null : "fx:id=\"surnameinput\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert namefield != null : "fx:id=\"namefield\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert surnamefield != null : "fx:id=\"surnamefield\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert idfield != null : "fx:id=\"idfield\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert mailfield != null : "fx:id=\"mailfield\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert sexfield != null : "fx:id=\"sexfield\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert agefield != null : "fx:id=\"agefield\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert addressfield != null : "fx:id=\"addressfield\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert mobilefield != null : "fx:id=\"mobilefield\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert firstnameinput != null : "fx:id=\"firstnameinput\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert surNameInput != null : "fx:id=\"surNameInput\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert uIdInput != null : "fx:id=\"uIdInput\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert emailInput != null : "fx:id=\"emailInput\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert passInput != null : "fx:id=\"passInput\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert genderInput != null : "fx:id=\"genderInput\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert ageInput != null : "fx:id=\"ageInput\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert addressInput != null : "fx:id=\"addressInput\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert contactNoInput != null : "fx:id=\"contactNoInput\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert registerClick != null : "fx:id=\"registerClick\" was not injected: check your FXML file 'AdminRegister.fxml'.";
        assert registerStatus != null : "fx:id=\"registerStatus\" was not injected: check your FXML file 'AdminRegister.fxml'.";
    }
}
