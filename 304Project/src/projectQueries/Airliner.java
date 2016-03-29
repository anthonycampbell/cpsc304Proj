package projectQueries;

import java.util.Date;

public class Airliner {
	public final String flightNumber;
	public final Date departureTime;
	public final Date arrivalTime;
	public final String modelNumber;
	public final String departureAirport;
	public final String arrivalAirport;
	
	public Airliner(String flightNumber, Date departureTime, Date arrivalTime,
			String modelNumber, String departureAirport, String arrivalAirport){
		this.flightNumber = flightNumber;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.modelNumber = modelNumber;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}
}
