package pagination;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class PaginationController {
	
    @FXML
    private Pagination pagination;
        
    @FXML
    private ProgressBar progressBar;
	
    private ArrayList<String> nombres = new ArrayList<String>();
    private static final int ITEMSPERPAGE = 5;
   
    @FXML
    private void initialize() {   
    	this.initNombres(this.nombres);

    	pagination.setPageCount((nombres.size() / ITEMSPERPAGE) + 
    			(((nombres.size() % ITEMSPERPAGE) > 0)?1:0));
    	    	    	
    	pagination.setPageFactory((Integer pageIndex) -> {
    		return createPage(pageIndex);   
        });
    	
    	pagination.currentPageIndexProperty().addListener(
    		(observable, oldValue, newValue) -> {
    			progressBar.setProgress((newValue.doubleValue() + 1) / 
    					pagination.getPageCount());    			
    		});
    	    	 	
    	progressBar.setProgress((double) 1 / pagination.getPageCount()); 
    }
    
    private VBox createPage(int pageIndex) {        
        VBox box = new VBox();
        int page = pageIndex * ITEMSPERPAGE;
        
        int limit = Math.min(page + ITEMSPERPAGE, nombres.size());
        for (int i = page; i < limit; i++) {
            Label text = new Label( (i+1) + ".- " + nombres.get(i));
            box.getChildren().add(text);           
        }
        
        return box;
    }
    
    private void initNombres(ArrayList<String> nombres) {
    	 nombres.add("Juan");
    	 nombres.add("Carmen");
    	 nombres.add("Maria");
    	 nombres.add("Camila");
    	 nombres.add("Pablo");
    	 nombres.add("Cornelio");
    	 nombres.add("Anibal");
    	 nombres.add("Ruben");
    	 nombres.add("Julio");
    	 nombres.add("Manfred");
    	 nombres.add("Ana");
    	 nombres.add("Luis");
    	 nombres.add("Luz");
    	 nombres.add("Lucas");
    	 nombres.add("Gretta");
    	 nombres.add("Lauren");
    	 nombres.add("Oscar");
    	 nombres.add("James");
    }
       
}
