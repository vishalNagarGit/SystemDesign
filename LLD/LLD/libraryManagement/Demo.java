package LLD.librarymanagement;

public class Demo{
    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.addBook("100", "LLD", 1,1);
        librarySystem.addBook("101", "HLD", 2,2);

        User user1 = new User("vishal","abc@gmail.com","3423948","hyderabad");
        User user2 = new User("ajay","aaf@fmal.com","3423948","hyderabad");
        Account account1 = new Account("1","123",user1);
        Account account2 = new Account("2","421",user2);

        librarySystem.addAccount(account1);
        librarySystem.addAccount(account2);
        

        librarySystem.borrow("1","100",1);
        librarySystem.borrow("2","100",1);
        System.out.println("fine for user 1: "+librarySystem.getFineAmount("1"));
        librarySystem.submit("1",0,10);
        System.out.println("fine for user 1: "+librarySystem.getFineAmount("1"));
        librarySystem.borrow("2","100",1);
    }
}