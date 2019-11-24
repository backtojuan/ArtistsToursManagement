package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.City;
import model.Location;

/**
 * This class manage the necessary attributes and methods to test the model class City
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class CityTest {
	
	private City city;

	private void setUpScenary1() {
		
	}
	private void setUpScenary2() {
		city = new City(Location.AFRICA, "Sudafrica","Johannesburgo");
	}
	
	@Test
	/**
	 * This method test the exists method of the model class "City" making sure that a City can be created
	 * with correct attributes
	 * <b>Pos:</b> The city was created correctly, is not null and it has the expected values.
	 */
	public void testCity() {
		setUpScenary1();
		city = new City(Location.ASIA, "China", "Pekin");
		
		assertNotNull(city, "The city is null as not expected");
		
		assertTrue(city.getContinent().equals(Location.ASIA), "The continent is not correct");
		assertTrue(city.getCountry().equals("China"), "The country is not corrrect");
		assertTrue(city.getName().equals("Pekin"), "The name is not correct");
	}
	
	@Test
	/**
	 * This method test the getters methods of the model class "City" making sure that 
	 * its attributes can be obtained anytime it is required to 
	 * <b>Pos:</b> The attributes of the city could be obtained correctly with the expected values.
	 */
	
	public void testGetters() {
		
		setUpScenary2();
		
		assertEquals(Location.AFRICA, city.getContinent(), "The continent is not the expected one");
		assertEquals("Sudafrica", city.getCountry(), "The country is not expected one");
		assertEquals("Johannesburgo", city.getName(), "The name is not expected one");
	}

}
