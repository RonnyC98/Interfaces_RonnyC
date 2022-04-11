package eventosValidar;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;

public class EventosValidarController {

	@FXML
	private Button bMostrarDialogo;

	@FXML
	private TextField labelText;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	void mostrarDialogo(ActionEvent event) {
		TextInputDialog textDialog = new TextInputDialog();
		textDialog.initModality(Modality.APPLICATION_MODAL);
		textDialog.setTitle("Ejemplo de diálogo");
		textDialog.setHeaderText("Diálogo para introducir un texto");

		TextField txtField = textDialog.getEditor();

		txtField.addEventFilter(KeyEvent.KEY_TYPED, (e) -> {
			if (Character.isLowerCase(e.getCharacter().charAt(0)) || !Character.isLetter(e.getCharacter().charAt(0))) {
				// Si descomenta esta línea entonces sí que se valida porque es el último evento
				// que se genera
				e.consume();
			}
		});

		txtField.addEventFilter(KeyEvent.KEY_PRESSED, (e) -> {
			System.out.println("Code: " + e.getCode().getChar() + "-> " + e.getCode().getCode());
			// 10 se corresponde a ENTER y 27 a ESC
			if (e.getCode().getCode() == 10 || e.getCode().getCode() == 27) {
				// En principio la validación con KEY_PRESSED con funciona porque se lanza
				// igualmente KEY_TYPED
				e.consume();
			}
		});

		textDialog.setOnCloseRequest(t -> {

			labelText.requestFocus();
		});

		textDialog.showAndWait().ifPresent(response -> {
			labelText.setText(response);
		});

		labelText.addEventHandler(MouseEvent.MOUSE_MOVED, e -> {
			 String type = e.getEventType().getName();
			 String source = e.getSource().getClass().getSimpleName();
			 String target = e.getTarget().getClass().getSimpleName();
			 System.out.println("Manejador específico de: " + type + ", " + source +
			", " + target);
			});
		
		

//		labelText.addEventFilter(MouseEvent.MOUSE_MOVED, (mouseEvent) -> {
//			System.out.println("estoy solbre el text field");
//		});

	}

	@FXML
	void initialize() {

	}

}
