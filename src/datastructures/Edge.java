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
	
	private int u;
	private int v;
	private double weight;
	
	/**
	 * 
	 * @param u
	 * @param v
	 * @param weight
	 */
	public Edge(int u, int v,double weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getU() {
		return u;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getV() {
		return v;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getWeight() {
		return weight;
	}
}