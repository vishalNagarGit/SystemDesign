package LLD.librarymanagement;

public class Book{
    private String ISBN;
    private String title;
    private int numberOfCopies;
    private int availableCopies;
    
    public Book(String ISBN, String title, int numberOfCopies, int availableCopies) {
        this.ISBN = ISBN;
        this.title = title;
        this.numberOfCopies = numberOfCopies;
        this.availableCopies = availableCopies;
    }
    
    // Getters
    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }


    public int getAvailableCopies() {
        return availableCopies;
    }

    // Setters  
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
}