import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController {
	
	sign signin=new sign();
	
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
    void submit_click(ActionEvent event) {
    	String email=emailtxt.getText();
    	String pass=passtxt.getText();
    	String Status=signin.signin(email, pass);
    	label.setText(Status);

    }

    @FXML
    void initialize() {
        assert emailtxt != null : "fx:id=\"emailtxt\" was not injected: check your FXML file 'Login.fxml'.";
        assert passtxt != null : "fx:id=\"passtxt\" was not injected: check your FXML file 'Login.fxml'.";
        assert submit != null : "fx:id=\"submit\" was not injected: check your FXML file 'Login.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
