package fintech.model;

/**
 * @author 12S23029 Sintong Hutapea
 * @author 12S23038 Alya Triswani
 */


 public class Account {
 
     private String owner;
     private String accountName;
     private double balance;
 
     public Account(String owner, String accountName) {
         this.owner = owner;
         this.accountName = accountName;
         this.balance = 0.0;
     }
 
     public void addBalance(double amount) {
         this.balance += amount;
     }
 
     // Getter for accountName
     public String getAccountName() {
         return accountName;
     }
 
     // Getter for balance
     public double getBalance() {
         return balance;
     }
 
     @Override
     public String toString() {
         return owner + "|" + accountName + "|" + balance;
     }
 }
 