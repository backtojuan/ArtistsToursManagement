package model;

import java.time.LocalDate;
import java.util.PriorityQueue;

import datastructures.AdjacencyListGraph;

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
	private AdjacencyListGraph<City> graph;
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
	
	public void primAlgorithm(City r) {
		for(int i = 0; i<graph.getVertices().size(); i++) {
			graph.getVertices().get(i).setKey((int)Long.MAX_VALUE);
			graph.getVertices().get(i).setColor("W");
		}
		r.setKey(0);
		r.setPred(null);
		PriorityQueue Q = new PriorityQueue();
		Q.offer(graph.getVertices());
		City u;
		while(Q.isEmpty() == false) {
			u = (City) Q.poll();
			for(int i = 0; i < graph.getVertices().size(); i++) {
				
			}
		}
	}
}
