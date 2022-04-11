package ch.makery.address.view;

import java.net.URL;
import java.util.ResourceBundle;

import ch.makery.address.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateEditPersonController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtbirthday;

	@FXML
	private TextField txtcity;

	@FXML
	private TextField txtfname;

	@FXML
	private TextField txtlname;

	@FXML
	private TextField txtpcode;

	@FXML
	private TextField txtstreet;
	
	private Stage dialogStage;

	@FXML
	void initialize() {
		
	}
	
	@FXML
    void validarCambios(ActionEvent event) {
		String msgError = "";
		
		try {
			
			msgError = hayErrores();
			if(!msgError.equals("")) {
				Alert alert0 = new Alert(Alert.AlertType.ERROR);
				alert0.setHeaderText("Por favor, rellena correctamente los campos");
				alert0.setTitle("Hay campos incorrectos");
				alert0.setContentText(msgError);
				alert0.showAndWait();
			}
				
			
			
			Person p = new Person(this.txtfname.getText(), this.txtlname.getText(), this.txtstreet.getText(), 
					Integer.parseInt(this.txtpcode.getText()), this.txtcity.getText(), DateUtil.parse(this.txtbirthday.getText()));
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Aviso de confirmación");
			alert.setContentText("Persona creada");
			alert.showAndWait();
			dialogStage.close();
			
		} catch (NumberFormatException nfe) {
			// a
		}catch (Exception e) {
			e.printStackTrace();
		}
    
	
	}
	
	public String hayErrores(){
		String errorMsg = "";
		try {
			
		
			if(comprobarCampoEnBlanco(txtfname)) 
				errorMsg += "El campo first name está vacío"+"\n";
			if(comprobarCampoEnBlanco(txtlname)) 
				errorMsg += "El campo last name está vacío"+"\n";
			if(comprobarCampoEnBlanco(txtstreet)) 
				errorMsg += "El campo street name está vacío"+"\n";
			if(comprobarCampoEnBlanco(txtcity))
				errorMsg += "El campo city está vacío"+"\n";
			if(comprobarCampoEnBlanco(txtpcode)) {
				errorMsg += "El campo postal code está vacío"+"\n";
			}else if(!isNumeric(txtpcode.getText())) {
				errorMsg += "Postal Code no válido. Debe ser un número entero"+"\n";
			}
			if(comprobarCampoEnBlanco(txtbirthday)) {
				errorMsg += "El campo birthday está vacío"+"\n";
			}else if(!DateUtil.validDate(txtbirthday.getText())) {
				errorMsg += "El campo birthday no es válido. Usa el formato dd/mm/yy";
			}
			
		} catch (NumberFormatException nfe) {
			// a
		}catch (Exception e) {
			e.printStackTrace();
		}
		return errorMsg;
		
	}
	
	public boolean comprobarCampoEnBlanco(TextField txtContent) {
		if(txtContent.getText() == null || txtContent.getText() == "" ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	

}
