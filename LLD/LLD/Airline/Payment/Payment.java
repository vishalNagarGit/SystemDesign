package LLD.Airline.payment;

public interface Payment {
    public Boolean makePayment(double amount);
    public Boolean refundPayment(double amount);
    public String getPaymentId();
}