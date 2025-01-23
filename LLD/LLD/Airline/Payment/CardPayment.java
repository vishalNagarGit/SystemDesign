package LLD.Airline.payment;
import java.util.Random;
public class CardPayment implements Payment {
    private String cardNumber;
    private String name;
    private String expiry;
    private String cvv;
    private String paymentMethodId;

    public CardPayment(String cardNumber, String name, String expiry, String cvv) {
        this.cardNumber = cardNumber;
        this.paymentMethodId = new Random().nextInt(1000) + "";
        this.name = name;
        this.expiry = expiry;
        this.cvv = cvv;
    }

    @Override
    public Boolean makePayment(double amount) {
        return true;
    }

    @Override
    public Boolean refundPayment(double amount) {
        return true;
    }

    public String getPaymentId() {
        return paymentMethodId;
    }

}