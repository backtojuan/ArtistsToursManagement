package datastructures;

import java.util.LinkedList;
import java.util.ArrayList;

/**
 * This class manage the necessary attributes and methods to create the graph representation
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class AdjacencyListGraph<Value> {

	private int totalvertices;
	
	private ArrayList<Value> vertices;
	private LinkedList<Edge> [] adjacencylist;
	
	@SuppressWarnings("unchecked")
	/**
	 * 
	 * @param totalvertices
	 */
	public AdjacencyListGraph(int totalvertices) {
		this.totalvertices = totalvertices;
		adjacencylist = new LinkedList[totalvertices];
		//initialize adjacency lists for all the vertices
		for (int i = 0; i < totalvertices; i++) {
			adjacencylist[i] = new LinkedList<>();
		}
	}
	/**
	 * 
	 * @param u
	 */
	public void addVertex(Value u) {
		vertices.add(u);
	}
	public void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adjacencylist[source].addFirst(edge); //for directed graph
	}
	
	/**
	 * 
	 * @param u
	 * @param v
	 * @param weight
	 */
	public void addEdge(int u,int v, double weight) {
		Edge edge = new Edge(u, v,weight);
		adjacencylist[u].add(edge); 
		adjacencylist[v].add(edge);
	}
	
	/**
	 * 
	 */
	public void printGraph() {
		for(int i=0;i<totalvertices;i++) {
			LinkedList<Edge> list = adjacencylist[i];
			for (int j = 0; j < list.size(); j++) {
				System.out.println("Vertex- " + i + "is connected to " +
						list.get(j).getV() + "With weight" + list.get(j).getWeight());
			}
		}
	}	
} 