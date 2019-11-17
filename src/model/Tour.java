package model;

import java.time.LocalDate;

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
