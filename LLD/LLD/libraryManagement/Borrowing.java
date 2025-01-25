package LLD.librarymanagement;


public class Borrowing {
    private String isbn;
    private int date;
    private int id;

    public Borrowing(int id,String isbn, int date) {
        this.isbn = isbn;
        this.date = date;
        this.id = id;
    }

    // Getters

    public String getIsbn() {
        return isbn;
    }

    public int getDate() {
        return date;
    }

    public int getId() {
        return id;
    }
}