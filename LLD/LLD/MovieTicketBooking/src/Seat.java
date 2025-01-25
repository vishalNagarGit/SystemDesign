import Types.SeatType;

public class Seat {
    private SeatType seatType;
    private String seatId;
    private Double price;
    private boolean occupied;

    public Seat(SeatType seatType,String seatId,Double price){
        this.seatType = seatType;
        this.seatId = seatId;
        this.price = price;
        this.occupied = false;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public String getSeatId() {
        return seatId;
    }

    public Double getPrice() {
        return price;
    }

    public boolean isOccupied(){
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
