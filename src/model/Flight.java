package model;

/**
 * This class manage the necessary attributes and methods to manage and create a Flight
 * 
 * @author Juan José Valencia Jaramillo
 * @version V_01_April-2019
 */
public class Flight{

	private String airline;
	private City origincity;
	private City destinationcity;

	/**
	 * <b>Flight Constructor</b>
	 * This method creates a flight with random attributes
	 */
	public Flight(String airline,City origincity,City destinationcity){
		this.airline = airline;
		this.origincity = origincity;
		this.destinationcity = destinationcity;
	}	
	
	/**
	 * This method returns the Airline given to the flight
	 * @return an Airline enumeration assignment that represents the airline given to the flight
	 */
	public String getAirline() {
		return airline;
	}

	/**
	 * This method returns the origin city given to the flight
	 * @return origincity a origincity city given to the flight
	 */
	public City getOriginCity() {
		return origincity;
	}
	
	/**
	 * This method returns the Destination city given to the flight
	 * @return destinationcity a Destination city given to the flight
	 */
	public City getDestinationcity() {
		return destinationcity;
	}
}
