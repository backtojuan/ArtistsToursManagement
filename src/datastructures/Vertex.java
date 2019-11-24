package datastructures;

/**
 * This class manage the necessary attributes and methods to vertices for the graph representation 
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class Vertex<Value>{
	
	//Attributes for BFS
	private int distance;
	
	//Attributtes for DFS
	private int initialtime;
	private int finishtime;
	
	private int key;
	private Value value;
	
	//atributte necesary to modeled the vertex inside the graph
	private String color;
	
	public final static String WHITE = "W";
	public final static String BLACK = "B";
	public final static String GRAY = "G";
	
	private Vertex<Value> pred;
	
	/**
	 * <b> Vertex Constructor</b>
	 * @param key the key for this vertex (index)
	 * @param value the value for this vertex (type)
	 */
	public Vertex(int key, Value value){
		this.key = key;
		this.value = value;
		this.color = Vertex.WHITE;
		this.pred = null;
	}
	
	/**
	 * This method returns the distance until this vertex
	 * <b>Pre:</b> the graph exists
	 * @return the distance until this vertex
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * This method returns the key(index) for this vertex
	 * <b>Pre:</b> the graph exists
	 * @return the key of this vertex
	 */
	public int getKey() {
		return key;
	}
	
	/**
	 * This method returns the value(type) for this vertex
	 * <b>Pre:</b> the graph exists
	 * @return the value of this vertex
	 */
	public Value getValue() {
		return value;
	}

	/**
	 * This method returns the color for this vertex, in order to use some classical algorithms
	 * (Prim,BFS)
	 * WHITE : has not been discovered
	 * GRAY : has been discovered but its adjacent vertices are not complete
	 * BLACK : all of its vertices has been discovered and its not necessary to explore again
	 * <b>Pre:</b> the graph exists
	 * @return the color of this graph
	 */
	public String getColor() {
		return color;
	}

	/**
	 * This method returns the predecessor vertex from which exists a path to this vertex
	 * (Prim,Dijkstra)
	 * this is used in order to use some classical algorithms
	 * <b>Pre:</b> the graph exists
	 * @return the predecessor vertex from this vertex
	 */
	public Vertex<Value> getPred() {
		return pred;
	}
	
	/**
	 * This method returns the time(costs) that it took to discover this vertex from a source one
	 * <b>Pre:</b> the graph exists
	 * @return the initial discoverment time for this vertex
	 */
	public int getInitialtime() {
		return initialtime;
	}
	
	/**
	 * This method returns the time(costs) that is took to discover the all adjacent vertices of a source one
	 * <b>Pre:</b> the graph exists
	 * @return the final time for this vertex
	 */
	public int getFinishtime() {
		return finishtime;
	}
	
	/**
	 * This method sets the distance for this vertex when necessary
	 * <b>Pre:</b> the graph exists
	 * <b>Pos:</b> the distance of this vertex has changed
	 * @param distance the new distance for this vertex
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	/**
	 * This method sets the key for this vertex when necessary
	 * <b>Pre:</b> the graph exists
	 * <b>Pos:</b> the key of this vertex has changed
	 * @param key the new key value for this vertex
	 */
	public void setKey(int key) {
		this.key = key;
	}
	
	/**
	 * This method sets the color for this vertex when necessary
	 * <b>Pre:</b> the graph exists
	 * <b>Pos:</b> the color of this vertex has changed
	 * @param color the new color value for this vertex
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * This method sets the predecessor for this vertex when necessary
	 * <b>Pre:</b> the graph exists
	 * <b>Pos:</b> the predecessor of this vertex has changed
	 * @param pred the new predecessor vertex for this vertex
	 */
	public void setPred(Vertex<Value> pred) {
		this.pred = pred;
	}
	
	/**
	 * This method sets the initial discoverment time for this vertex when necessary
	 * <b>Pre:</b> the graph exists
	 * <b>Pos:</b> the time for this vertex has been set
	 * @param initialtime the new initial discoverement time for this vertex.
	 */
	public void setInitialtime(int initialtime) {
		this.initialtime = initialtime;
	}
	
	/**
	 * This method sets the final time for this vertex when necessary
	 * <b>Pre:</b> the graph exists
	 * <b>Pos:</b> the time for this vertex has been set
	 * @param finishtime the new final time for this vertex
	 */
	public void setFinishtime(int finishtime) {
		this.finishtime = finishtime;
	}	
	
	@Override
	/**
	 * This method gives information for this object
	 * @return a String with information
	 */
	public String toString() {
		return value.toString();
	}
}