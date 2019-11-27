package gui;

import javafx.fxml.FXML;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private ImageView image1;

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
    private Label tour1;

    @FXML
    private Label artist1;

    @FXML
    private Label min;
    
    @FXML
    private Button tourbutton;
    @FXML
    private Label label;
    private Tour tour;
    private Artist artist;
    
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
	    		
	    		this.tour1.setText(this.tour1.getText() + " " + tourName);
	    		this.label.setText(this.label.getText() + " " + labelname);
	    		this.artist1.setText(this.artist1.getText() + " " + name);
	    		tourbutton.setDisable(true);
	    		
	    		artist = new Artist(name, labelname);
	    		tour = new Tour(continent.getValue(),tourName,initdate,finishdate,getPath(),getPathVertex());
	    	    if(continent.getValue().toString() == "AFRICA") {
	    	    	image1.setImage(new Image("gui/imgs/africa_distances (2).png"));
	    	    }else if(continent.getValue().toString() == "AMERICA") {
	    	    	image1.setImage(new Image("gui/imgs/america_distances (2).png"));
	    	    }else if(continent.getValue().toString() == "ASIA") {
	    	    	image1.setImage(new Image("gui/imgs/asia_distances (2).png"));
	    	    }else if(continent.getValue().toString() == "OCEANIA") {
	    	    	image1.setImage(new Image("gui/imgs/australia_distances (2).png"));
	    	    }else if(continent.getValue().toString() == "EUROPE") {
	    	    	image1.setImage(new Image("gui/imgs/europe_distances (2).png"));
	    	    }
	    	    /*
	    	    //Kruskal
	    	    ArrayList<Edge<City>> kruskalCost = tour.getCost().kruskal();
	    	    ArrayList<Edge<City>> kruskalMap = tour.getMap().kruskal();
	    	    //FW
	    	    double[][] fwCost  = tour.getCost().floydWarshall();
	    	    double[][] fwMap  = tour.getCost().floydWarshall();
	    	    **/
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
    void costMap(ActionEvent event) {
    	if(continent.getValue().toString() == "AFRICA") {
	    	image1.setImage(new Image("gui/imgs/africa_cost (2).png"));
	    }else if(continent.getValue().toString() == "AMERICA") {
	    	image1.setImage(new Image("gui/imgs/america_cost (2).png"));
	    }else if(continent.getValue().toString() == "ASIA") {
	    	image1.setImage(new Image("gui/imgs/asia_costs (2).png"));
	    }else if(continent.getValue().toString() == "OCEANIA") {
	    	image1.setImage(new Image("gui/imgs/australia_cost (2).png"));
	    }else if(continent.getValue().toString() == "EUROPE") {
	    	image1.setImage(new Image("gui/imgs/europe_costos (2).png"));
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
    		path = Tour.AUSTRALIA_VERTEX;
    	}
    	return path;
    }
    
    private String getPathVertex() {
    	String path;
    	if(continent.getValue().equals(Location.AFRICA)){
    		path = Tour.AFRICA_VERTEX;
    	}
    	else if(continent.getValue().equals(Location.AMERICA)) {
    		path = Tour.AMERICA_VERTEX;
    	}
    	else if(continent.getValue().equals(Location.ASIA)) {
    		path = Tour.ASIA_VERTEX;
    	}
    	else if(continent.getValue().equals(Location.EUROPE)) {
    		path = Tour.EUROPE_VERTEX;
    	}
    	else {
    		path = Tour.AUSTRALIA_VERTEX;
    	}
    	return path;
    }
    
    @FXML
    /**
     * 
     * @param event
     */
    public void costMin(ActionEvent event) {
    	ArrayList<Edge<City>> kruskalCost = tour.getCost().kruskal();
    	String mensaje = "";
    	for(int i = 0; i < kruskalCost.size(); i++) {
    		mensaje+= kruskalCost.get(i).toString();
    		mensaje += "\n";
    	}
    	min.setText(mensaje);
    }

    @FXML
    /**
     * 
     * @param event
     */
    public void distanceMin(ActionEvent event) {
    	ArrayList<Edge<City>> kruskalMap = tour.getMap().kruskal();
    	String mensaje = "";
    	for(int i = 0; i < kruskalMap.size(); i++) {
    		mensaje+= kruskalMap.get(i).toString();
    		mensaje += "\n";
    	}
    	min.setText(mensaje);
    }
    
    @FXML
    /**
     * 
     * @param event
     */
    public void floyd(ActionEvent event) {

    }
    
}