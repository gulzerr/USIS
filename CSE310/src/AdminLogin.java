import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminLogin {
	
	AdminSignBackend signin=new AdminSignBackend();
	boolean success;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField emailtxt;

    @FXML
    private PasswordField passtxt;

    @FXML
    private Button submit;

    @FXML
    private Label label;

    @FXML
    private Button StudentLogin;

    @FXML
    void Studentloginclick(ActionEvent event) throws Exception {
    	Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("BRACU USIS");  // Window Name
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    @FXML
    void submit_click(ActionEvent event) throws Exception {
    	String email=emailtxt.getText();
    	String pass=passtxt.getText();
    	success=signin.signin(email, pass);
    	if (success == true) {
    		label.setText("Sign in successfull");
    	}
    	else label.setText("Invalid Login Data");
    	
    	Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("BRACU USIS");  // Window Name
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    @FXML
    void initialize() {
        assert emailtxt != null : "fx:id=\"emailtxt\" was not injected: check your FXML file 'AdminLogin.fxml'.";
        assert passtxt != null : "fx:id=\"passtxt\" was not injected: check your FXML file 'AdminLogin.fxml'.";
        assert submit != null : "fx:id=\"submit\" was not injected: check your FXML file 'AdminLogin.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'AdminLogin.fxml'.";
        assert StudentLogin != null : "fx:id=\"StudentLogin\" was not injected: check your FXML file 'AdminLogin.fxml'.";

    }
}
