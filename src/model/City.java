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
	private String color;
	public final static String WHITE = "W";
	public final static String BLACK = "B";
	public final static String GRAY = "G";
	//self attributes
	private Location continent;
	private String country;
	private String name;
	private City pred;
	private int key;
	/**
	 * 
	 * @param name
	 * @param location
	 */
	public City(int id, Location continent,String country,String name, String color, City pred, int key) {
		this.id = id;
		this.continent = continent;
		this.country = country;
		this.name = name;
		this.color = color;
		this.pred = pred;
		this.key = key;
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
	public String getColor() {
		return color;
	}
	public void setKey(int k) {
		key = k;
	}
	public void setPred(City p) {
		pred = p;
	}
	public void setColor(String c) {
		color = c;
	}
	public int getKey() {
		return key;
	}
	public City getPred() {
		return pred;
	}
}