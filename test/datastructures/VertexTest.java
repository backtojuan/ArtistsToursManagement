package datastructures;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import datastructures.Vertex;
import model.City;
import model.Location;

/**
 * This class manage the necessary attributes and methods to test the datastructures class Vertex
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class VertexTest {

	private Vertex<City> vertex;
	private City city;
	
	private void setUpScenary1() {
		//Empty
	}
	
	private void setUpScenary2() {
		city = new City(Location.AMERICA,"Colombia", "Cali");
		vertex = new Vertex<City>(2,city);
	}
	
	@Test
	/**
	 * This method test the constructor of the datastructures class "Vertex" making sure a vertex can be created
	 * with its right attributes
	 * <b>Pos:</b> The vertex has been succesfully created, is different to null and it has correct attributes.
	 */
	public void testVertex() {
		setUpScenary1();
		City city = new City(Location.EUROPE,"Alemania", "Berlin");
		vertex = new Vertex<City>(1, city);
		
		assertNotNull(vertex, "The vertex is null as not expected");
		assertNotNull(vertex.getValue(), "The value of this vertex is null as not expected");

		assertEquals(city,vertex.getValue(),"The citiy value is not the expected one");
		assertTrue((vertex.getKey() ==1), "The key is not the expected one");
		assertTrue(vertex.getValue().getContinent().equals(Location.EUROPE), "The continent is not correct");
		assertTrue(vertex.getValue().getCountry().equals("Alemania"), "The country is not correct");
		assertTrue(vertex.getValue().getName().equals("Berlin"), "The name is not correct");
	}
	
	@Test
	/**
	 * This method test the getters and setters methods of the datastructures class "Vertex" making sure that 
	 * its attributes can be obtained and modified anytime it is required to 
	 * <b>Pos:</b> The attributes of the vertex could be obtained and modified correctly with the expected values.
	 */
	public void testGettersAndSetters() {
		setUpScenary2();
		
		assertEquals(2, vertex.getKey(),"The key is not the expected one");
		assertEquals(city, vertex.getValue(), "The value of this vertex is not the expected one");
		assertEquals(Location.AMERICA,vertex.getValue().getContinent(),"The continent is not the expected one");
		assertEquals("Colombia",vertex.getValue().getCountry(),"The country is not the expected one");
		assertEquals("Cali", vertex.getValue().getName(),"The name is not the expected one");
		
		assertEquals(Vertex.WHITE,vertex.getColor(),"The color is not the expected one");
		vertex.setColor(Vertex.GRAY);
		assertEquals(Vertex.GRAY,vertex.getColor(),"The color is not the expected one");
		vertex.setInitialtime(7);
		assertEquals(7, vertex.getInitialtime(), "The initial time is not the expected one");
		vertex.setFinishtime(8);
		assertEquals(8, vertex.getFinishtime(), "The initial time is not the expected one");
		assertNull(vertex.getPred(), "The predecessor is not null");
		vertex.setPred(new Vertex<City>(3,new City(Location.AFRICA,"Sudafrica", "Congo")));
		assertNotNull(vertex.getPred(), "The predecessor is null");
		
		assertEquals(Location.AFRICA,vertex.getPred().getValue().getContinent(),"The continent of the predecessor is not correct");
		assertEquals("Sudafrica",vertex.getPred().getValue().getCountry(),"The continent of the predecessor is not correct");
		assertEquals("Congo",vertex.getPred().getValue().getName(),"The continent of the predecessor is not correct");
	}
}
