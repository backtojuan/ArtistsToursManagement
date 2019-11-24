package datastructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import datastructures.AdjacencyMatrixGraph;
import model.City;
import model.Location;

/**
 * This class manage the necessary attributes and methods to test the datastructures class AdjacencyMatrixGraph
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class AdjacencyMatrixGraphTest {

	private AdjacencyMatrixGraph<City> map;
	
	private void setUpScenary1() {
		//Empty
	}
	
	private void setUpScenary2() {
		map = new AdjacencyMatrixGraph<City>(10);
	}
	
	private void setUpScenary3() {
		map = new AdjacencyMatrixGraph<>(5);
		map.addVertex(new Vertex<City>(1,new City(Location.AMERICA,"Mexico","Monterrey")));
		map.addVertex(new Vertex<City>(2,new City(Location.EUROPE,"Italia","Roma")));
		map.addVertex(new Vertex<City>(3,new City(Location.AFRICA,"Nigeria","Lagos")));
		map.addVertex(new Vertex<City>(4,new City(Location.ASIA,"Japan","Kioto")));
		map.addVertex(new Vertex<City>(5,new City(Location.OCEANIA,"Australia","Darwin")));
	}
	
	private void setUpScenary4() {
		map = new AdjacencyMatrixGraph<>(5);
		
		map.addVertex(new Vertex<City>(1,new City(Location.AMERICA,"Mexico","Monterrey")));
		map.addVertex(new Vertex<City>(2,new City(Location.EUROPE,"Italia","Roma")));
		map.addVertex(new Vertex<City>(3,new City(Location.AFRICA,"Nigeria","Lagos")));
		map.addVertex(new Vertex<City>(4,new City(Location.ASIA,"Japan","Kioto")));
		map.addVertex(new Vertex<City>(5,new City(Location.OCEANIA,"Australia","Darwin")));
		
		map.addEdge(map.getVertices().get(0), map.getVertices().get(2),3700);
		map.addEdge(map.getVertices().get(2), map.getVertices().get(1), 2500);
		map.addEdge(map.getVertices().get(3), map.getVertices().get(1), 1800);
		map.addEdge(map.getVertices().get(3), map.getVertices().get(4), 700);
	}
	
	@Test
	/**
	 * This method test the constructor of the datastructures class "AdjacencyMatrixGraph" making sure a graph can be created
	 * with its right attributes
	 * <b>Pos:</b> The graph has been created correctly, is not null and it has the expected vertices added and connected
	 * between them with the right attributes
	 */
	public void testAdjacencyMatrix() {
		setUpScenary1();
		assertNull(map,"The map is not null");
		AdjacencyMatrixGraph<City> map = new AdjacencyMatrixGraph<>(40);
		assertTrue(map.getVertices().isEmpty(),"The graph has already vertices");
		assertNotNull(map,"The map is null as not expected");
		assertEquals(40,map.getTotalVertices(),"The total vertices planned to be insert in this graph is not correct");
		
		for (int i = 0; i < map.getAdjacencyMatrix().size(); i++) {
			assertNotNull(map.getAdjacencyMatrix().get(i),"The adjacency List is null");
			assertTrue(map.getAdjacencyMatrix().get(i).isEmpty(),"A vertex has been already determined as adjacent");
		}
	}
	
	@Test
	/**
	 * This method test the addVertex method of the datastructures class "AdjacencyMatrixGraph" making sure the vertices can be inserted 
	 * to this graph
	 * <b>Pos:</b> The vertices were added correctly, they are not null and they have the right values
	 */
	public void testAddVertex() {
		setUpScenary2();
		map.addVertex(new Vertex<City>(1,new City(Location.AMERICA,"Brasil","Rio de janeiro")));
		map.addVertex(new Vertex<City>(2,new City(Location.AMERICA,"Chile","Santiago de chile")));
		
		map.addVertex(new Vertex<City>(3,new City(Location.EUROPE,"Alemania","Berlín")));
		map.addVertex(new Vertex<City>(4,new City(Location.EUROPE,"Francia","París")));
		
		map.addVertex(new Vertex<City>(5,new City(Location.AFRICA,"Sudafrica","Johannesburgo")));
		map.addVertex(new Vertex<City>(6,new City(Location.AFRICA,"Egipto","El cairo")));
		
		map.addVertex(new Vertex<City>(7,new City(Location.ASIA,"China","Pekín")));
		map.addVertex(new Vertex<City>(8,new City(Location.ASIA,"Japan","Tokyo")));
		
		map.addVertex(new Vertex<City>(9,new City(Location.OCEANIA,"Australia","Sydney")));
		map.addVertex(new Vertex<City>(10,new City(Location.OCEANIA,"Australia","Melbourne")));
		
		assertTrue(!map.getVertices().isEmpty(),"The vertices for this graph are empty");
		assertEquals(10,map.getTotalVertices(),"The total number of vertices inserted to this graph are not the expected one");
		
		for (int i = 0; i < map.getVertices().size(); i++) {
			assertNotNull(map.getVertices().get(i),"The vertex is null");
		}
	}
	
	@Test
	/**
	 * This method test the addEdge method of the datastructures class "AdjacencyMatrixGraph" making sure an edge can be created and connect two
	 * vertices that has been already inserted to this graph
	 * <b>Pos:</b> The edge were created correctly, they are not null, connect the right vertices and have the correct weight
	 */
	public void testAddEdge() {
		setUpScenary3();
		
		map.addEdge(map.getVertices().get(0), map.getVertices().get(2),3700);
		map.addEdge(map.getVertices().get(2), map.getVertices().get(1), 2500);
		map.addEdge(map.getVertices().get(1), map.getVertices().get(3), 1800);
		map.addEdge(map.getVertices().get(3), map.getVertices().get(4), 700);
		
		for (int i = 0; i < map.getAdjacencyMatrix().size(); i++) {
			assertTrue(!map.getAdjacencyMatrix().get(i).isEmpty(), "There is a vertex without adjacent vertices");
		}	
	}
	
	@Test
	/**
	 * This method test the getWeightsMatrix method of the datastructures class "AdjacencyListGraph" making sure an weights 
	 * matrix for this graph is initialized with the expected values
	 * <b>Pos:</b> The weights matrix was created correctly, it is not null, and have the correct weight in the correct position
	 */
	public void testWeightsMatrix() {
		setUpScenary2();
		for (int i = 0; i < map.getWeightsMatrix().length; i++) {
			for (int j = 0; j < map.getWeightsMatrix()[i].length; j++) {
				assertNull(map.getWeightsMatrix()[i][j], "The matrix has been initialized");
			}
		}
		
		setUpScenary4();
		assertEquals(3700,map.getWeightsMatrix()[0][2],"The weight for the edge is not correct");
		assertEquals(3700,map.getWeightsMatrix()[2][0],"The weight for the edge is not correct");
		
		assertEquals(2500,map.getWeightsMatrix()[2][1],"The weight for the edge is not correct");
		assertEquals(2500,map.getWeightsMatrix()[1][2],"The weight for the edge is not correct");
		
		assertEquals(1800,map.getWeightsMatrix()[1][3],"The weight for the edge is not correct");
		assertEquals(1800,map.getWeightsMatrix()[3][1],"The weight for the edge is not correct");
		
		assertEquals(700,map.getWeightsMatrix()[3][4],"The weight for the edge is not correct");
		assertEquals(700,map.getWeightsMatrix()[4][3],"The weight for the edge is not correct");
	
	}
	
	@Test
	/**
	 * This method test the vertexAdjacent method of the datastructures class "AdjacencyListGraph" making sure an weights 
	 * matrix for this graph is initialized with the expected values
	 * <b>Pos:</b> The weights matrix was created correctly, it is not null, and have the correct weight in the correct position
	 */
	public void testVertexAdjacent() {
		setUpScenary4();	
		for (int i = 0; i < map.getAdjacencyMatrix().size(); i++) {
			for (int j = 0; j < map.getAdjacencyMatrix().get(i).size(); j++) {
				assertTrue(!map.getAdjacencyMatrix().get(i).isEmpty(), "The adjacent vertex is empty");
				assertEquals(0,map.getAdjacencyMatrix().get(i).get(i),"The origin vertex is different");
			}
		}
		
		assertEquals(1,map.getAdjacencyMatrix().get(0).get(2),"This vertex is not adjacent");
		assertEquals(1,map.getAdjacencyMatrix().get(2).get(0),"This vertex is not adjacent");
		assertEquals(1,map.getAdjacencyMatrix().get(2).get(1),"This vertex is not adjacent");
		assertEquals(1,map.getAdjacencyMatrix().get(4).get(3),"This vertex is not adjacent");
	}
	
	@Test
	/**
	 * This method test the BFS method of the datastructures class "AdjacencyListGraph" making sure a set of vertices can be search from 
	 * a selected source vertex
	 * <b>Pos:</b> The bfs was succesfull, every reachable vertice from the source vertex is not null and it has the expected cost that it takes
	 * to find it
	 */
	public void testBreadthFirstSearch() {
		
	}
	
	@Test
	/**
	 * This method test the DFS method of the datastructures class "AdjacencyListGraph" making sure a set of vertices can be search from 
	 * a selected source vertes
	 * <b>Pos:</b> The dfs was succesfull, every reachable vertice from the source vertex is not null and it has the expected time for
	 * discoverment and finishing
	 */
	public void testDepthFirstSearch() {
		
	}
	
	@Test
	/**
	 * This method test the Prim method of the datastructures class "AdjacencyListGraph" making sure a Minimum spanning tree can be created 
	 * from the algorithm 
	 * <b>Pos:</b> The prim was succesfull, the MST covers all vertices and the graph is minimum
	 */
	public void testPrim() {
		
	}
	
	@Test
	/**
	 * This method test the Kruskal method of the datastructures class "AdjacencyListGraph" making sure a Minimum spanning tree can be created 
	 * from the algorithm 
	 * <b>Pos:</b> The kruskal was succesfull, the MST from the forest covers all vertices and the graph is minimum
	 */
	public void testKruskal() {
		
	}
	
	@Test
	/**
	 * This method test the Dijkstra method of the datastructures class "AdjacencyListGraph" making sure a shortest path between a source
	 * vertes and the rest can be executed
	 * <b>Pos:</b> The dijkstra was succesfull, the shortest path from a source vertex to the rest is minimum
	 */
	public void testDijkstra() {
		
	}
	
	@Test
	/**
	 * This method test the Floyd Warshall method of the datastructures class "AdjacencyListGraph" making sure a shortest path between
	 * every pair of cities can be executed
	 * <b>Pos:</b> The floydwarshall was succesfull, the shortest path between every pair of vertices is minimum
	 */
	public void testFloydWarshall() {
		
	}
}