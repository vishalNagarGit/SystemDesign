import Payment.IPaymentMethod;

import java.util.HashMap;

public class BookingSystem {
    private HashMap<String,User> users;
    private HashMap<String,Movie>movies;
    private HashMap<String, Theatre>theatres;
    private HashMap<String,Show>shows;
    private BookingManager bookingManger;

    public BookingSystem(){
        users = new HashMap<>();
        movies =  new HashMap<>();
        theatres = new HashMap<>();
        shows = new HashMap<>();
        bookingManger = BookingManager.getInstance();
    }

    //user functions
    public void addUser(User user){
        users.put(user.getId(),user);
    }


    // admin functions
    public void addMovie(Movie movie){
        movies.put(movie.getId(),movie);
    }

    public void addTheatre(Theatre theatre){
        theatres.put(theatre.getId(),theatre);
    }

    public void addShow(Show show){
        shows.put(show.getId(),show);
    }

    //Show show, Seat seat, User user, IPaymentMethod paymentMethod
    public String bookTicket(Show show, Seat seat, User user, IPaymentMethod paymentMethod){
        return bookingManger.bookSeat(show,seat,user,paymentMethod);
    }

    public void cancelTicket(String bookingId){
        bookingManger.cancelBooking(bookingId);
    }

    public void showBookings(){
        bookingManger.showBookings();
    }

}
