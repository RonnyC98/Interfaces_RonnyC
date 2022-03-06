package application;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ListController {
	public static ObservableList<String> names = FXCollections.observableArrayList();

	@FXML
	private ChoiceBox<String> choice1;

	@FXML
	private ListView<String> list1;

	@FXML
	private ComboBox<String> combo1;
	
	@FXML
    private TreeView<String> tree1;
	
	private final Node rootIcon = new ImageView(new Image(getClass().getResourceAsStream("resources/icon/carpeta.png")));
	

	@FXML
	private void initialize() {

		// Controles de JavaFX a los que se añaden directamente los items
		choice1.setValue("Select a value...");
		choice1.getItems().addAll("New York", "Orlando", "London", "Manchester");
		ObservableList list = choice1.getItems();
		list.add(2, new Separator());

		// Controles de JavaFX a los que se añaden directamente los items
		list1.getItems().addAll("Indeterminate (pick a choice)", "Indeterminate (pick a choice)",
				"Indeterminate (pick a choice)", "Indeterminate (pick a choice)", "Indeterminate (pick a choice)",
				"Indeterminate (pick a choice)", "Indeterminate (pick a choice)", "Indeterminate (pick a choice)",
				"Indeterminate (pick a choice)", "Indeterminate (pick a choice)");

		names.addAll("Objects", "Classes", "Functions", "Variables", "Compiler", "Debugger", "Projects", "Beans",
				"Libraries", "Modules");
		list1.setEditable(true);
		list1.setCellFactory(ComboBoxListCell.forListView(names));

		combo1.setValue("Select a language");
		combo1.getItems().addAll("English", "Japanese", "Spanish");
		
		
		
		
        TreeItem<String> webItem = new TreeItem<>("Inbox", rootIcon);
        webItem.getChildren().add(new TreeItem<String>("Sales"));
        webItem.getChildren().add(new TreeItem<String>("Marketing"));
        webItem.getChildren().add(new TreeItem<String>("Distribution"));
        webItem.getChildren().add(new TreeItem<String>("Costs"));
        
        
     // Para que sea editable necesitamos especificar un CellFactory con el tipo que corresponda
        tree1.setCellFactory(TextFieldTreeCell.forTreeView());
        
        // Expadimos por defecto el ítem raíz
       webItem.setExpanded(true); 
        tree1.setRoot(webItem);  
		
		

	}
}
