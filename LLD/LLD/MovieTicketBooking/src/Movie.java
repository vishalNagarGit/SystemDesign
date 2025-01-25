import java.util.Random;

public class Movie {
    private String name;
    private double duration;
    private String description;
    private String releaseDate;
    private String id;
    public Movie(String name, Double duration, String description, String releaseDate){
        this.name = name;
        this.duration = duration;
        this.description = description;
        this.releaseDate = releaseDate;
        this.id = ""+new Random().nextInt(1000);
    }

    public double getDuration() {
        return duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getId(){
        return id;
    }
}

