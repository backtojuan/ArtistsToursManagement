package datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This class manage the necessary attributes and methods to create the graph representation using an AdjacencyMatrix
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class AdjacencyMatrixGraph<Value> implements GraphInterface<Value>{

	private int totalvertices;
	
	private ArrayList<Vertex<Value>> vertices;
	private List<ArrayList<Integer>> adjacencymatrix;
	private List<ArrayList<Double>> weightsmatrix;
	
	/**
	 * <b>Graph Constructor</b>
	 * Constructor method for a non-directed weighted graph using adjacencymatrix
	 * @param totalvertices the totalvertices to be added in the current graph
	 */
	public AdjacencyMatrixGraph(int totalvertices) {
		this.totalvertices = totalvertices;
		vertices = new ArrayList<>();
		adjacencymatrix = new ArrayList<>();
		weightsmatrix = new ArrayList<>();
		for (int i = 0; i < adjacencymatrix.size(); i++) {
			adjacencymatrix.add(i, new ArrayList<>());
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
	
	/**
	 * This method returns the adjacent vertices from each vertex inside this graph
	 *<b>Pre:</b> the graph exists 
	 * @return the adjacencymatrix of this graph
	 */
	public List<ArrayList<Integer>> getAdjacencyMatrix(){
		return adjacencymatrix;
	}
	
	/**
	 * This method returns the weights from each vertex to the rest inside this graph
	 *<b>Pre:</b> the graph exists 
	 * @return the weightsmatrix of this graph
	 */
	public double[][] getWeightsdMatrix(){
		double[][] weights = new double[vertices.size()][vertices.size()];
		for (int i = 0; i < weights.length; i++) {
			for (int j = 0; j < weights.length; j++) {
				weights[i][j] = weightsmatrix.get(i).get(j);
			}
		}
		return weights;
	}

	/**
	 * This method adds a vertex to the graph
	 * <b>Pre:</b> the vertex is not null
	 * <b>Pre:</b> the graph exists
	 * <b>Post:</b> the vertex gets added to the graph
	 * @param u the vertex that is going to be added into the graph
	 */
	@Override
	public void addVertex(Vertex<Value> vertex) {
		vertices.add(vertex);
		ArrayList<Integer> adjacent = new ArrayList<>();
		ArrayList<Double> weight = new ArrayList<>();
		for (int i = 0; i < totalvertices; i++) {
			adjacent.add(0);
			weight.add(Double.MAX_VALUE);
		}
		adjacencymatrix.add(vertex.getKey()-1, adjacent);
		weightsmatrix.add(vertex.getKey()-1, weight);
	}
	
	/**
	 * This method adds an edge in the graph connecting two vertices
	 * <b>Pre:</b> the vertices that are going to be connected by this edge already exists
	 * <b>Pos:</b> the edge connect two vertices in the graph
	 * @param u the vertex u
	 * @param v the vertex v
	 * @param weight the current cost that takes to go from u to v and viceverse
	 */
	@Override
	public void addEdge(Vertex<Value> u, Vertex<Value> v, double weight) {
		Edge<Value> edge = new Edge<>(u,v,weight);
		
		adjacencymatrix.get(u.getKey()-1).add((v.getKey()-1),1);
		adjacencymatrix.get(v.getKey()-1).add((u.getKey()-1),1);
		
		weightsmatrix.get(u.getKey()-1).add(v.getKey()-1,weight);
		weightsmatrix.get(v.getKey()-1).add(u.getKey()-1,weight);
	}
	
	/**
	 * This method returns the adjacent vertices for a given vertex
	 * @param vertex the vertex which adjacency is going to be verified
	 * @return a list with all adjacent vertices to the given vertex
	 */
	@Override
	public List<Vertex<Value>> vertexAdjacent(Vertex<Value> vertex) {
		ArrayList<Vertex<Value>> adjacentvertices = new ArrayList<>();
		int key = vertex.getKey()-1;
		for (int i = 0; i < adjacencymatrix.get(key).size(); i++) {
			int a = adjacencymatrix.get(key).get(i);
			if(a == 1) {
				adjacentvertices.add(vertices.get(i));
			}
		}
		return adjacentvertices;
	}
	
	//PRINCIPAL ALGORITHMS____________________________________________________________________________________________________________
	
	/**
	 * This method searchs for adjacent vertices from a source vertex using Breadth First Search
	 * <b>Pre:</b> The graph exists
	 * <b>Pre:</b> The given source vertex is in the graph
	 * <b>Pos:</b> The distances from a given source vertex to its all adjacent vertices are calculated correctly 
	 * @param source the vertex from where it needs to be calculated the distances to the rest of adjacent vertices
	 * @return an array of distances from a given source vertex to its all adjacent vertices
	 */
	@SuppressWarnings("unchecked")
	public Vertex<Value>[] BFS(Vertex<Value> source) {
		
		Vertex<Value>[] distances = new Vertex[totalvertices];
		int key = source.getKey();
		
		for(Vertex<Value> vertex : vertices) {
			vertex.setColor("W");
			vertex.setDistance(Integer.MAX_VALUE);
			vertex.setPred(null);
		}
		source.setColor(Vertex.GRAY);
		source.setDistance(0);
		source.setPred(null);
		PriorityQueue<Vertex<Value>> queue = new PriorityQueue<Vertex<Value>>();
		queue.offer(source);
		while(queue != null) {
			Vertex<Value> u = queue.poll();
			ArrayList<Vertex<Value>> adjacent = (ArrayList<Vertex<Value>>) vertexAdjacent(u);
			for(int i = 0; i < adjacent.size(); i++) {
				Vertex<Value> v = adjacent.get(i); 
				if(v.getColor().equals(Vertex.WHITE)) {
					v.setColor(Vertex.GRAY);
					v.setDistance(u.getDistance()+1);
					distances[i] = v;
					v.setPred(u);
					queue.offer(v);
				}
				u.setColor(Vertex.BLACK);
			}
		}
		return distances;
	}
	
	/**
	 * This method searchs for adjacent vertices from a source vertex using Depth First Search
	 * <b>Pre:</b> The graph exists
	 * <b>Pos:</b> The distances from the first ordered vertex to its all adjacent vertices are calculated correctly. 
	 */
	public void dfs() {
		for(Vertex<Value> vertex : vertices) {
			vertex.setColor(Vertex.WHITE);
			vertex.setPred(null);
		}
		int time = 0;
		for(Vertex<Value> vertex : vertices) {
			if(vertex.getColor().equals(Vertex.WHITE)) {
				time = dfsVisit(vertex, time);
			}
		}
	}
	
	/**
	 * This method works as an Auxiliar for dfs method using Depth First Search
	 * <b>Pre:</b> The graph exists
	 * @param vertex the vertex that is going to be checked for all of its visits
	 * @return the time that took to discover this vertex
	 */
	public int dfsVisit(Vertex<Value> vertex,int time) {
		time = time+1;
		vertex.setInitialtime(time);
		vertex.setColor(Vertex.GRAY);
		ArrayList<Vertex<Value>> adjacent = (ArrayList<Vertex<Value>>) vertexAdjacent(vertex);
		for(Vertex<Value> adj : adjacent) {
			if(adj.getColor().equals(Vertex.WHITE)) {
				adj.setPred(vertex);
				dfsVisit(adj, time);
			}
			vertex.setColor(Vertex.BLACK);
			time = time+1;
			vertex.setFinishtime(time);
		}
		return time;
	}
	
	/**
	 * This method generates a Minimum Spanning Tree (MST) using Prim's Algorithm
	 * <b>Pre:</b> The graph exists
	 * <b>Pre:</b> The given source vertex is in the graph
	 * <b>Pos:</b> The distances from a given source vertex to its all adjacent vertices are calculated correctly 
	 * @param 
	 * @return an array of vertices with the minimum cost to cover all vertices in this graph
	 */
	@SuppressWarnings("unchecked")
	public double[] prim(Vertex<Value> source) {
		
		double[] keys = new double[totalvertices];
		Vertex<Value>[] color = new Vertex[totalvertices];
		Vertex<Value>[] pred = new Vertex[totalvertices];
		
		int key = source.getKey();
		
		for(int i = 0; i<totalvertices; i++) {
			keys[i] = Integer.MAX_VALUE;
			color[i].setColor(Vertex.WHITE);
			pred[i].setPred(null);
		}
		keys[0] = 0;
		PriorityQueue<Vertex<Value>> queue = new PriorityQueue<Vertex<Value>>();
		for(Vertex<Value> vertex : vertices) {
			queue.add(vertex);
		}
		while(!queue.isEmpty()) {
			Vertex<Value> u = queue.poll();
			ArrayList<Vertex<Value>> adjacent = (ArrayList<Vertex<Value>>) vertexAdjacent(u);
			for (Vertex<Value> v : adjacent ) {
				double weight = weightsmatrix.get(u.getKey()-1).get(v.getKey()-1);
				if(v.getColor().equals(Vertex.WHITE) && weight < keys[v.getKey()-1]) {
					queue.remove(v);
					keys[v.getKey()-1] = weight;
					queue.add(v);
					v.setPred(u);
				}
				u.setColor(Vertex.BLACK);
			}
		}
		return keys;
	}
	
	/**
	 * This method generates a Minimum Spanning Tree (MST) using Kruskal Algorithm
	 * <b>Pre:</b> The graph exists
	 * <b>Pre:</b> The given source vertex is in the graph
	 * <b>Pos:</b> The distances from a given source vertex to the rest (including all vertices) are minimum
	 * @param 
	 * @return an array of vertices with the minimum cost to cover all vertices in this graph
	 */
	public void kruskal() {
		
	}
	
	/**
	 * This method calculates the shortest path from a source vertex to the rest of them using Dijsktra Algorithm
	 * <b>Pre:</b> the graph exists.
	 * <b>Pre:</b> the source vertex is not null.
	 * <b>Pos:</b> the shortest path from a source vertex to the rest of vertices is minimum
	 * @param source the source vertex or origin of the minimun path
	 * @return an array with all the vertices ordered 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void dijkstra(Vertex<Value> source){ 
		
		double[] keys = new double[totalvertices];
		Vertex<Value>[] pred = new Vertex[totalvertices];
		PriorityQueue<Vertex<Value>> queue = new PriorityQueue<>();
		
		for (int i = 0; i < totalvertices; i++) {
			Vertex<Value> vertex = vertices.get(i);
			if(!vertex.equals(source)) {
				keys[vertex.getKey()-1] = Double.MAX_VALUE;
				pred[vertex.getKey()-1].setPred(null);
				queue.offer(vertex);
			}
		}
		
		while(!queue.isEmpty()) {
			Vertex<Value> u = queue.poll();
			ArrayList<Vertex<Value>> adjacent = (ArrayList<Vertex<Value>>) vertexAdjacent(u);
			for (int i = 0; i < adjacent.size(); i++) {
				Vertex<Value> v = adjacent.get(i);
				double alt = keys[u.getKey()-1] + weightsmatrix.get(u.getKey()-1).get(v.getKey()-1);
				if(alt<keys[v.getKey()-1]) {
					queue.remove(v);
					keys[v.getKey()-1] = alt;
					pred[v.getKey()-1] = u;
					queue.add(v);
				}
			}
		}
	}

	/**
	 * This method calculates the shortest path between every pair of vertices using Floyd Warshall Algorithm
	 * <b>Pre:</b> the graph exists.
	 * <b>Pre:</b> the source vertex is not null.
	 * <b>Pos:</b> the shortest path between every pair of vertices is minimum
	 * @param source the source vertex or origin of the minimun path
	 * @return an array with all the vertices ordered 
	 * 
	 */
	public void floydWarshall(Vertex<Value> source) { 
		double[][] weights = getWeightsdMatrix();
		for (int k = 0; k < weights.length; k++) {
			for (int i = 0; i < weights.length; i++) {
				for (int j = 0; j < weights.length; j++) {
					if(weights[i][j] > weights[i][k] + weights[j][k]) {
						weights[i][j] = weights[i][k] + weights[j][k];
					}
				}
			}
		}
	}
	
}