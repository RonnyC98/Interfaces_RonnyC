package choiceEjercicio;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

public class ChoiceEjercicioController {
	@FXML
	 private ListView<String> list1;
	@FXML
    private Button botonMostrarDialogo;
	 @FXML
	 private void initialize() {
		 
	 list1.getItems().addAll("Opción 1", "Opción 2",
			 "Opción 3", "Opción 4", "Opción 5", "Opción 6", 
			 "Opción 7", "Opción 8", "Opción 9", "Opción 10");
	 list1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	 botonMostrarDialogo.setDisable(true);
	 
	 
	 list1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//		        System.out.println("ListView selection changed from oldValue = " 
//		                + oldValue + " to newValue = " + newValue);
		        if(newValue!=null) {
		        	botonMostrarDialogo.setDisable(false);
		        }else {
		        	botonMostrarDialogo.setDisable(true);
		        	System.out.println("no hay nada seleccionado");
		        }
		    }
		});
	 
	 list1.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
		 if(botonMostrarDialogo.isDisable()) {
			 Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText("Sin ítems seleccionados");
				alert.setTitle("Aviso sobre listado");
				alert.setContentText("No se puede mostrar el diálogo hasta que se seleccione un ítem como mínimo");
				alert.showAndWait();
		 }
		 
		});
	 
	 }
	 

}
