package datastructures;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
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
	 * Constructor method for a non-directed weighted graph
	 * @param totalvertices the totalvertices to be added in the current graph
	 */
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
	public ArrayList<Vertex<Value>> getVertices() {
		return vertices;
	}

	/**
	 * This method returns the adjacent vertices from each vertex inside this graph
	 *<b>Pre:</b> the graph exists 
	 * @return the adjacencylist of this graph
	 */
	public LinkedList<Edge<Value>>[] getAdjacencyList(){
		return adjacencylist;
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
		adjacencylist[u.getKey()-1].add(edge);
		adjacencylist[v.getKey()-1].add(edge);
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

	//PRINCIPAL ALGORITHMS

	/**
	 * This method searchs for adjacent vertices from a source vertex using Breadth First Search
	 * <b>Pre:</b> The graph exists
	 * <b>Pre:</b> The given source vertex is in the graph
	 * <b>Pos:</b> The distances from a given source vertex to its all adjacent vertices are calculated correctly 
	 * @param source the vertex from where it needs to be calculated the distances to the rest of adjacent vertices
	 * @return an array of distances from a given source vertex to its all adjacent vertices
	 */
	public int[] BFS(Vertex<Value> source) {
		
		int[] distances = new int[totalvertices];
		int key = source.getKey();
		
		for(int i = 0; i<vertices.size(); i++) {
			vertices.get(i).setColor("W");
			vertices.get(i).setDistance(Integer.MAX_VALUE);
			vertices.get(i).setPred(null);
		}
		source.setColor(Vertex.GRAY);
		source.setDistance(0);
		source.setPred(null);
		PriorityQueue<Vertex<Value>> queue = new PriorityQueue<Vertex<Value>>();
		queue.offer(source);
		while(queue != null) {
			Vertex<Value> u = queue.poll();
			for (int i = 0; i < adjacencylist[key-1].size(); i++) {
				Vertex<Value> v = adjacencylist[key-1].get(i).getV(); 
				if(v.getColor().equals(Vertex.WHITE)) {
					v.setColor(Vertex.GRAY);
					v.setDistance(u.getDistance()+1);
					distances[i] = v.getDistance();
					v.setPred(u);
					queue.offer(v);
				}
				u.setColor(Vertex.BLACK);
			}
		}
		return distances;
	}

	/**public void prim(Vertex<Value> source) {
		for(int i = 0; i<graph.getVertices().size(); i++) {
			graph.getVertices().get(i).setKey((int)Long.MAX_VALUE);
			graph.getVertices().get(i).setColor("W");
		}
		r.setKey(0);
		r.setPred(null);
		PriorityQueue<City> Q = new PriorityQueue<>();
		Q.offer(graph.getVertices().get(r.getId()));
		City u;
		while(Q.isEmpty() == false) {
			u = (City) Q.poll();
			for(int i = 0; i < graph.getVertices().size(); i++) {

			}
		}
	}

	/**
	 * 
	 * @param graph
	 * @param V
	 * @param src
	 */
	public void dijkstra(int graph[][],int V, int src) 
	{ 
		int dist[] = new int[V];
		Boolean sptSet[] = new Boolean[V]; 

		for (int i = 0; i < V; i++) { 
			dist[i] = Integer.MAX_VALUE; 
			sptSet[i] = false; 
		} 

		dist[src] = 0; 

		for (int count = 0; count < V - 1; count++) {  

			//int u = minDistance(dist, sptSet);  Method to calculate min distance still being implemented
			int u = 0;
			sptSet[u] = true; 

			for (int v = 0; v < V; v++) { 
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) { 
					dist[v] = dist[u] + graph[u][v]; 
				}
			}
		} 
	}


	/**
	 * 
	 * @param graph
	 * @param V
	 */
	public void floydWarshall(int graph[][], int V) { 
		int dist[][] = new int[V][V]; 
		int i, j, k; 

		for (i = 0; i < V; i++) { 
			for (j = 0; j < V; j++) { 
				dist[i][j] = graph[i][j];
			}
		}
		for (k = 0; k < V; k++) 
		{  
			for (i = 0; i < V; i++) 
			{       
				for (j = 0; j < V; j++) 
				{  
					if (dist[i][k] + dist[k][j] < dist[i][j]) 
						dist[i][j] = dist[i][k] + dist[k][j]; 
				} 
			} 
		}
	}
} 