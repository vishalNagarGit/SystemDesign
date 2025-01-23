package LLD.Airline;
import java.util.concurrent.ConcurrentHashMap;
public class Flight{
    private String flightId;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private Aircraft aircraft;
    private String date;

    public Flight(String flightId, String source, String destination, String departureTime, String arrivalTime, Aircraft aircraft, String date) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.aircraft = aircraft;
        this.date = date;
    }

    public boolean bookSeat(String seatId){
        return aircraft.bookSeat(seatId);
    }

    public boolean cancelSeat(String seatId){
        return aircraft.cancelSeat(seatId);
    }

    //getters
    public String getFlightId() {
        return flightId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public String getDate() {
        return date;
    }   

    public void getFlightDetails(){
        System.out.println("Flight Id: "+flightId);
        System.out.println("Source: "+source);
        System.out.println("Destination: "+destination);
        System.out.println("Departure Time: "+departureTime);
        System.out.println("Arrival Time: "+arrivalTime);
        System.out.println("Date: "+date);
        aircraft.getAircraftDetails();
    }

}