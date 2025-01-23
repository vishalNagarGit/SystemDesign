package LLD.librarymanagement;

public class Fine{
    private Borrowing borrowing;
    private int fineAmount;
    private boolean paid;

    public Fine(Borrowing borrowing, int fineAmount) {
        this.borrowing = borrowing;
        this.fineAmount = fineAmount;
        this.paid = false;
    }

    // Getters'
    public Borrowing getBorrowing() {
        return borrowing;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public boolean isPaid() {
        return paid;
    }

    // Setters

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }


    public void setBorrowing(Borrowing borrowing) {
        this.borrowing = borrowing;
    }

}