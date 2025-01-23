package LLD.Airline;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import LLD.Airline.payment.*;
public class Airline{
    private String name;
    private Map<String,Flight> flights;
    private Map<String,Aircraft> aircrafts;
    private Map<String,User> users;
    private BookingManager bookingManager;

    public Airline(String name) {
        this.name = name;
        this.flights = new ConcurrentHashMap<>();
        this.aircrafts = new ConcurrentHashMap<>();
        this.users = new ConcurrentHashMap<>();
        this.bookingManager = new BookingManager();
    }

    public void addFlight(Flight flight){
        flights.put(flight.getFlightId(),flight);
    }

    public void addAircraft(Aircraft aircraft){
        aircrafts.put(aircraft.getAircraftId(),aircraft);
    }

    public void addUser(User user){
        users.put(user.getUserId(),user);
    }

    public void bookTicket(Flight flight, String seatId, User user, Payment payment, int amount){
        bookingManager.bookTicket(flight,seatId,user,payment,amount);
    }

    public void cancelTicket(String bookingId){
        bookingManager.cancelTicket(bookingId);
    }

}