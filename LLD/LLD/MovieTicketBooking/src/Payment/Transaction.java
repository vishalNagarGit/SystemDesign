package Payment;

import Types.TransactionStatus;

import java.util.Random;

public class Transaction {
    private TransactionStatus transactionStatus;
    private IPaymentMethod payment;
    private String transactionId;
    private double amount;
    public Transaction(TransactionStatus ts,IPaymentMethod pm,Double amount){
        this.transactionStatus = ts;
        this.payment = pm;
        this.transactionId = ""+new Random().nextInt(100);
        this.amount = amount;
    }

    public void execute() {
        if(payment.makePayment(amount)) transactionStatus  = TransactionStatus.Success;
        else transactionStatus = TransactionStatus.Failed;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public double getAmount() {
        return amount;
    }

    public IPaymentMethod getPayment() {
        return payment;
    }
}
