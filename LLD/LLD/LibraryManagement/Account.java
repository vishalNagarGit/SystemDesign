package LLD.librarymanagement;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Map;
public class Account {
  private String id;
  private String password;
  private User user;
  private Map<Integer,Borrowing>borrowings;
  private ArrayList<Log> logs;
  private Map<Integer,Fine>  fines;

  public Account(String id, String password, User user) {
    this.id = id;
    this.password = password;
    this.user = user;
    borrowings = new ConcurrentHashMap<>();
    logs = new ArrayList<>();
    fines = new ConcurrentHashMap<>();
  }

    // Getters
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public User getUser() {
        return user;
    }

    public Map<Integer,Borrowing> getBorrowings() {
        return borrowings;
    }

    public ArrayList<Log> getLogs() {
        return logs;
    }

    public Map<Integer,Fine> getFines() {
        return fines;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addBorrowing(Borrowing borrowing) {
        this.borrowings.put(borrowing.getId(),borrowing);
    }

    public void  addLog(Log log) {
        this.logs.add(log);
    }


    public void addFine(Fine fine) {
        this.fines.put(fine.getBorrowing().getId(),fine);
    }

    public void updateFine(Fine fine) {
        this.fines.put(fine.getBorrowing().getId(),fine);
    }

}