package datastructures;

import java.util.List;

/**
 * This interface has the minimum and general features that a graph should implement no matter which would be its representation.
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November2019
 * @param <Value> Abstract data type which represents an object from a natural problem 
 * that is going to be modeled as a vertex in a graph representation of the problem
 */
public interface GraphInterface<Value> {

	/**
	 * Adds a vertex to the graph
	 * @param v The new vertex to be added
	 * @return True if was added and false if it was already in the graph
	 */
	public void addVertex(Vertex<Value> v);
	
	/**
	 * Adds a weighted edge to the graph
	 * If the graph is directed the connection will be from U to V
	 * <pre> U and V have to exist in the graph
	 * @param u a vertex within the graph
	 * @param v a vertex within the graph
	 * @param w	is the weight of the edge
	 */
	public void addEdge(Vertex<Value> u, Vertex<Value> v, double weight);

	/**
	 * Removes a vertex within the graph
	 * @param v A vertex to be removed of the graph
	 * @return True if the vertex was removed or false if the vertex didn't exist
	 */
	public void removeVertex(Vertex<Value> v);

	/**
	 * Gives a list of adjacent vertices of V
	 * <pre> V Is within the graph
	 * @param v The vertex to be consulted its adjacent vertices
	 * @return A list with all the adjacent vertices of V
	 */
	public List<Vertex<Value>> vertexAdjacent(Vertex<Value> v);
	
	/**
	 * Determines if the given vertex has been already added to the graph
	 * @param v the vertex to be verified
	 * @return a boolean value that indicates if this vertex either exists or no
	 */
	public boolean exists(Vertex<Value> v);
}
