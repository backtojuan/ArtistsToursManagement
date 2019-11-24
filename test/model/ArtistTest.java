package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.Artist;

/**
 * This class manage the necessary attributes and methods to test the model class Artist
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class ArtistTest {
	
	private Artist artist;

	private void setUpScenary1() {
		//Empty
	}
	
	private void setUpScenary2() {
		artist = new Artist("Laura Pergolizzi", "Capitol Records");
	}
	
	@Test
	/**
	 * This method test the exists method of the model class "Artist" making sure that an Artist can be created
	 * with correct attributes
	 * <b>Pos:</b> The artist was created correctly, is not null and it has the expected values.
	 */
	public void testArtist() {
		setUpScenary1();
		
		artist = new Artist("Shawn Mendez", "Island Records");
		
		assertNotNull(artist, "The artist is null as not expected");
		
		assertTrue(artist.getName().equals("Shawn Mendez"), "The name is not correct");
		assertTrue(artist.getLabel().equals("Island Records"), "The label is not correct");
		
		
	}
	
	@Test
	/**
	 * This method test the getters methods of the model class "Artist" making sure that 
	 * its attributes can be obtained anytime it is required to 
	 * <b>Pos:</b> The attributes of the artist could be obtained correctly with the expected values.
	 */
	
	public void testGetters() {
		
		setUpScenary2();
		
		assertEquals("Laura Pergolizzi", artist.getName(), "The name is not the expected one");
		assertEquals("Capitol Records", artist.getLabel(), "The label is not the expected one");
	}

}
