package model;

import java.time.LocalDate;

/**
 * This class manage the necessary attributes and methods to create planned tours
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class Tour {

	private String name;
	private LocalDate initDate;
	private LocalDate finalDate;

	private Artist artist;

	public Tour(String name, LocalDate initDate, LocalDate finalDate) {
		this.name = name;
		this.initDate = initDate;
		this.finalDate = finalDate;
	}

	public String getName() {
		return name;
	}

	public LocalDate getInitDate() {
		return initDate;
	}

	public LocalDate getFinalDate() {
		return finalDate;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	
}
