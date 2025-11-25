package fintech.driver;

/**
 * @author 12S23029 Sintong Hutapea
 * @author 12S23038 Alya Triswani
 */

 import java.util.Scanner;
 import fintech.model.Transaction;
 import fintech.model.Account;
 
 public class Driver2 {
 
     public static void main(String[] _args) {
         Scanner scanner = new Scanner(System.in);
         Account account = null;
 
         String command = scanner.nextLine().trim();
         if (command.equals("create-account")) {
             String owner = scanner.nextLine().trim();
             String accountName = scanner.nextLine().trim();
             account = new Account(accountName, owner);  // Fix: pass the correct order of arguments
         }
 
         if (account != null) {
             command = scanner.nextLine().trim();
             if (command.equals("create-transaction")) {
                 String accountName = scanner.nextLine().trim();
                 double amount = Double.parseDouble(scanner.nextLine().trim());
                 String postedAt = scanner.nextLine().trim();
                 String note = scanner.nextLine().trim();
                 
                 System.out.println(account.toString());
                 Transaction transaction = new Transaction(account, amount, postedAt, note);  
                 System.out.println(transaction.toString()); // This will show the transaction details
             }
         }
         scanner.close();
     }
 }
 