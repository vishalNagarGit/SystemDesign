import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Show {
    private Movie movie;
    private Date schedule;
    private String id;
    private Theatre theather;
    private HashMap<String,Seat>seats;

    public Show(Movie movie, Date schedule, Theatre theather) {
        this.movie = movie;
        this.schedule = schedule;
        this.id = ""+new Random().nextInt(1000);
        this.theather = theather;
        this.seats =  new HashMap<>();
    }

    public Date getSchedule() {
        return schedule;
    }

    public String getId() {
        return id;
    }


    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheather() {
        return theather;
    }

    public void addSeat(Seat seat){
        seats.put(seat.getSeatId(),seat);
    }

}
