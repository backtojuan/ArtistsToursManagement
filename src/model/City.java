package model;

/**
 * This class manage the necessary attributes and methods to create cities that the tour might cover
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class City {

	private String name;
	private Location continent;
	private String country;
	
	public City(String name, Location location) {
		this.name = name;
		this.continent = location;
	}

	public String getName() {
		return name;
	}

	public Location getLocation() {
		return continent;
	}
}
