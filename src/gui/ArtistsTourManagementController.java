package gui;

import javafx.fxml.FXML;

import java.io.IOException;
import java.time.LocalDate;

import datastructures.AdjacencyListGraph;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;
import datastructures.*;

/**
 * This class manage the necessary attributes and methods to control the elements used inside the graphical user interface.
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
*/
public class ArtistsTourManagementController {

    @FXML
    private ComboBox<Location> continent;

    @FXML
    private TextField artistname;

    @FXML
    private TextField artistlabel;

    @FXML
    private TextField tourname;

    @FXML
    private DatePicker initialdate;

    @FXML
    private DatePicker finaldate;

    @FXML
    private Label tour;

    @FXML
    private Label artist;

    @FXML
    private Label label;
    
    @FXML
    private Button tourbutton;
    
    @FXML
    private void initialize() {
    	continent.setItems(FXCollections.observableArrayList(Location.AFRICA,Location.AMERICA,Location.ASIA,Location.OCEANIA,Location.EUROPE));
    }
    
    @FXML
    private void generateTour(ActionEvent event){
    	
    	Alert error = new Alert(AlertType.ERROR,"Invalid information, check again",ButtonType.CLOSE);
    	Alert warning = new Alert(AlertType.WARNING,"Missing information or files, check again",ButtonType.CLOSE);
    	
    	try {
    		String name = artistname.getText();
    		String labelname = artistlabel.getText();
    		String profile = artistlabel.getText();
    		String tourName = tourname.getText();
    		
	    	if(name.isEmpty() || labelname.isEmpty() || profile.isEmpty() || tourName.isEmpty()) {
	    		warning.show();
	    		Stage stage = (Stage) warning.getDialogPane().getScene().getWindow();
	    		stage.getIcons().add(new Image("gui/imgs/icon.png"));
	    		DialogPane dialogpane = warning.getDialogPane();
	    		dialogpane.getStylesheets().add("gui/css/theme.css");
	    	}
	    	else 
	    	{
	    		String initdate = initialdate.getValue().toString();
	    		String finishdate = finaldate.getValue().toString(); 
	    		
	    		this.tour.setText(this.tour.getText() + " " + tourName);
	    		this.label.setText(this.label.getText() + " " + labelname);
	    		this.artist.setText(this.artist.getText() + " " + name);
	    		tourbutton.setDisable(true);
	    		
	    		Artist artist = new Artist(name, labelname);
	    		Tour tour = new Tour(continent.getValue(),tourName,initdate,finishdate,getPath());
	    	}
    	}
    	catch(NullPointerException npe) {
    		Stage stage = (Stage) error.getDialogPane().getScene().getWindow();
    		stage.getIcons().add(new Image("gui/imgs/icon.png"));
    		DialogPane dialogpane = error.getDialogPane();
    		dialogpane.getStylesheets().add("gui/css/theme.css");
    		error.show();
    	}
    	catch(IOException ioe) {
    		warning.show();
    		Stage stage = (Stage) warning.getDialogPane().getScene().getWindow();
    		stage.getIcons().add(new Image("gui/imgs/icon.png"));
    		DialogPane dialogpane = warning.getDialogPane();
    		dialogpane.getStylesheets().add("gui/css/theme.css");
    	}
    }
    
    @FXML
    /**
     * This method sets the current path from where the cities are going to be loaded
     * @return a path to load the selected cities for this tour
     */
    private String getPath() {
    	String path;
    	if(continent.getValue().equals(Location.AFRICA)){
    		path = Tour.AFRICA_PATH;
    	}
    	else if(continent.getValue().equals(Location.AMERICA)) {
    		path = Tour.AMERICA_PATH;
    	}
    	else if(continent.getValue().equals(Location.ASIA)) {
    		path = Tour.ASIA_PATH;
    	}
    	else if(continent.getValue().equals(Location.EUROPE)) {
    		path = Tour.EUROPE_PATH;
    	}
    	else {
    		path = Tour.OCEANIA_PATH;
    	}
    	return path;
    }
}