import Payment.Transaction;
import Types.BookingStatus;

import java.util.Random;

public class Booking {
    private String id;
    private Seat seat;
    private User user;
    private Show show;
    private BookingStatus status;
    private Transaction transaction;

    public Booking(User user, Show show, Seat seat,Transaction transaction){
        this.id = ""+new Random().nextInt(1000);
        this.user = user;
        this.seat = seat;
        this.show = show;
        this.status = BookingStatus.booked;
        this.transaction = transaction;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return id;
    }

    public Seat getSeat() {
        return seat;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Show getShow() {
        return show;
    }

    public Transaction getTransaction() {
        return transaction;
    }
}
