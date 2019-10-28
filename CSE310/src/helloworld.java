import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;

public class helloworld extends Application {
	public static void main (String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		Button btn=new Button("Click me");
		Button exit=new Button("Exit");
		
		// exit and exit with message
		exit.setOnAction(e-> {
			System.out.println("Exit the app");
			System.exit(0);
		});  //exit
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Hello World");  //print hello world
			}
		});
		String st="My Title";
		VBox root= new VBox();
		root.getChildren().addAll(btn,exit);
		Scene scene=new Scene(root,500,300);
		primaryStage.setTitle(st);  // Window Name
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
