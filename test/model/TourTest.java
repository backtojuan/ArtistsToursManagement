package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
 * This class manage the necessary attributes and methods to test the model class Tour
 * @author Lina Johanna Salinas
 * @author Lina Marcela Acosta
 * @author Maria Diomar Ordoñez
 * @author Juan José Valencia
 * @version 1.0 - November/2019 
 */
public class TourTest {

	private void setUpScenary1() {
		//Empty
	}
	
	@Test
	/**
	 * This method test the exists method of the model class "Tour" making sure that a Tour can be created
	 * with correct attributes, the assignment of its artist its correct and the loading of the selected cities its made
	 * without any problem 
	 * <b>Pos:</b> The tour was created correctly, is not null and it has the expected values. the information for the selected cities
	 * is properly read. 
	 */
	public void testTour() {
		setUpScenary1();
		try {
			Tour tour = new Tour(Location.AFRICA, "shawn mendes : the tour", "2019-11-25", "2020-01-31", Tour.AFRICA_PATH,Tour.AFRICA_VERTEX);
			assertNotNull(tour,"The object is null");
			assertEquals("shawn mendes : the tour", tour.getName(),"The name is not correct");
			assertEquals("2019-11-25", tour.getInitDate(),"The initial date is not correct");
			assertEquals("2020-01-31", tour.getFinalDate(),"The final date is not correct");
		} catch (IOException e) {
			fail("The file is not correct");
		}
	}

}
