package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Objeto principal que se pasar� como par�metro a Scene
			Group root = new Group();
			Scene scene = new Scene(root, 500, 500, Color.BLACK);
			// Escenario principal con la escena creada anteriormente y t�tulo
			primaryStage.setTitle("JavaFX Scene Graph Demo");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
