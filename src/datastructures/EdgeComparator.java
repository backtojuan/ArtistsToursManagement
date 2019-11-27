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
public class EdgeComparator<Value> implements Comparator<Edge<Value>>{

	public EdgeComparator() {
	}

	@Override
	/**
	 * This method compares two edges with weight criteria
	 * <b>Pre:</b> The edges to be compare both exists and have been already inserted in the graph and connect two vertices
	 * <b>Pos:</b> The edges are compared with the criteria in the right form
	 * @returns an Integer number which indicates the relation of order between this edges
	 */
	public int compare(Edge<Value> edge1, Edge<Value> edge2) {
		if(edge1.getWeight()>edge2.getWeight()) {
			return 1;
		}
		else if(edge1.getWeight()<edge2.getWeight()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
