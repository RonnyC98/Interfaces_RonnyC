package eventosValidar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainEventosValidar extends Application{
	
private BorderPane rootLayout;	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainEventosValidar.class.getResource("EventosValidarView.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene = new Scene(rootLayout);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejemplo sobre diálogos");
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
