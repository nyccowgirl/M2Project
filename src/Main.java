import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        // Test Client Class

        Client client1 = new Client("Ali", "San Francisco");
        Client client2 = new Client("Baba");
        Client client3 = new Client("Johny Cash");
        Client client4 = new Client("Joye","Belmont");
        System.out.println(client1);
        System.out.println("Client3.equals(Client2)= " + client3.equals(client2));
        System.out.println("Client3.equals(Client4)= " +client3.equals(client4));


        // Test Bank Class

        Bank bank1=new Bank("Bank Of America","San Francisco");
        Bank bank2=new Bank("Chase");
        Bank bank3=new Bank("Wells Fargo");

        System.out.println(bank1);
        System.out.println("Bank3.equals(Bank2)= " + bank3.equals( bank2));
        System.out.println("Bank3.equals(Bank1)= " + bank3.equals(bank1));


        // Test automated account number assignment

        Checking checkAcct1 = new Checking(client1, 5500);
        Savings savingsAcct1 = new Savings(client2, 10000, LocalDate.now());
        Credit creditAcct1 = new Credit(10000.00, client3);
        Credit creditAcct2 = new Credit(client4, -2500, 5000);
        Savings savingsAcct2 = new Savings(client4, 5000);

//        System.out.println(creditAcct1);
//        System.out.println(savingsAcct1);
//        System.out.println(checkAcct1);


        // DRIVER PROGRAM
        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(checkAcct1);
        accountList.add(savingsAcct1);
        accountList.add(creditAcct1);
        accountList.add(creditAcct2);
        accountList.add(savingsAcct2);

        for (Account account: accountList) {
            if (account instanceof Checking)
            {
                Checking checkingAcc = (Checking) account;
                System.out.println("\n\nThe current account no. " + checkingAcc.getAccountNo() + " is a Checking account.");

                if (!checkingAcc.isOverdraftProtection())
                {
                    System.out.println("Current balance on your checkingAccount: " + checkingAcc.getBalance());
                    double withdrawalAmount = 1000000000.99;
                    System.out.println("Withdrawal amount: " + withdrawalAmount + ". Withdrawing...");
                    checkingAcc.withdrawal(withdrawalAmount);
                    System.out.println("Current balance of checking Account: " + checkingAcc.getBalance());
                }
            }

            if (account instanceof Credit)
            {
                Credit creditAcc = (Credit) account;
                System.out.println("\n\nThe current account no. " + creditAcc.getAccountNo()  + " is a Credit account.");

                System.out.println("Following Credit accounts:\n " + creditAcc + "\n\n and :\n\n " + creditAcct1);

                if (creditAcc.equals(creditAcct1))
                {
                    System.out.println("\n\nare equal." );
                } else {
                    System.out.println("\n\nare NOT equal." );
                }
            }

            if (account instanceof Savings)
            {
                Savings savingsAcc = (Savings) account;
                System.out.println("\n\nThe current account no. " + savingsAcc.getAccountNo()  + " is a Savings account.");

                System.out.println("Savings account balance: "  + savingsAcc.getBalance() + " before deposit.");
                savingsAcc.deposit(1000.00);
                System.out.println("Savings balance after 1000.00 deposit : " + savingsAcc.getBalance());
            }
        }

        Collections.sort(accountList);
//        System.out.println(accountList);

        // TO DO: Not sorting correctly!!!

        System.out.println("\nSORT:");
        for (Account account: accountList) {
            System.out.println(account);
            System.out.println("");
        }
    }
}
