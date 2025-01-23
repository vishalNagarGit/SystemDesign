package LLD.librarymanagement;
import LLD.librarymanagement.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
public class LibrarySystem{
    private Map<String,Account> accounts;
    private Catalog catalog;
    private int MAX_BOOKS_ISSUED_TO_A_USER = 1;
    private  int MAX_LENDING_DAYS =3;
    private  int FINE_PER_DAY = 5;
    public LibrarySystem() {
        accounts = new ConcurrentHashMap<>();
        catalog = new Catalog();
    }

    public boolean addAccount(Account account) {
        if(accounts.containsKey(account.getId())) {
            System.out.println("Account already exists");
        }
        accounts.put(account.getId(),account);
        return true;
    }

    public boolean removeAccount(String id) {
        if(accounts.containsKey(id)) {
            accounts.remove(id);
            return true;
        }
        System.out.println("Account not found");
        return false;
    }

    public boolean addBook(String ISBN, String title, int numberOfCopies, int availableCopies) {
        catalog.addBook(ISBN, title, numberOfCopies, availableCopies);
        return true;
    }

    public void borrow(String accountId, String ISBN, int date) {
        if(!accounts.containsKey(accountId)) {
            System.out.println("Account not found");
            return;
        }
        Account account = accounts.get(accountId);
        if(account. getBorrowings().size() >= MAX_BOOKS_ISSUED_TO_A_USER) {
            System.out.println("Already issued max number of books");
            return;
        }
        if(!catalog.Books.containsKey(ISBN)) {
            System.out.println("Book not found");
            return;
        }
        Book book = catalog.Books.get(ISBN);
        if(book.getAvailableCopies() == 0) {
            System.out.println("Book not available");
            return;
        }
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        Borrowing borrowing = new Borrowing(account.getBorrowings().size(),ISBN,date);
        account.addBorrowing(borrowing);
        System.out.println("Book borrowed successfully! Borrowing ID: " + borrowing.getId());
    }

    public void submit(String accountId,Integer borrowId, int date) {
        if(!accounts.containsKey(accountId)) {
            System.out.println("Account not found");
            return;
        }
        Account account = accounts.get(accountId);
        Borrowing borrowing = account.getBorrowings().get(borrowId);
        if(borrowing == null) {
            System.out.println("Book not borrowed");
            return;
        }
        int days = date - borrowing.getDate();
        if(days > MAX_LENDING_DAYS) {
            int fine = (days - MAX_LENDING_DAYS) * FINE_PER_DAY;
            Fine f = new Fine(borrowing, fine);
            account.addFine(f);
        }
        Book book = catalog.Books.get(borrowing.getIsbn());
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        account.getBorrowings().remove(borrowId);
    }

    public int getFineAmount(String accountId) {
        if(!accounts.containsKey(accountId)) {
            System.out.println("Account not found");
            return -1;
        }
        Account account = accounts.get(accountId);
        if(account.getFines().size() == 0) {
            System.out.println("No fines");
            return 0;
        }
        return account.getFines().get(0).getFineAmount();
    }

    public void payFine(String accountId, int fineAmount) {
        if(!accounts.containsKey(accountId)) {
            System.out.println("Account not found");
            return;
        }
        Account account = accounts.get(accountId);
        if(account.getFines().size() == 0) {
            System.out.println("No fines to pay");
            return;
        }
        Fine fine = account.getFines().get(0);
        if(fineAmount < fine.getFineAmount()) {
            System.out.println("Paid amount is less than fine amount");
            return;
        }
        fine.setPaid(true);
        account.getFines().remove(0);
    }
    
}