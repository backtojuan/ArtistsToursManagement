package datastructures;

/**
 * This class manage the necessary attributes and methods to create directed weighted edges for the graph representation 
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class Edge{
	int source;
	int destination;
	int weight;

	public Edge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
}

