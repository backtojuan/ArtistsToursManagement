package datastructures;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 * This class manage the necessary attributes and methods to create the graph representation using an AdjacencyList
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class AdjacencyListGraph<Value> implements GraphInterface<Value> {

	private int totalvertices;
	
	private ArrayList<Vertex<Value>> vertices;
	private LinkedList<Edge<Value>> [] adjacencylist;
	
	@SuppressWarnings("unchecked")
	/**
	 * <b>Graph Constructor</b>
	 * @param totalvertices the totalvertices to be added in the current graph
	 */
	public AdjacencyListGraph(int totalvertices) {
		totalvertices = 0;
		vertices = new ArrayList<>();
		adjacencylist = new LinkedList[totalvertices];
		for (int i = 0; i < adjacencylist.length; i++) {
			adjacencylist[i] = new LinkedList<>();
		}
	}
	
	/**
	 * This method returns the total number of vertices that have been added to the moment in the graph
	 * <b>Pre:</b> the graph exists
	 * @return the total vertices for this graph
	 */
	public int getTotalVertices() {
		return totalvertices;
	}
	
	/**
 	* This method returns the all vertices that has been added to the graph
 	* <b>Pre:</b> the graph exists 
 	* @return a List with all the vertices
 	*/
	public ArrayList<Vertex<Value>> getVertices() {
		return vertices;
	}
	
	@Override
	/**
	 * This method adds a vertex to the graph
	 * <b>Pre:</b> the vertex is not null
	 * <b>Pre:</b> the graph exists
	 * <b>Post:</b> the vertex gets added to the graph
	 * @param u the vertex that is going to be added into the graph
	 */
	public void addVertex(Vertex<Value> vertex) {
		vertices.add(vertex);
	}
	
	@Override
	/**
	 * This method removes a vertex from this graph
	 * <b>Pos:</b> the vertex was removed from this graph
	 * @param vertex the vertex that needs to be remove from this graph
	 */
	public void removeVertex(Vertex<Value> vertex) {
		if(!exists(vertex)) {
			vertices.remove(vertex.getKey());
			adjacencylist[vertex.getKey()] = null;
		}
	}
	
	@Override
	/**
	 * This method adds an edge in the graph connecting two vertices
	 * <b>Pre:</b> the vertices that are going to be connected by this edge already exists
	 * <b>Pos:</b> the edge connect two vertices in the graph
	 * @param u the vertex u
	 * @param v the vertex v
	 * @param weight the current cost that takes to go from u to v and viceverse
	 */
	public void addEdge(Vertex<Value> u, Vertex<Value> v, double weight) {
		Edge<Value> edge = new Edge<>(u, v, weight);
		adjacencylist[u.getKey()].add(edge);
		adjacencylist[v.getKey()].add(edge);
	}
		
	@Override
	/**
	 * This method returns the adjacent vertices for a given vertex
	 * @param vertex the vertex which adjacency is going to be verified
	 * @return a list with all adjacent vertices to the given vertex
	 */
	public List<Vertex<Value>> vertexAdjacent(Vertex<Value> vertex){
		ArrayList<Vertex<Value>> adjacentvertices = new ArrayList<>();
		for (int i = 0; i < adjacencylist[vertex.getKey()].size(); i++) {
			
		}
		return adjacentvertices;
	}
	
	@Override
	/**
	 * This method checks is the given vertex already exists in the graph
	 * @param vertex the vertex to be verified
	 * @return a boolean value indicating if eaither the vertex exists or no
	 */
	public boolean exists(Vertex<Value> vertex) {
		boolean exists = false;
		for (int i = 0; i < vertices.size() && !exists; i++) {
			if(vertices.get(i).equals(vertex)) {
				exists = true;
			}
		}
		return exists;
	}
} 