package datastructures;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

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

	private List<Vertex<Value>> vertices;
	private LinkedList<Edge<Value>> [] adjacencylist;

	/**
	 * <b>Graph Constructor</b>
	 * Constructor method for a non-directed weighted graph using adjacencylist
	 * @param totalvertices the totalvertices to be added in the current graph
	 */
	@SuppressWarnings("unchecked")
	public AdjacencyListGraph(int totalvertices) {
		this.totalvertices = totalvertices;
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
	public List<Vertex<Value>> getVertices() {
		return vertices;
	}

	/**
	 * This method returns the all edges that has been added to the graph
	 * <b>Pre:</b> the graph exists 
	 * @return a List with all the edges
	 */
	public List<Edge<Value>> getEdges(){
		ArrayList<Edge<Value>> edges =new ArrayList<>();
		for (int i = 0; i < totalvertices; i++) {
			for (int j = 0; j < adjacencylist[i].size(); j++) {
				edges.add(adjacencylist[i].get(j));
			}
		}
		return edges;
	}

	/**
	 * This method returns the adjacent vertices from each vertex inside this graph
	 *<b>Pre:</b> the graph exists 
	 * @return the adjacencylist of this graph
	 */
	public LinkedList<Edge<Value>>[] getAdjacencyList(){
		return adjacencylist;
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
				weights[i][j] = Double.MAX_VALUE;
			}
		}
		for (int i = 0; i < vertices.size(); i++) {
			weights[i][i] = 0;
			Vertex<Value> u = vertices.get(i);
			LinkedList<Edge<Value>> adjacent = adjacencylist[u.getKey()-1];
			for (int j = 0; j < adjacent.size(); j++) {
				Edge<Value> e = adjacent.get(j);
				Vertex<Value> v = e.getV();
				double weight = e.getWeight();
				weights[i][v.getKey()-1] = weight;
				weights[v.getKey()-1][i] = weight;
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
		if(exists(vertex)== false) {
			vertices.add(vertex);
		}
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
		Edge<Value> uedge = new Edge<>(u, v, weight);
		adjacencylist[u.getKey()-1].add(uedge);
		Edge<Value> vedge = new Edge<>(v,u,weight);
		adjacencylist[v.getKey()-1].add(vedge);
	}

	/**
	 * This method returns the adjacent vertices for a given vertex
	 * @param vertex the vertex which adjacency is going to be verified
	 * @return a list with all adjacent vertices to the given vertex
	 */
	@Override
	public List<Vertex<Value>> vertexAdjacent(Vertex<Value> vertex){
		ArrayList<Vertex<Value>> adjacentvertices = new ArrayList<>();
		int key = vertex.getKey()-1;
		for (int i = 0; i < adjacencylist[key].size(); i++) {
			adjacentvertices.add(adjacencylist[vertex.getKey()-1].get(i).getV());
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
	 * @return a list of distances from a given source vertex to its all adjacent vertices
	 */
	public ArrayList<Vertex<Value>> BFS(Vertex<Value> source) {

		ArrayList<Vertex<Value>> reachable = new ArrayList<>();
		int key = source.getKey();

		for(Vertex<Value> vertex : vertices) {
			vertex.setColor(Vertex.WHITE);
			vertex.setDistance(Integer.MAX_VALUE);
			vertex.setPred(null);
		}
		source.setColor(Vertex.GRAY);
		source.setDistance(0);
		source.setPred(null);
		reachable.add(source);
		PriorityQueue<Vertex<Value>> queue = new PriorityQueue<>();
		queue.offer(source);
		while(!queue.isEmpty()) {
			Vertex<Value> u = queue.poll();
			ArrayList<Vertex<Value>> adjacent = (ArrayList<Vertex<Value>>) vertexAdjacent(u);
			for (int i = 0; i < adjacent.size(); i++) {
				Vertex<Value> v = adjacent.get(i);
				if(v.getColor().equals(Vertex.WHITE)) {
					v.setColor(Vertex.GRAY);
					v.setDistance(u.getDistance()+1);
					v.setPred(u);
					reachable.add(v);
					queue.offer(v);
				}
				u.setColor(Vertex.BLACK);
			}
		}
		return reachable;
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
				time = dfsVisit(adj, time);
			}
		}
		vertex.setColor(Vertex.BLACK);
		time = time+1;
		vertex.setFinishtime(time);
		return time;
	}

	/**
	 * This method generates a Minimum Spanning Tree (MST) using Prim's Algorithm
	 * <b>Pre:</b> The graph exists
	 * <b>Pre:</b> The given source vertex is in the graph
	 * <b>Pos:</b> The distances from a given source vertex to the rest (including all vertices) are minimum
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
			color[i] = vertices.get(i);
			color[i].setColor(Vertex.WHITE);
			pred[i] = vertices.get(i);
			pred[i].setPred(null);
		}
		keys[0] = 0;
		PriorityQueue<Vertex<Value>> queue = new PriorityQueue<>(new VertexComparator<Value>());
		for(Vertex<Value> vertex : vertices) {
			queue.offer(vertex);
		}
		while(!queue.isEmpty()) {
			Vertex<Value> u = queue.poll();
			for (Edge<Value> e : adjacencylist[key-1]) {
				Vertex<Value> v = e.getV();
				if(v.getColor().equals(Vertex.WHITE) && e.getWeight() < keys[v.getKey()-1]) {
					queue.remove(v);
					keys[v.getKey()-1] = e.getWeight();
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
	 * @return a list with all the less distances to cover the all vertices in the graph
	 */
	public ArrayList<Edge<Value>> kruskal() {
		ArrayList<Edge<Value>> keys = new ArrayList<>();
		ArrayList<Edge<Value>> edges = (ArrayList<Edge<Value>>) getEdges();
		Collections.sort(edges, new EdgeComparator<Value>());

		UnionFind disjointset = new UnionFind(totalvertices);

		int edgesize = 0;
		int i = 0;

		while(edgesize < vertices.size() && i < edges.size()) {
			Edge<Value> edge = edges.get(i);
			i++;

			int a = disjointset.find(edge.getU().getKey()-1);
			int b = disjointset.find(edge.getV().getKey()-1);

			if(a != b) {
				keys.add(edge);
				edgesize++;
				disjointset.union(a, b);
			}
		}
		return keys;
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
	public ArrayList<Edge<Value>> dijkstra(Vertex<Value> source){

		ArrayList<Edge<Value>> minimum = new ArrayList<>();

		double[] distances = new double[totalvertices];
		Vertex<Value>[] pred = new Vertex[totalvertices];
		PriorityQueue<Vertex<Value>> queue = new PriorityQueue<>(new VertexComparator<Value>());

		for (int i = 0; i < totalvertices; i++) {
			Vertex<Value> vertex = vertices.get(i);
			if(!vertex.equals(source)) {
				distances[vertex.getKey()-1] = Double.MAX_VALUE;
				pred[vertex.getKey()-1] = vertex;
				pred[vertex.getKey()-1].setPred(null);
				queue.offer(vertex);
			}
		}

		while(!queue.isEmpty()) {
			Vertex<Value> u = queue.poll();
			LinkedList<Edge<Value>> adjacent = adjacencylist[u.getKey()-1];
			for (int i = 0; i < adjacent.size(); i++) {
				Vertex<Value> v = adjacent.get(i).getV();
				double alt = distances[u.getKey()-1] + adjacent.get(v.getKey()-1).getWeight();
				if(alt<distances[v.getKey()-1]) {
					queue.remove(v);
					minimum.add(new Edge<Value>(u,v,alt));
					distances[v.getKey()-1] = alt;
					pred[v.getKey()-1] = u;
					queue.add(v);
				}
			}
		}
		return minimum;
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
	public double[][] floydWarshall() { 
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
		return weights;
	}
} 