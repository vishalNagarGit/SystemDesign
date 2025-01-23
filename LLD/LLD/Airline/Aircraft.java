package LLD.Airline;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Random;
import LLD.Airline.payment.*;
public class Aircraft{
    private String aircraftId;
    private String model;
    private Map<String,Boolean> seats;
    private Integer capacity;

    public Aircraft(String model, Integer capacity) {
        this.aircraftId = new Random().nextInt(1000)+"";
        this.model = model;
        this.seats = new ConcurrentHashMap<>();
        this.capacity = capacity;
    }

    public Boolean bookSeat(String seatId){
        if(seats.containsKey(seatId)){
            if(seats.get(seatId)){
                seats.put(seatId,false);
                System.out.println("Seat booked successfully "+seatId  );
                return true;
            }
        }
        return false;
    }


    public Boolean cancelSeat(String seatId){
        if(seats.containsKey(seatId)){
            if(!seats.get(seatId)){
                seats.put(seatId,true);
                System.out.println("Seat cancelled successfully "+seatId  );
                return true;
            }
        }
        System.out.println("Seat not booked "+seatId  );
        return false;
    }

    public void addSeat(String seatId){
        seats.put(seatId,true);
    }

    public String getAircraftId(){
        return aircraftId;
    }

    public void getAircraftDetails(){
        System.out.println("Aircraft Id: "+aircraftId);
        System.out.println("Model: "+model);
        System.out.println("Capacity: "+capacity);
    }

}