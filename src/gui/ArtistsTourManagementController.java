package gui;

import javafx.fxml.FXML;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import datastructures.AdjacencyListGraph;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private TextField artistprofile;
    
    @FXML
    private ImageView currentartist;
    
    @FXML
    private ImageView label;
    
    @FXML
    private void initialize() {
    	continent.setItems(FXCollections.observableArrayList(Location.AFRICA,Location.AMERICA,Location.ASIA,Location.OCEANIA,Location.EUROPE));
    	currentartist.setFitHeight(250);
    	currentartist.setFitWidth(250);
    	label.setFitHeight(250);
    	label.setFitWidth(250);
    }
    
    @FXML
    private void generateTour(ActionEvent event){
    	
    	Alert error = new Alert(AlertType.ERROR,"Invalid information, check again",ButtonType.CLOSE);
    	Alert warning = new Alert(AlertType.WARNING,"Missing information, check again",ButtonType.CLOSE);
    	
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
	    		
	    		Artist artist = new Artist(name, labelname);
	    		Tour tour = new Tour(tourName,initdate,finishdate);
	    		
	    		currentartist.setImage(new Image(profile));
	    		label.setImage(new Image(labelname));
	    	}
    	}
    	catch(NullPointerException npe) {
    		Stage stage = (Stage) error.getDialogPane().getScene().getWindow();
    		stage.getIcons().add(new Image("gui/imgs/icon.png"));
    		DialogPane dialogpane = error.getDialogPane();
    		dialogpane.getStylesheets().add("gui/css/theme.css");
    		error.show();
    	}
    }
}
