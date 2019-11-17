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

	//atributte necesary to modeled the vertex inside the graph
	private int id;
	
	//self attributes
	private String name;
	private Location continent;
	private String country;
	
	/**
	 * 
	 * @param name
	 * @param location
	 */
	public City(String name, Location location) {
		this.name = name;
		this.continent = location;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return
	 */
	public Location getLocation() {
		return continent;
	}
}