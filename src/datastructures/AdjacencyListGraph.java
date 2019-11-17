package datastructures;

import java.util.LinkedList;

/**
 * This class manage the necessary attributes and methods to create the graph representation
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class AdjacencyListGraph {

	int vertices;
	LinkedList<Edge> [] adjacencylist;

	@SuppressWarnings("unchecked")
	AdjacencyListGraph(int vertices) {
		this.vertices = vertices;
		adjacencylist = new LinkedList[vertices];
		//initialize adjacency lists for all the vertices
		for (int i = 0; i <vertices ; i++) {
			adjacencylist[i] = new LinkedList<>();
		}
	}

	public void addEgde(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adjacencylist[source].addFirst(edge); //for directed graph
	}

	public void printGraph(){
		for (int i = 0; i <vertices ; i++) {
			LinkedList<Edge> list = adjacencylist[i];
			for (int j = 0; j <list.size() ; j++) {
				System.out.println("vertex-" + i + " is connected to " +
						list.get(j).destination + " with weight " +  list.get(j).weight);
			}
		}
	}       
}
