package gui;

import model.City;
import model.Location;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import datastructures.AdjacencyListGraph;
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
		stage.setResizable(false);
		stage.setScene(scene);

		Image icon = new Image("gui/imgs/icon.png");
		stage.getIcons().add(icon);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}