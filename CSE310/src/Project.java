import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.*;
import javafx.fxml.*;

public class Project extends Application {
	public static void main (String[] args) {
		launch(args);
	}
	
	public void start (Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setTitle("My Title");  // Window Name
		primaryStage.setScene(scene);
//		scene.setFill(Color.TRANSPARENT);
		primaryStage.show();
	}
}



