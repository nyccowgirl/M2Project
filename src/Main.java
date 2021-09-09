import java.time.LocalDate;

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
        Credit creditAcct1 = new Credit(-777.00, client3);

        System.out.println(creditAcct1);
        System.out.println(savingsAcct1);
        System.out.println(checkAcct1);


        // DRIVER PROGRAM
        Account[] childrenAccounts = new Account[10];
        childrenAccounts[0] = checkAcct1;
        childrenAccounts[1] = savingsAcct1;
        childrenAccounts[2] = creditAcct1;
        for (int i = 0; i < childrenAccounts.length; i++)
        {
            if (childrenAccounts[i] instanceof Checking)
            {
                Checking checkingAcc = (Checking) childrenAccounts[i];
                System.out.println("\n\nThe current array member " + i  + ": is of type of Checking account ");

                if (!checkingAcc.isOverdraftProtection())
                {
                    System.out.println("Current balance on your checkingAccount: " + checkingAcc.getBalance());
                    double withdrawalAmount = -1000000000.99;
                    System.out.println("Withdrawal amount: " + withdrawalAmount + ". Withdrawing...");
                    checkingAcc.withdrawal(withdrawalAmount);
                    System.out.println("Current balance of checking Account: " + checkingAcc.getBalance());
                }
            }

            if (childrenAccounts[i] instanceof Credit)
            {
                Credit creditAcc = (Credit) childrenAccounts[i];
                System.out.println("\n\nThe current array member " + i  + ": is of type of Credit account ");
                if (creditAcc.equals(childrenAccounts[i]))
                {
                    System.out.println("Following CreditAcc:\n " + creditAcc + "\n\n and array member:\n\n "
                            + childrenAccounts[i].toString() + "\n\nare equal." );
                }
            }

            if (childrenAccounts[i] instanceof Savings)
            {
                Savings savingsAcc = (Savings) childrenAccounts[i];
                System.out.println("\n\nThe current array member " + i  + ": is of type of Savings account ");

                System.out.println("Savings account balance: "  + savingsAcc.getBalance() + " before deposit.");
                savingsAcc.deposit(1000.00);
                System.out.println("Savings balance after 1000.00 deposit : " + savingsAcc.getBalance());
            }
        }
    }
}
