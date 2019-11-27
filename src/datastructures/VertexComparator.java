package datastructures;

import java.util.Comparator;

/**
 * This class manage the necessary attributes and methods to test the datastructures class AdjacencyListGraph
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class VertexComparator<Value> implements Comparator<Vertex<Value>>{

	public VertexComparator() {
		
	}
	
	@Override
	/**
	 * This method compares two vertices with distance criteria
	 * <b>Pre:</b> The vertices to be compare both exists and have been already inserted in the graph
	 * <b>Pos:</b> The vertices are compared with the criteria in the right form
	 * @returns an Integer number which indicates the relation of order between this vertices
	 */
	public int compare(Vertex<Value> vertex1, Vertex<Value> vertex2) {
		if(vertex1.getCost()>vertex2.getCost()) {
			return 1;
		}
		else if(vertex1.getCost()<vertex2.getCost()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
