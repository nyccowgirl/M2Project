import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.math.BigDecimal.valueOf;

public class Driver {

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("$#,##0.00");

        // BANK SETUP & TESTS
        System.out.println("BANK CLASS TESTS:\n");

        List<Bank> branchList = new ArrayList<>();

        Bank branch1 = Corporate.getCorp();                                                     // M2 HOMEWORK ENUM USE
        Bank branch2 = new Bank("Branch 789", "Vatican City");
        Bank branch3 = new Bank("Branch 654", "Machu Picchu");

        System.out.println("Is branch 1 the same as branch 3? " + branch1.equals(branch2));
        System.out.println();

        branchList.add(branch3);
        branchList.add(branch2);
        branchList.add(branch1);

        // comparesTo Test
        Collections.sort(branchList);
        System.out.println("SORTED by bank ID number: ");

        for (Bank branch: branchList) {
            System.out.println(branch);
        }

        // CLIENT SETUP & TESTS
        System.out.println("\n\nCLIENT CLASS TESTS:\n");

        List<Client> clientList = new ArrayList();

        Client client1 = new Client.Builder("the Wizard", "Timbuktu")   // M3 USING BUILDER
                .branch(branch2)
                .build();
        Client client2 = new Client.Builder("Monroe", "Marilyn")        // M3 USING BUILDER
                .branch(branch3)
                .build();
        Client client3 = new Client.Builder("Squarepants", "Spongebob") // M3 USING BUILDER
                .branch(branch2)
                .build();
        Client client4 = new Client.Builder("Ass","Dumb")               // M3 USING BUILDER
                .clientAddress("Lost City of Atlantis")
                .branch(branch1)
                .build();
        Client client5 = new Client.Builder("Lincoln", "Honest Abe")    // M3 USING BUILDER
                .clientAddress("Lincoln Memorial")
                .branch(branch1)
                .build();

        // equals Test
        System.out.println("Is client 3 the same as client 2? " + client3.equals(client2));
        System.out.println("Is client 3 the same as client 4? " + client3.equals(client4));
        System.out.println("Is client 5 the same as client 5? " + client5.equals(client5));
        System.out.println();

        client4.setClientFirstName("Goldilocks");

        clientList.add(client1);
        clientList.add(client2);
        clientList.add(client3);
        clientList.add(client4);
        clientList.add(client5);

        // compareTo Test
        Collections.sort(clientList);
        System.out.println("SORTED by client last name, then by client first name:");

        for (Client client: clientList) {
            System.out.println(client);
        }

        // Comparator Test
        Collections.sort(clientList, new Client.SortByClientID());                              // M3 USING COMPARATOR
        System.out.println("\nSORTED by client ID:");

        for (Client client: clientList) {
            System.out.println(client);
        }

        Collections.sort(clientList, new Client.SortByFirstName());                             // M3 USING COMPARATOR
        System.out.println("\nSORTED by client first name:");

        for (Client client: clientList) {
            System.out.println(client);
        }

        // ACCOUNT SETUP & TESTS
        System.out.println("\n\nACCOUNT CLASS TESTS:");

        List<Account> accountList = new ArrayList<>();

        Checking checkAcct1 = new Checking.Builder(client1)                                            // M3 USING BUILDER
//                .accountNo()
                .accountName()
//                .client(client1)
                .balance(valueOf(5500.5))
                .build();
        client1.addAccount(checkAcct1);
        Savings savingsAcct1 = new Savings.Builder(client2)                                            // M3 USING BUILDER
//                .accountNo()
                .accountName()
//                .client(client2)
                .balance(valueOf(10000))
                .open(LocalDate.now())
                .build();
        client2.addAccount(savingsAcct1);
        Credit creditAcct1 = new Credit.Builder(client3)                                               // M3 USING BUILDER
//                .accountNo()
                .accountName()
//                .client(client3)
                .balance(valueOf(-900))
                .maturityDate(LocalDate.of(2025, 12, 31))
                .build();
        client3.addAccount(creditAcct1);
        Credit creditAcct2 = new Credit.Builder(client4)                                               // M3 USING BUILDER
//                .accountNo()
                .accountName()
//                .client(client4)
                .balance(valueOf(-2500))
                .creditLine(valueOf(5000))
                .build();
        client4.addAccount(creditAcct2);
        Savings savingsAcct2 = new Savings.Builder(client4)                                            // M3 USING BUILDER
//                .accountNo()
                .accountName()
//                .client(client4)
                .balance(valueOf(5000))
                .build();
        client4.addAccount(savingsAcct2);
        Checking checkingAcct2 = new Checking.Builder(client3)                                         // M3 USING BUILDER
//                .accountNo()
                .accountName()
//                .client(client3)
                .joint(true)
                .jointClient(client5)
                .open(LocalDate.of(1998, 12, 24))
                .build();
        client3.addAccount(checkingAcct2);
        client2.addAccount(AccountType.CHECKING, client2);                                      // M3 USING FACTORY
        client3.addAccount(AccountType.SAVINGS, client3, BigDecimal.valueOf(7777));             // M3 USING FACTORY                                     // M3 USING FACTORY


        System.out.println(creditAcct1);
//        savingsAcct2.suspend();
//        creditAcct1.setClose(LocalDate.now());
//        checkingAcct2.setClose(LocalDate.now());
//
//        // Factory Test
//        System.out.println("\nAccount listing for Client 3:\n");                                  // M3 USING FACTORY
//        for (Account a: client3.getAccountList()) {
//            System.out.println(a);
//        }
//
//        accountList.add(checkAcct1);
//        accountList.add(checkingAcct2);
//        accountList.add(savingsAcct1);
//        accountList.add(savingsAcct2);
//        accountList.add(creditAcct1);
//        accountList.add(creditAcct2);
//
//        for (Account account: accountList) {
//            if (account instanceof Checking) {
//                Checking checking = (Checking) account;
//                System.out.println("\nThe current account no. " + checking.getAccountNo() + " is a Checking account.");
//
//                System.out.println("Current balance on your checkingAccount: " + checking.getBalance());
//                BigDecimal withdraw = new BigDecimal("1000.99");
//                System.out.println("Withdrawal amount: " + withdraw + ". Withdrawing...");
//                checking.withdrawal(withdraw);
//                System.out.println("Current balance of checking Account: " + checking.getBalance());
//            }
//
//            if (account instanceof Credit) {
//                Credit credit = (Credit) account;
//                System.out.println("\n\nThe current account no. " + credit.getAccountNo()  + " is a Credit account.");
//
//                System.out.println("Following Credit accounts:\n " + credit + "\n\n and :\n\n " + creditAcct1);
//
//                if (credit.equals(creditAcct1)) {
//                    System.out.println("\nare equal." );
//                } else {
//                    System.out.println("\nare NOT equal." );
//                }
//            }
//
//            if (account instanceof Savings)
//            {
//                Savings savings = (Savings) account;
//                BigDecimal depo = new BigDecimal("1000.00");
//                System.out.println("\n\nThe current account no. " + savings.getAccountNo()  + " is a Savings account.");
//
//                System.out.println("Savings account balance: "  + savings.getBalance() + " before deposit.");
//                savings.deposit(depo);
//                System.out.println("Savings balance after $" + depo + ": " + savings.getBalance());
//            }
//        }
//
//        // compareTo Test
//        Collections.sort(accountList, Collections.reverseOrder());
//
//        System.out.println("\nSORTED by account balance in reverse order, then by open date:");
//        for (Account account: accountList) {
//            System.out.println(account);
//            System.out.println();
//        }
//
//        // Static Variables Tests
//        System.out.println("Total Number of Banks: " + Bank.getTotalBanks());                       // M2 HOMEWORK STATIC
//        System.out.println("Total Number of Clients: " + Client.getTotalClients());                 // M2 HOMEWORK STATIC
//        System.out.println("Total Number of Accounts: " + Account.getTotalAccounts());              // M2 HOMEWORK STATIC
//        System.out.println("Total Checking Balances: " + df.format(Checking.getTotalCheckingBalances())); // M2 HOMEWORK STATIC
//        System.out.println("Total Savings Balances: " + df.format(Savings.getTotalSavingsBalance())); // M2 HOMEWORK STATIC
//        System.out.println("Total Credit Balances: " + df.format(Credit.getTotalCreditUtilization().negate())); // M2 HOMEWORK STATIC
//        System.out.println("Total Available Credit: " + df.format(Credit.totalCreditAvailable()));  // M2 HOMEWORK STATIC
    }
}
