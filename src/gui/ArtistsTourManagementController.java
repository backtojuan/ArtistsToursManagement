package gui;

import javafx.fxml.FXML;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import datastructures.AdjacencyListGraph;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.City;
import model.Location;

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
    public void initialize() {
    	continent.setItems(FXCollections.observableArrayList(Location.AFRICA,Location.AMERICA,Location.ASIA,Location.AUSTRALIA,Location.EUROPE));
    }
    
    @FXML
    void generateTour(ActionEvent event) throws IOException {
    	AdjacencyListGraph<City> citiesgraph = new AdjacencyListGraph<>(20);
		
		BufferedReader br = new BufferedReader(new FileReader(new File("data/europe.txt")));
		
		String line = br.readLine();
		
		while(br.readLine()!=null) {
			
			String[] parts = line.split(",");
			
			int id = Integer.parseInt(parts[0]);
			String country = parts[1];
			String name = parts[2];
			
			City city = new City(id, Location.EUROPE, country, name);
			
			citiesgraph.addVertex(city);
			line = br.readLine();
		}
		
		citiesgraph.addEdge(1, 5, 500);
		citiesgraph.addEdge(8, 12, 400);
		
		citiesgraph.printGraph();
		
		br.close(); 
    }
}
