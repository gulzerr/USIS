import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
// verify email for reseting password
public class verifyemail {

	sign forgetpassword= new sign();
	int check;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField verifyemailtxt;

    @FXML
    private PasswordField newpasstxt;

    @FXML
    private Button resetpass;

    @FXML
    private Label label;

    @FXML
    void reset(ActionEvent event) {
    	String email=verifyemailtxt.getText();
    	String pass=newpasstxt.getText();
    	check=forgetpassword.resetpassword(email, pass);
    	if (check == 0) {
    		label.setText("You cannot use your previous Password, Choose a different one");
    	}
    	else if (check == 1) { 
    		label.setText("Email doesn't exist in database");
    	}
    	else label.setText("Password reset successfull");

    }

    @FXML
    void initialize() {
        assert verifyemailtxt != null : "fx:id=\"verifyemailtxt\" was not injected: check your FXML file 'verifyemail.fxml'.";
        assert newpasstxt != null : "fx:id=\"newpasstxt\" was not injected: check your FXML file 'verifyemail.fxml'.";
        assert resetpass != null : "fx:id=\"resetpass\" was not injected: check your FXML file 'verifyemail.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'verifyemail.fxml'.";

    }
}
