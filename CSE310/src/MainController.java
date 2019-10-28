import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextField email;

    @FXML
    private Button submit;

    @FXML
    void submit_click(ActionEvent event) {
    	System.out.println("hello world");
    	System.out.println(email.getText());
    }

    @FXML
    void initialize() {
        assert submit != null : "fx:id=\"submit\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
