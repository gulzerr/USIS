import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StudentPanel {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button advisingButton;

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
        assert advisingButton != null : "fx:id=\"advisingButton\" was not injected: check your FXML file 'StudentPanel.fxml'.";

    }
}
