package LLD.Airline;
import LLD.Airline.payment.*;
public class AirlineDemo {
    public static void main(String[] args) {
        Airline airline = new Airline("Indigo");
        Aircraft aircraft = new Aircraft("Boeing 737", 100);
            aircraft.addSeat("1A");
            aircraft.addSeat("1B");
            aircraft.addSeat("1C");
            airline.addAircraft(aircraft);
        
        Flight flight = new Flight("F100", "BLR", "DEL", "10:00", "12:00", aircraft, "2021-07-01");
            airline.addFlight(flight);
        
        Payment payment = new CardPayment("P100","AXIS MY zone","05/29","123");

        User user1 = new User("John");
            user1.addPaymentMethod(payment);
            airline.addUser(user1);
            
        
        User user2 = new User("Jane");
            user2.addPaymentMethod(payment);
            airline.addUser(user2);
            
        
        User user3 = new User("Doe");
            user3.addPaymentMethod(payment);
            airline.addUser(user3);
            


        Runnable bookTicketTask1 = () -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            airline.bookTicket(flight, "1A", user1, payment, 1000);
        };


        Runnable bookTicketTask2 = () -> {
            try {
                Thread.sleep(101);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            airline.bookTicket(flight, "1A", user2, payment, 1000);
        };

        Runnable bookTicketTask3 = () -> {
            try {
                Thread.sleep(102);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            airline.bookTicket(flight, "1A", user3, payment, 1000);
        };
     

        Thread thread1 = new Thread(bookTicketTask1);
        Thread thread2 = new Thread(bookTicketTask2);
        Thread thread3 = new Thread(bookTicketTask3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}