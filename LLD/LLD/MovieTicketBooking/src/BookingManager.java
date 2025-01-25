import Payment.IPaymentMethod;
import Payment.Transaction;
import Types.BookingStatus;
import Types.TransactionStatus;

import javax.imageio.IIOParam;
import java.util.HashMap;

public class BookingManager {
    private static BookingManager bookingManger;
    private HashMap<String,Booking>bookings;
    private BookingManager(){
        bookings = new HashMap<>();
    }

    public synchronized static BookingManager getInstance() {
        if(bookingManger==null){
            bookingManger = new BookingManager();
        }
        return bookingManger;
    }

    public synchronized void addBooking(Booking booking){
        bookings.put(booking.getId(),booking);
    }

    public synchronized void removeBooking(String bookingId){
        bookings.remove(bookingId);
    }

    public String bookSeat(Show show, Seat seat, User user, IPaymentMethod paymentMethod){
        if(seat.isOccupied()){
            System.out.println("seat is occupied");
            return null;
        }
        //TransactionStatus ts,IPaymentMethod pm,Double amount
        Transaction transaction =  new Transaction(TransactionStatus.Pending,paymentMethod,seat.getPrice());
        transaction.execute();

        if(transaction.getTransactionStatus()==TransactionStatus.Success){
            seat.setOccupied(true);
            Booking booking = new Booking(user,show,seat,transaction);
            bookings.put(booking.getId(), booking);
            System.out.println("Booking Success!! "+booking.getId());
            return booking.getId();
        }
        else{
            System.out.println("booking failed");
        }
        return null;
    }

    public void cancelBooking(String bookingId){
        if(!bookings.containsKey(bookingId)){
            System.out.println("Booking doesn't exist");
            return;
        }
        Booking booking = bookings.get(bookingId);
        booking.getSeat().setOccupied(false);
        booking.getTransaction().getPayment().refund(booking.getTransaction().getAmount());
        booking.setStatus(BookingStatus.canceled);
    }

    public void showBookings(){
        System.out.println("-----------------------");
        bookings.forEach((BookingId,booking)->{
            if(booking.getStatus()==BookingStatus.booked){
                System.out.println(BookingId+" "+booking.getStatus()+" "+booking.getSeat().getSeatId()+" "+booking.getUser().getName());
            }
        });
    }

}
