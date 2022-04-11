package ch.makery.address.view;

import java.io.IOException;
import java.util.Optional;

import ch.makery.address.Main;
import ch.makery.address.model.Person;
import ch.makery.address.view.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PersonOverviewController {
	@FXML
    private Button agregarPersona;
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

	// TODO Versión con map
	/*@FXML
    private TableView<Map<String,Object>> personTable;
    @FXML
    private TableColumn<Map<String,Object>, String> firstNameColumn;
    @FXML
    private TableColumn<Map<String,Object>, String> lastNameColumn;*/
	
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Referencia a la aplicación principal
    private Main mainApp;    
    
    /**
     * Método para inicializar el controlador que se llama cuando se carga el FXML
     */
    @FXML
    private void initialize() {   	
    	// Se inicializan las columnas firstName y lastName
    	// Alternativa sin función lambda
    	/*firstNameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Person,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Person, String> param) {
				return param.getValue().firstNameProperty();
			}
		});*/
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        
        agregarPersona.setOnAction(ev -> {
			try {
		        // Cargamos el diseño del diálogo desde un XML
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(PersonOverviewController.class.getResource("CreateEditPerson.fxml"));
		        BorderPane page = (BorderPane) loader.load();

		        // Se crea un nuevo Stage para mostrar el diálogo
		        Stage dialogStage = new Stage();
		        
		        Scene scene = new Scene(page);
		        dialogStage.setScene(scene);

		        // Carga el controlador con una referencia al Stage y carga al label de la ventana principal donde cargara el usuario
		        CreateEditPersonController controller = loader.getController();
		        controller.setDialogStage(dialogStage);
		        // Muestra el diálogo y no continúa el código hasta que lo cierra el usuario
		        
		        dialogStage.showAndWait();
		        
		        
		        
		    } catch (IOException e) {
		        e.printStackTrace();
		        
		    }
		});
    	
    	// TODO Versión con map 
    	// Se crea un objeto que herede de ObservableValue
    	/*firstNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("firstName").toString()));
    	lastNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("lastName").toString()));*/
    }

    /**
     * Referencia a la aplicación principal
     * 
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        personTable.setItems(this.mainApp.getPersonData());
        
        // TODO Versión con map
        //personTable.setItems(this.mainApp.getMapData()); 
    }
}