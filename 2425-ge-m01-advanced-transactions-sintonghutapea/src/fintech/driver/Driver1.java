package fintech.driver;

import java.util.ArrayList;

/**
 * @author 12S23029 Sintong Hutapea
 * @author 12S23038 Alya Triswani
 */

import java.util.Scanner;
import java.util.ArrayList;
import fintech.model.Transaction;
import fintech.model.Account;
 
public class Driver1 {

    public static void main(String[] _args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList <Account> accounts = new ArrayList <>();
        ArrayList <Transaction> transactions = new ArrayList <>();

        boolean input = true;
 
        while(input){
            String command = scanner.nextLine().trim();
            if (command.equals("---")){
                input = true;
                break;
            }
                
            else if (command.equals("create-account")) {
                String[] parts = command.split("#");
                if (parts.length ==3){
                    String owner = parts[1].trim();
                    String accountName = parts[2].trim();
                    Account account = new Account(accountName, owner);  
                    accounts.add(account);
                }
            }
    
            else if (command.equals("create-transaction")) {
                String[] parts = command.split("#");
                String accountName = parts[1].trim();
                double amount = Double.parseDouble(parts[2].trim());
                String postedAt = parts[3].trim();
                String note = parts[4].trim();

                Account account = null;
                for (Account acc : accounts){
                    if (acc.getAccountName().equals(accountName)){
                        account = acc;
                        break;
                    }
                }
                if (account != null){
                    Transaction transaction = new Transaction(account, amount, postedAt, note);
                    transactions.add(transaction);
                }
            }

            else if (command.equals("show-account")) {
                String[] parts = command.split("#");
                String accountName = parts[1].trim();
                
                Account account = null;
                for (Account acc : accounts){
                    if (acc.getAccountName().equals(accountName)){
                        account = acc;
                        break;
                    }
                }
                if (account != null){
                    System.out.println(account.toString());
                }
            }
        }
        for (Account account : accounts){
            if (account.getBalance() == 0.0){
                System.out.println(account.toString());
            }
        }

        for (Transaction transaction : transactions){
                System.out.println(transaction.toString());
        }

        for (Account account : accounts){
            if (account.getBalance() != 0.0){
                System.out.println(account.toString());
            }
        }
        scanner.close();
    }
}