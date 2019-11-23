package datastructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import datastructures.Edge;
import model.City;
import model.Location;

/**
 * This class manage the necessary attributes and methods to test the datastructures class Edge
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class EdgeTest {
	
	private Edge<City> edge;
	private Vertex<City> u;
	private Vertex<City> v;
	
	private void setUpScenary1() {
		//Empty
	}

	@Test
	/**
	 * This method test the constructor of the datastructures class "Edge" making sure an edge can be created
	 * with its right attributes
	 * <b>Pos:</b> The edge has been succesfully created,connects two vertices, 
	 * is different to null and it has correct attributes.
	 */
	public void testEdge() {
		setUpScenary1();
		
		u = new Vertex<City>(1,new City(Location.OCEANIA, "Australia", "Sydney"));
		v = new Vertex<City>(2,new City(Location.ASIA,"China","Pekín"));
		edge = new Edge<City>(u, v, 808);
		
		assertNotNull(edge,"The edge is null as not expected");
		assertNotNull(u,"The u vertex is null as not expected");
		assertNotNull(v,"the v vertex is null as not expected");
		
		assertEquals(u,edge.getU(),"The vertex u is not the expected one");
		assertEquals(v,edge.getV(),"The vertex v is not the expected one");
		assertEquals(808,edge.getWeight(),"The weight is not the expected one");
		
		assertEquals(Location.OCEANIA,edge.getU().getValue().getContinent(),"The continent of the vertex u is not correct");
		assertEquals("Australia",edge.getU().getValue().getCountry(),"The country of the vertex u is not correct");
		assertEquals("Sydney",edge.getU().getValue().getName(),"The name of the vertex u is not correct");
		
		assertEquals(Location.ASIA,edge.getV().getValue().getContinent(),"The continent of the vertex v is not correct");
		assertEquals("China",edge.getV().getValue().getCountry(),"The country of the vertex v is not correct");
		assertEquals("Pekín",edge.getV().getValue().getName(),"The name of the vertex v is not correct");
	}
}
