package fintech.model;

/**
 * @author 12S23029 Sintong Hutapea
 * @author 12S23038 Alya Triswani
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private static int transactionCount = 0;

    private int id;
    private String accountName;
    private double amount;
    private Date postedAt;
    private String note;
    private double balance;

    public Transaction(Account account, double amount, String postedAt, String note) {
        this.id = ++transactionCount;
        this.accountName = account.getAccountName(); 
        this.amount = amount;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            this.postedAt = dateFormat.parse(postedAt);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.note = note;

        account.addBalance(amount); 
        this.balance = account.getBalance(); 
    }

    public int getId() {
        return id;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getAmount() {
        return amount;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public String getNote() {
        return note;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return id + "|" + accountName + "|" + amount + "|" +
                new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(postedAt) + "|" +
                (note != null ? note : "") + "|" + balance;
    }
}
