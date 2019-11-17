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
	private Location continent;
	private String country;
	private String name;
	
	/**
	 * 
	 * @param name
	 * @param location
	 */
	public City(int id, Location continent,String country,String name) {
		this.id = id;
		this.continent = continent;
		this.country = country;
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return
	 */
	public Location getContinent() {
		return continent;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
}