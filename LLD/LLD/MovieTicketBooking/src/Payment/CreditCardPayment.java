package Payment;

public class CreditCardPayment implements IPaymentMethod{
    private String number;
    private String name;
    private String cvv;
    private String expDate;

    public CreditCardPayment(String number,String name,String cvv,String expDate){
        this.cvv=cvv;
        this.name   = name;
        this.expDate =  expDate;
        this.number = number;
    }

    @Override
    public boolean makePayment(double amount) {
        return true;
    }

    @Override
    public boolean refund(double amount) {
        return true;
    }
}
