package choiceEjercicio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainChoiceEjercicio extends Application {

private BorderPane rootLayout;	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainChoiceEjercicio.class.getResource("ChoiceEjercicioView.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejemplo sobre eventos");
			primaryStage.show();
			
			System.out.println(scene.getCursor());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public static void main(String[] args) {
		launch(args);
	}
}
