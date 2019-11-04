import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
	
	sign signin=new sign();
	boolean success;  //for login success
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
    private Hyperlink forgotpass;

    @FXML
    void forgot(ActionEvent event) throws Exception{
    	Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("verifyemail.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("My Title");  // Window Name
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.close();
    }

    @FXML
    void submit_click(ActionEvent event) {
    	String email=emailtxt.getText();
    	String pass=passtxt.getText();
    	success=signin.signin(email, pass);
    	if (success == true) {
    		label.setText("Sign in successfull");
    	}
    	else label.setText("Email or password doesn't match with database");
    }

    @FXML
    void initialize() {
        assert emailtxt != null : "fx:id=\"emailtxt\" was not injected: check your FXML file 'Login.fxml'.";
        assert passtxt != null : "fx:id=\"passtxt\" was not injected: check your FXML file 'Login.fxml'.";
        assert submit != null : "fx:id=\"submit\" was not injected: check your FXML file 'Login.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Login.fxml'.";
        assert forgotpass != null : "fx:id=\"forgotpass\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
