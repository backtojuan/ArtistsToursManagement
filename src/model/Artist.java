package model;

public class Artist {

	private String name;
	private String label;
	
	public Artist(String name, String label) {
		this.name = name;
		this.label = label;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLabel() {
		return label;
	}
}
