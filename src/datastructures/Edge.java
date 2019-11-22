package datastructures;

/**
 * This class manage the necessary attributes and methods to create directed weighted edges for the graph representation 
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class Edge<Value>{
	
	private Vertex<Value> u;
	private Vertex<Value> v;
	private double weight;
	
	/**
	 * This method creates a non-directed edge between two vertices
	 * @param u the vertex u
	 * @param v the vertex v
	 * @param weight the cost that it takes to go from u to v, and viceverse
	 */
	public Edge(Vertex<Value> u, Vertex<Value> v,double weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
	
	/**
	 * This method returns the vertex u
	 * <b>Pre:</b> the edge exists
	 * @return the vertex u
	 */
	public Vertex<Value> getU() {
		return u;
	}
	
	/**
	 * This method returns the vertex v
	 * <b>Pre:</b> the edge exists
	 * @return the vertex v
	 */
	public Vertex<Value> getV() {
		return v;
	}
	
	/**
	 * This method returns the cost for this edge
	 * <b>Pre:</b> the edge exists
	 * @return cost
	 */
	public double getWeight() {
		return weight;
	}
}