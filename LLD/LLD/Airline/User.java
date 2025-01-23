package LLD.Airline;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.Map;
import LLD.Airline.payment.*;
import java.util.Random;
public class User {
    private String name;
    private String userId;
    private ArrayList<String> bookings;
    // private Map<String> notifications;
    private Integer walletBalance;
    private Map<String,Payment> paymentMethods;

    public User(String name) {
        this.name = name;
        this.userId = new Random().nextInt(1000)+"";
        this.walletBalance =0;
        this.bookings = new ArrayList<>();
        this.paymentMethods = new ConcurrentHashMap<>();
    }

    public void addBooking(String bookingId){
        bookings.add(bookingId);
    }

    public void addPaymentMethod(Payment payment){
        paymentMethods.put(payment.getPaymentId(),payment);
    }

    public void getUserDetails(){
        System.out.println("User Id: "+userId);
        System.out.println("Name: "+name);
        System.out.println("Wallet Balance: "+walletBalance);
    }

    public String getUserName(){
        return name;
    }
    
    public String getUserId(){
        return userId;
    }
}