package model;

/**
 * This class manage the necessary attributes and methods to create artists who performs on tours 
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class Artist {

	private String name;
	private String label;

	/**
	 * <b>Artist Constructor</b>
	 * @param name the name of this artists
	 * @param label the current label that represents this artist
	 */
	public Artist(String name, String label) {
		this.name = name;
		this.label = label;
	}

	/**
	 * This method returns the name of the current artist rehearsing a tour
	 * <b>Pre:</b> the artist exists
	 * @return the name of the artist
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method returns the label representing this artist
	 * <b>Pre:</b> the artist exists
	 * @return the label of the artist
	 */
	public String getLabel() {
		return label;
	}
}
