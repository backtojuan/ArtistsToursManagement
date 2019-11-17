package gui;

import model.City;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This class manage the necessary attributes and methods to launch the graphical interface to the user
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class Main extends Application{

	@Override
	public void start(Stage stage) throws Exception{
		Parent root =
				FXMLLoader.load(getClass().getResource("artiststourmanagement.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("¡Artists Tour Management!");
		stage.setFullScreen(true);
		stage.setScene(scene);

		Image icon = new Image("gui/imgs/icon.png");
		stage.getIcons().add(icon);
		stage.show();
	}

	/**public static void main(String[] args) {
		launch(args);
	}*/
	
	public static void main(String[] args) {
		
		
	
	}	
}