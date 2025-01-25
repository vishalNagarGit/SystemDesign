package Payment;

public interface IPaymentMethod {
    boolean makePayment(double amount);
    boolean refund(double amount);
}
