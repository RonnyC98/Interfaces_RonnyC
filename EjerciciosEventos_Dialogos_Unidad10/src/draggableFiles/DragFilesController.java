package draggableFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;

public class DragFilesController {
	
	@FXML
    private Text source;
	
	@FXML
    private Text target;
	
	@FXML
	private ImageView imageView;
	
    @FXML
    private void initialize() {   
    	
    }

    @FXML
    private void handleDialogOver(DragEvent event) {
    	if (event.getDragboard().hasFiles()) {
    		event.acceptTransferModes(TransferMode.MOVE);
    	}
    }
    
    @FXML
    private void handleDrop(DragEvent event) throws FileNotFoundException {
    	List<File> files = event.getDragboard().getFiles();
    	Image img = new Image(new FileInputStream(files.get(0)));
    	imageView.setImage(img);
    }
    
    @FXML
    private void handleDragDetection(MouseEvent event) {
    	 Dragboard db = source.startDragAndDrop(TransferMode.ANY);
    	 
    	 ClipboardContent content = new ClipboardContent();
         content.putString(source.getText());
         
         db.setContent(content);
    }
    
    @FXML
    private void handleTextDragOver(DragEvent event) {
    	if (event.getDragboard().hasString()) {
    		event.acceptTransferModes(TransferMode.ANY);
    	}

    }
    
    @FXML
    private void handleTextDropped(DragEvent event) {
    	if (event.getDragboard().hasString()) {
    		String str = event.getDragboard().getString();
        	target.setText(str);
        	event.setDropCompleted(true);
    	}    	
    }
    
    @FXML
    private void handleDragDone(DragEvent event) {
    	if (event.getTransferMode() != null) {
    		source.setText("Operación drag terminada");
    	}
    }
   
}
