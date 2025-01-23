package LLD.librarymanagement;

import java.util.concurrent.ConcurrentHashMap;

public class Catalog{
    public ConcurrentHashMap<String, Book> Books;
    Catalog(){
        Books = new ConcurrentHashMap<String, Book>();
    }

    public Book searchByTitle(String title){
        for(Book book : Books.values()){
            if(book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }

    public Book searchByISBN(String ISBN){
        return Books.get(ISBN);
    }

    public synchronized void addBook(String ISBN, String title, int numberOfCopies, int availableCopies){
        if(Books.containsKey(ISBN)){
            System.out.println("Book already exists in the catalog");
            return;
        }
        Books.put(ISBN, new Book(ISBN, title, numberOfCopies, availableCopies));
    }

    public synchronized void removeBook(String ISBN){
        if(Books.containsKey(ISBN)){
            Books.remove(ISBN);
        }else{
            System.out.println("Book not found in the catalog");
        }
    }

    public synchronized void updateBook(String ISBN, String title, String author, int numberOfCopies, int availableCopies){
        if(Books.containsKey(ISBN)){
            Books.put(ISBN, new Book(ISBN, title, numberOfCopies, availableCopies));
        }else{
            System.out.println("Book not found in the catalog");
        }
    }
}