package projectQueries;

import java.util.Date;

public class Airliner {
	private String flightNumber;
	private Date departureTime;
	private Date arrivalTime;
	private String modelNumber;
	private String departureAirport;
	private String arrivalAirport;
	
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
