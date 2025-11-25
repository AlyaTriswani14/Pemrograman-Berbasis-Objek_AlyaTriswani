package fintech.driver;

/**
 * @author 12S23029 Sintong Hutapea
 * @author 12S23038 Alya Triswani
 */

import java.util.Scanner;
import fintech.model.Account;

public class Driver1 {

    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);
        String pilihan = input.nextLine();

        if (pilihan.equals("create-account")) {
            String owner = input.nextLine();
            String accountName = input.nextLine();
            Account account = new Account(accountName, owner);
            System.out.println(account.toString());
        }
        input.close();

    }
}
