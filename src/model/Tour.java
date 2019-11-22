package model;

import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.PriorityQueue;
//import java.util.Queue;
import java.util.LinkedList;
import datastructures.*;

/**
 * This class manage the necessary attributes and methods to create planned tours
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordo�ez
 * @author Juan Jos� Valencia
 * @version 1.0 - November/2019 
 */
public class Tour {

	private String name;
	private LocalDate initDate;
	private LocalDate finalDate;

	private Artist artist;
	private AdjacencyListGraph<Vertex<City>> map;
	
	/**
	 * <b>Tour Constructor</b>
	 * @param name the name of this tour
	 * @param initDate the beggining date for the tour
	 * @param finalDate the finishing date for the tour
	 */
	public Tour(String name, LocalDate initDate, LocalDate finalDate) {
		this.name = name;
		this.initDate = initDate;
		this.finalDate = finalDate;
	}
	
	/**
	 * This method returns the name of this tour
	 * <b>Pre:</b> the tour exists
	 * @return the name of this tour
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method returns the initial date of this tour
	 * <b>Pre:</b> the tour exists
	 * @return the initial date for the tour
	 */
	public LocalDate getInitDate() {
		return initDate;
	}

	/**
	 * This method returns the final date of this tour
	 * <b>Pre:</b> the tour exists
	 * @return the final date for the tour
	 */
	public LocalDate getFinalDate() {
		return finalDate;
	}
	
	/**
	 * This method returns the artist that is rehearsing for this tour
	 * <b>Pre:</b> the tour exists
	 * @return the artist for this tour
	 */
	public Artist getArtist() {
		return artist;
	}
	
	/**
	 * This method gives to the tour the artist that will present the tour
	 * <b>Pre:</b> the tour exists
	 * <b>Pos:</b> the artist for this tour is definitive
	 * @param artist the artist confirmed for the tour
	 */
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	/**
	 * This method gives to the tour a map with the best selected route to cover their tour
	 * <b>Pre:</b> the tour exists 
	 * <b>Pos:</b> the route for this tour is definitive
	 * @param map the seleced map with the route to cover this tour
	 */
	public void setMap(AdjacencyListGraph<Vertex<City>> map) {
		this.map = map;
	}
	
	//PRINCIPAL ALGORITHMS
	
	/**public void BFS(City city) {
		for(int i = 0; i<graph.getVertices().size(); i++) {
			graph.getVertices().get(i).setColor("W");
			graph.getVertices().get(i).setKey(Double.POSITIVE_INFINITY);
			graph.getVertices().get(i).setPred(null);
		}
		city.setColor("G");
		city.setKey(0);
		city.setPred(null);
		LinkedList<City> queue = new LinkedList<City>();
		queue.offer(city);
		while(queue != null) {
			//City u = queue.poll();
			for(int i = 0; i<graph.getVertices().get(i).get) {
				if(i.getColor() == WHITE) {
					i.getColor() = GRAY;
					i.getDistancia() = u.distancia+1;
					i.getPrecesor() = u;
					Q.offer(i);
				}
			}
			u.getColor() = BLACK;
		}
	}*/
	
	/**public void BFS(int s,int v) 
    { 
        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[v]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            }
        } 
    }*/ 
	
	// A function used by DFS 
    /**public void DFSUtil(int v,boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        System.out.print(v+" "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        }
    }*/
  
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    /**public void DFS(int v) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[v]; 
  
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(v, visited); 
    }*/
    
	/**
	 * 
	 * @param r
	 */
	/**public void primAlgorithm(City r) {
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
	}*/
	
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
