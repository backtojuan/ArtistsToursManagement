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

	private Location continent;
	private String country;
	private String name;
	
	/**
	 * <b>City Constructor</b> 
	 * @param continent the continent where this city is located
	 * @param country the current contry which this city belongs to
	 * @param name the name of the city
	 */
	public City(Location continent,String country,String name) {
		this.continent = continent;
		this.country = country;
		this.name = name;
	}

	/**
	 * This method returns the location of this city
	 * <b>Pre:</b> The city exists
	 * @return the location of this city
	 */
	public Location getContinent() {
		return continent;
	}
	
	/**
	 * This method returns the country of this city
	 * <b>Pre:</b> The city exists
	 * @return the country of this city
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * This method returns the name of this city
	 * <b>Pre:</b> The city exists
	 * @return the name of this city
	 */
	public String getName() {
		return name;
	}
}