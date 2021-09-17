import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.math.BigDecimal.valueOf;

public class Driver {

    public static void main(String[] args) throws TypeNotPresentException {

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

        Checking checkAcct1 = new Checking.Builder(client1)                                         // M3 USING BUILDER
                .accountName()
                .balance(valueOf(5500.5))
                .build();
        client1.addAccount(checkAcct1);                                                             // M3 USING FACTORY
        Savings savingsAcct1 = new Savings.Builder(client2)                                         // M3 USING BUILDER
                .accountName()
                .balance(valueOf(10000))
                .open(LocalDate.now())
                .build();
        client2.addAccount(savingsAcct1);                                                           // M3 USING FACTORY
        Credit creditAcct1 = new Credit.Builder(client3)                                            // M3 USING BUILDER
                .accountName()
                .balance(valueOf(-900))
                .maturityDate(LocalDate.of(2025, 12, 31))
                .build();
        client3.addAccount(creditAcct1);                                                            // M3 USING FACTORY
        Credit creditAcct2 = new Credit.Builder(client4)                                            // M3 USING BUILDER
                .accountName()
                .balance(valueOf(-2500))
                .creditLine(valueOf(5000))
                .build();
        client4.addAccount(creditAcct2);                                                            // M3 USING FACTORY
        Savings savingsAcct2 = new Savings.Builder(client4)                                         // M3 USING BUILDER
                .accountName()
                .balance(valueOf(5000))
                .build();
        client4.addAccount(savingsAcct2);                                                           // M3 USING FACTORY
        Checking checkingAcct2 = new Checking.Builder(client3)                                      // M3 USING BUILDER
                .accountName()
                .joint(true)
                .jointClient(client5)
                .open(LocalDate.of(1998, 12, 24))
                .build();
        client3.addAccount(checkingAcct2);                                                          // M3 USING FACTORY

        savingsAcct2.suspend();
        creditAcct1.setClose(LocalDate.now());
        checkingAcct2.setClose(LocalDate.now());

        // Factory Test
        client2.addAccount(AccountType.CHECKING, client2);                                          // M3 USING FACTORY
        client3.addAccount(AccountType.SAVINGS, client3, BigDecimal.valueOf(7777));                 // M3 USING FACTORY                                     // M3 USING FACTORY

        client3.printAccounts();

        System.out.println("\nAccount Details for Client #3:\n");
        for (Account a: client3.getAccountList()) {
            System.out.println(a);
        }

        // Other Tests (From M1 Homework)
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

        savingsAcct2.reactivate();

        // compareTo Test
        Collections.sort(accountList, Collections.reverseOrder());

        System.out.println("\nSORTED by account balance in reverse order, then by open date:");
        for (Account account: accountList) {
            System.out.println(account);
            System.out.println();
        }

        // Strategy Tests
        System.out.println("Processing transactions for Account #1:");
        checkAcct1.printBalance();
        System.out.println("Earn interest of 6%:");
        checkAcct1.addInterest(BigDecimal.valueOf(.06));                                            // M3 USING STRATEGY
        checkAcct1.printBalance();
        System.out.println("Charge overdraft fees of $5:");
        checkAcct1.subtractFees(BigDecimal.valueOf(5));                                             // M3 USING STRATEGY
        checkAcct1.printBalance();
        System.out.println("Earn signing bonus of $50:");
        checkAcct1.addBonus(BigDecimal.valueOf(50));                                                // M3 USING STRATEGY
        checkAcct1.printBalance();
        System.out.println();

        System.out.println("Processing transactions for Account #4:");
        checkAcct1.printBalance();
        System.out.println("Earn interest of 6% (negative balance so no interest should be earned):");
        creditAcct2.addInterest(BigDecimal.valueOf(.06));                                            // M3 USING STRATEGY
        checkAcct1.printBalance();
        System.out.println();

        // Static Variables Tests (BEFORE USER INPUT FACTORY TESTS)
        System.out.println("Total Number of Banks: " + Bank.getTotalBanks());                       // M2 HOMEWORK STATIC
        System.out.println("Total Number of Clients: " + Client.getTotalClients());                 // M2 HOMEWORK STATIC
        System.out.println("Total Number of Accounts: " + Account.getTotalAccounts());              // M2 HOMEWORK STATIC
        System.out.println("Total Checking Balances: " + df.format(Checking.getTotalCheckingBalances())); // M2 HOMEWORK STATIC
        System.out.println("Total Savings Balances: " + df.format(Savings.getTotalSavingsBalance())); // M2 HOMEWORK STATIC
        System.out.println("Total Credit Balances: " + df.format(Credit.getTotalCreditUtilization().negate())); // M2 HOMEWORK STATIC
        System.out.println("Total Available Credit: " + df.format(Credit.totalCreditAvailable()));  // M2 HOMEWORK STATIC

        // Factory Tests - User Input:

        Scanner scan = new Scanner(System.in);

        boolean add = false;
        do {
            System.out.print("Enter the client ID # (1-5): ");
            int choice1 = Integer.parseInt(scan.nextLine());
            Client client = null;

            switch (choice1) {
                case 1: client = client1;
                        break;
                case 2: client = client2;
                        break;
                case 3: client = client3;
                        break;
                case 4: client = client4;
                        break;
                case 5: client = client5;
                        break;
                default: throw new IllegalArgumentException("Client does not exist. Setup new client or enter 1-5.");
            }

            System.out.print("Enter 1 for Checking, 2 for Savings or 3 for Credit account: ");
            int choice2 = Integer.parseInt(scan.nextLine());
            AccountType type = AccountType.NOT_APPLICABLE;
            boolean overdraft = false;
            int term = 0;
            BigDecimal creditLine = new BigDecimal(0);

            switch (choice2) {
                case 1: type = AccountType.CHECKING;
                        System.out.print("Does this account have overdraft protection? (Y/N) ");
                        String choice5 = scan.nextLine();
                        if (choice5.equalsIgnoreCase("Y")) {
                            overdraft = true;
                        }
                        break;
                case 2: type = AccountType.SAVINGS;
                        break;
                case 3: type = AccountType.CREDIT;
                        System.out.print("Enter the term (in years): ");
                        term = Integer.parseInt(scan.nextLine());
                        System.out.print("Enter the credit line: ");
                        creditLine = scan.nextBigDecimal();
                        scan.nextLine();
                        break;
                default: throw new IllegalArgumentException("Not a valid input. Enter 1-3.");
            }

            System.out.print("Is this a joint account? (Y/N) ");
            String choice3 = scan.nextLine();
            boolean joint = false;
            Client jointClient = null;

            if (choice3.equalsIgnoreCase("Y")) {
                joint = true;
                System.out.print("Enter client ID # for joint holder (1-5): ");
                int choice4 = Integer.parseInt(scan.nextLine());

                switch (choice4) {
                    case 1: if (client.getClientId() != 1) {
                        jointClient = client1;
                    }
                        break;
                    case 2: if (client.getClientId() != 2) {
                        jointClient = client2;
                    }
                        break;
                    case 3: if (client.getClientId() != 3) {
                        jointClient = client3;
                    }
                        break;
                    case 4: if (client.getClientId() != 4) {
                        jointClient = client4;
                    }
                        break;
                    case 5: if (client.getClientId() != 5) {
                        jointClient = client5;
                    }
                        break;
                    default: throw new IllegalArgumentException("Either client does not exist or is the main account " +
                            "holder. Setup new client or enter 1-5.");
                }
            }

            System.out.print("Enter the starting balance (input credit balance as negative): ");
            BigDecimal balance = scan.nextBigDecimal();
            scan.nextLine();

            client.addAccount(type, client, balance, joint, jointClient, overdraft, LocalDate.now().plusYears(term),
                    creditLine);                                                                // M3 USING FACTORY

            System.out.print("Would you like to add another account? (Y/N) ");
            String again = scan.nextLine();
            if (again.equalsIgnoreCase("Y")) {
                add = true;
            } else {
                add = false;
            }

        } while (add);

        // Static Variables Tests (POST USER INPUT FACTORY TESTS)
        System.out.println("Total Number of Banks: " + Bank.getTotalBanks());                       // M2 HOMEWORK STATIC
        System.out.println("Total Number of Clients: " + Client.getTotalClients());                 // M2 HOMEWORK STATIC
        System.out.println("Total Number of Accounts: " + Account.getTotalAccounts());              // M2 HOMEWORK STATIC
        System.out.println("Total Checking Balances: " + df.format(Checking.getTotalCheckingBalances())); // M2 HOMEWORK STATIC
        System.out.println("Total Savings Balances: " + df.format(Savings.getTotalSavingsBalance())); // M2 HOMEWORK STATIC
        System.out.println("Total Credit Balances: " + df.format(Credit.getTotalCreditUtilization().negate())); // M2 HOMEWORK STATIC
        System.out.println("Total Available Credit: " + df.format(Credit.totalCreditAvailable()));  // M2 HOMEWORK STATIC
    }
}
