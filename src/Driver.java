import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Driver {

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("$#,##0.00");

        // BANK SETUP & TESTS
        System.out.println("BANK CLASS TESTS:\n");

        ArrayList<Bank> branchList = new ArrayList<>();

        Bank branch1 = new Bank(Corporate.CORPORATE.name(), Corporate.CORPORATE.getAddress());  // M2 HOMEWORK ENUM USE
        Bank branch2 = new Bank("Branch 789", "Vatican City");
        Bank branch3 = new Bank("Branch 654", "Machu Picchu");

        System.out.println("Is branch 1 the same as branch 3? " + branch1.equals(branch2));
        System.out.println();

        branchList.add(branch3);
        branchList.add(branch2);
        branchList.add(branch1);

        Collections.sort(branchList);

        System.out.println("Sorted by bank ID number: ");

        for (Bank branch: branchList) {
            System.out.println(branch);
        }

        // CLIENT SETUP & TESTS
        System.out.println("\n\nCLIENT CLASS TESTS:\n");

        ArrayList<Client> clientList = new ArrayList();

        Client client1 = new Client("Merlin", "Timbuktu", branch2);
        Client client2 = new Client("Marilyn Monroe", branch3);
        Client client3 = new Client("Spongebob Squarepants", branch2);
        Client client4 = new Client("Who's On First?","Lost City of Atlantis", branch1);
        Client client5 = new Client("Abe Lincoln", "Lincoln Memorial", branch1);

        System.out.println("Is client 3 the same as client 2? " + client3.equals(client2));
        System.out.println("Is client 3 the same as client 4? " + client3.equals(client4));
        System.out.println("Is client 5 the same as client 5? " + client5.equals(client5));
        System.out.println();

        client4.setClientName("Goldilocks");

        clientList.add(client1);
        clientList.add(client2);
        clientList.add(client3);
        clientList.add(client4);
        clientList.add(client5);

        Collections.sort(clientList);
        System.out.println("Sorted by client name, then by client address:");

        for (Client client: clientList) {
            System.out.println(client);
        }

        // ACCOUNT SETUP & TESTS
        System.out.println("\n\nACCOUNT CLASS TESTS:");

        ArrayList<Account> accountList = new ArrayList<>();

        Checking checkAcct1 = new Checking(client1, new BigDecimal(5500.5));
        Savings savingsAcct1 = new Savings(client2, new BigDecimal(10000), LocalDate.now());
        Credit creditAcct1 = new Credit(new BigDecimal("10000.00"), client3);
        Credit creditAcct2 = new Credit(client4, new BigDecimal(-2500), new BigDecimal(5000));
        Savings savingsAcct2 = new Savings(client4, new BigDecimal(5000));
        Checking checkingAcct2 = new Checking(client3, true, client5, LocalDate.of(1998, 12, 24));

        savingsAcct2.suspend();
        creditAcct1.setClose(LocalDate.now());
        checkingAcct2.setClose(LocalDate.now());

        accountList.add(checkAcct1);
        accountList.add(checkingAcct2);
        accountList.add(savingsAcct1);
        accountList.add(savingsAcct2);
        accountList.add(creditAcct1);
        accountList.add(creditAcct2);

        for (Account account: accountList) {
            if (account instanceof Checking) {
                Checking checking = (Checking) account;
                System.out.println("\nThe current account no. " + checking.getAccountNo() + " is a Checking account.");

                System.out.println("Current balance on your checkingAccount: " + checking.getBalance());
                BigDecimal withdraw = new BigDecimal("1000.99");
                System.out.println("Withdrawal amount: " + withdraw + ". Withdrawing...");
                checking.withdrawal(withdraw);
                System.out.println("Current balance of checking Account: " + checking.getBalance());
            }

            if (account instanceof Credit) {
                Credit credit = (Credit) account;
                System.out.println("\n\nThe current account no. " + credit.getAccountNo()  + " is a Credit account.");

                System.out.println("Following Credit accounts:\n " + credit + "\n\n and :\n\n " + creditAcct1);

                if (credit.equals(creditAcct1)) {
                    System.out.println("\nare equal." );
                } else {
                    System.out.println("\nare NOT equal." );
                }
            }

            if (account instanceof Savings)
            {
                Savings savings = (Savings) account;
                BigDecimal depo = new BigDecimal("1000.00");
                System.out.println("\n\nThe current account no. " + savings.getAccountNo()  + " is a Savings account.");

                System.out.println("Savings account balance: "  + savings.getBalance() + " before deposit.");
                savings.deposit(depo);
                System.out.println("Savings balance after $" + depo + ": " + savings.getBalance());
            }
        }

        Collections.sort(accountList, Collections.reverseOrder());

        System.out.println("\nSort by account balance in reverse order, then by open date:");
        for (Account account: accountList) {
            System.out.println(account);
            System.out.println();
        }

        System.out.println("Total Number of Banks: " + Bank.getTotalBanks());
        System.out.println("Total Number of Clients: " + Client.getTotalClients());
        System.out.println("Total Number of Accounts: " + Account.getTotalAccounts());
        System.out.println("Total Checking Balances: " + df.format(Checking.getTotalCheckingBalances()));
        System.out.println("Total Savings Balances: " + df.format(Savings.getTotalSavingsBalance()));
        System.out.println("Total Available Credit: " + df.format(Credit.totalCreditAvailable()));
    }
}
