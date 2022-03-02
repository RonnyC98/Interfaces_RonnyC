module PrimeraAplicacion {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens ch.makery.adress to javafx.graphics, javafx.fxml, javafx.controls;
}
