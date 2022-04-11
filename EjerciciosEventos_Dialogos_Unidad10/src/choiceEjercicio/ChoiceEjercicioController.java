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
		 
	 list1.getItems().addAll("Opci�n 1", "Opci�n 2",
			 "Opci�n 3", "Opci�n 4", "Opci�n 5", "Opci�n 6", 
			 "Opci�n 7", "Opci�n 8", "Opci�n 9", "Opci�n 10");
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
				alert.setHeaderText("Sin �tems seleccionados");
				alert.setTitle("Aviso sobre listado");
				alert.setContentText("No se puede mostrar el di�logo hasta que se seleccione un �tem como m�nimo");
				alert.showAndWait();
		 }
		 
		});
	 
	 }
	 

}
