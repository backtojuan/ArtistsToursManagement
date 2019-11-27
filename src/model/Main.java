package model;

import java.io.IOException;
import java.util.ArrayList;

import datastructures.Edge;
import datastructures.Vertex;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Tour tour = new Tour(Location.AFRICA,"n","2","3",Tour.AFRICA_PATH,Tour.AFRICA_VERTEX);
		System.out.println(tour.getMap().getTotalVertices());
		System.out.println(tour.getMap().getEdges().size());
		double[][] fw = tour.getMap().floydWarshall();
		/*for(int i =0; i<fw.length;i++) {
			for(int j  =0; j<fw[i].length; j++) {
				System.out.print(""+fw[i][j]+" ");
			}
			System.out.println();
		}*/
		City city = new City(Location.AFRICA, "Angola","Luanda");
		Vertex<City> vertex = new Vertex<City>(3, city);
		/*ArrayList<Vertex<City>> bfs =  tour.getMap().BFS(vertex);
		for(int i = 0; i<bfs.size(); i++) {
			System.out.println(bfs.get(i).toString());
		}*/
		/*ArrayList<Edge<City>> dijkstra= tour.getMap().dijkstra(vertex);
		for(int i = 0; i<dijkstra.size(); i++) {
			System.out.println(dijkstra.get(i).toString());
		}
		*/
		ArrayList<Edge<City>> kruskal = tour.getMap().kruskal();
		for(int i = 0; i<kruskal.size(); i++) {
			System.out.println(kruskal.get(i).toString());
		}
		
	}

}
