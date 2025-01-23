package LLD.Airline;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import LLD.Airline.payment.*;
public class BookingManager{
    private Map<String,Booking> bookings;

    public BookingManager() {
        this.bookings = new ConcurrentHashMap<>();
    }
    

    public synchronized void bookTicket(Flight flight, String seatId, User user, Payment payment, int amount){
        if(flight.bookSeat(seatId)){
            if(payment.makePayment(amount)){
                Booking booking = new Booking(flight,seatId,user,payment,amount);
                bookings.put(booking.getBookingId(),booking);
                user.addBooking(booking.getBookingId());
                System.out.println("Ticket booked successfully:"+booking.getBookingId());
                booking.getBookingDetails();
            }
            else{
                System.out.println("Payment failed");
            }
        }
        else{
            System.out.println("Seat not available"+ seatId);
        }
    }
    
    public synchronized void cancelTicket(String bookingId){
        if(bookings.containsKey(bookingId)){
            Booking booking = bookings.get(bookingId);
            if(booking.bookingStatus == BookingStatus.CONFIRMED){
                if(booking.flight.cancelSeat(booking.seatId)){
                    booking.payment.refundPayment(booking.getAmount());
                    booking.bookingStatus = BookingStatus.CANCELLED;
                    System.out.println("Ticket cancelled successfully");
                }
            }
            else{
                System.out.println("Ticket NOT Booked/Cancelled already");
            }
        }
        else{
            System.out.println("Booking not found");
        }
    }

    public void getBookingDetails(String bookingId){
        if(bookings.containsKey(bookingId)){
            Booking booking = bookings.get(bookingId);
            booking.getBookingDetails();
        }
        else{
            System.out.println("Booking not found");
        }
    }
}