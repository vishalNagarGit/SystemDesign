import Payment.CreditCardPayment;
import Types.SeatType;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
            Theatre theatre =  new Theatre("Gold Cinema","kota");
            Movie movie = new Movie("Anaconda",180000.0,"HIss Hisss","21/09/22");
            Show show1 = new Show(movie,new Date(2022,9,23,18,30),theatre);
            Show show2 = new Show(movie,new Date(2022,9,23,21,30),theatre);
                Seat seat1 = new Seat(SeatType.Silver,"B1",120.00);
                Seat seat2 = new Seat(SeatType.Gold,"G1",160.00);
            show1.addSeat(seat1);
            show1.addSeat(seat2);
                Seat seat3 = new Seat(SeatType.Silver,"B1",120.00);
                Seat seat4 = new Seat(SeatType.Gold,"G1",160.00);
            show2.addSeat(seat3);
            show2.addSeat(seat4);
            User user = new User("Vishal");
        bookingSystem.addMovie(movie);
        bookingSystem.addShow(show1);
        bookingSystem.addUser(user);
        bookingSystem.addTheatre(theatre);
        String bookingId = bookingSystem.bookTicket(show1,seat2,user,new CreditCardPayment("22323222","vishalnagar","232","21/9/2025"));
        String bookingId2 = bookingSystem.bookTicket(show1,seat4,user,new CreditCardPayment("22323222","vishalnagar","232","21/9/2025"));

        bookingSystem.showBookings();
        bookingSystem.cancelTicket(bookingId);
        bookingSystem.showBookings();
    }
}