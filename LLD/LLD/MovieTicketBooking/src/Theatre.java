import java.util.Random;

public class Theatre {
    private String city;
    private String name;
    private String id;
    public Theatre(String name, String city){
        this.name = name;
        this.city = city;
        this.id = ""+new Random().nextInt(1000);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }
}
