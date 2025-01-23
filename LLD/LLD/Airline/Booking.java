package LLD.Airline;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;
import LLD.Airline.payment.*;
import java.util.Random;

public class Booking{
    public String bookingId;
    public Flight flight;
    public String seatId;
    public User user;
    public BookingStatus bookingStatus;
    public Payment payment;
    public PaymentState paymentState;
    private int amount;

    public Booking( Flight flight, String seatId, User user,Payment payment,int amount) {
        this.bookingId = new Random().nextInt(100)+"";
        this.flight = flight;
        this.seatId = seatId;
        this.user = user;
        this.payment = payment;
        this.paymentState = PaymentState.PENDING;
        this.bookingStatus =  null;
        this.amount = amount;
    }


    public String getBookingId() {
        return bookingId;
    }

    public void getBookingDetails(){
        System.out.println("Booking Id: "+bookingId);
        System.out.println("Flight: "+flight.getFlightId());
        System.out.println("Seat: "+seatId);
        System.out.println("User: "+user.getUserName());
        System.out.println("Status: "+bookingStatus);
        System.out.println("Amount: "+amount);
    }

    //getters
    public Flight getFlight() {
        return flight;
    }

    public String getSeatId() {
        return seatId;
    }

    public User getUser() {
        return user;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public Payment getPayment() {
        return payment;
    }

    public PaymentState getPaymentState() {
        return paymentState;
    }

    public int getAmount() {
        return amount;
    }
}





