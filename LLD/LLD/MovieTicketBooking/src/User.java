import java.util.Random;

public class User {
    private String name;
    private String id;

    public User(String name){
        this.name = name;
        this.id = ""+new Random().nextInt(1000);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
