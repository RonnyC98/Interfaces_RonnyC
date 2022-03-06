package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainLayouts extends Application {
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
          
		try {
			// Carga el XML con el dise�o principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainLayouts.class.getResource("MainLayouts.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Se a�ade el dise�o principal a la escena
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejercicios (1), (2), (4.1)");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
