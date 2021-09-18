import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountFactory {

    public static Account newAccount(AccountType type, String accountName, Client client, BigDecimal balance,
                                     boolean joint, Client jointClient, boolean overdraft, LocalDate maturityDate,
                                     BigDecimal creditLine) {
        Account a = null;

        switch (type) {
            case CHECKING -> addChecking(accountName, client, balance, joint, jointClient, overdraft);
            case SAVINGS -> addSavings(accountName, client, balance, joint, jointClient);
            case CREDIT -> addCredit(accountName, client, balance, joint, jointClient, maturityDate, creditLine);
            case NOT_APPLICABLE -> System.out.println("Not a valid account type.");
            default -> throw new IllegalArgumentException("Unexpected value: " + type);
        }

        return a;
    }

    public static Account newAccount(AccountType type, Client client) {

        Account a = null;

        switch (type) {
            case CHECKING -> a = new Checking.Builder(client).build();
            case SAVINGS -> a = new Savings.Builder(client).build();
            case CREDIT -> a = new Credit.Builder(client).build();
            case NOT_APPLICABLE -> System.out.println("Not a valid account type.");
            default -> throw new IllegalArgumentException("Unexpected value: " + type);
        }

        return a;
    }

    public static Account newAccount(AccountType type, Client client, BigDecimal balance) {

        Account a = null;

        switch (type) {
            case CHECKING -> a = new Checking.Builder(client).balance(balance).build();
            case SAVINGS -> a = new Savings.Builder(client).balance(balance).build();
            case CREDIT -> a = new Credit.Builder(client).balance(balance).build();
            case NOT_APPLICABLE -> System.out.println("Not a valid account type.");
            default -> throw new IllegalArgumentException("Unexpected value: " + type);
        }

        return a;
    }

    public static Account addChecking(String accountName, Client client, BigDecimal balance, boolean joint,
                                      Client jointClient, boolean overdraft) {
        return new Checking.Builder(client)
                .accountName(accountName)
                .balance(balance)
                .joint(joint)
                .jointClient(jointClient)
                .overdraftProtection(overdraft)
                .build();
    }

    public static Account addSavings(String accountName, Client client, BigDecimal balance, boolean joint,
                                     Client jointClient) {
        return new Savings.Builder(client)
                .accountName(accountName)
                .balance(balance)
                .joint(joint)
                .jointClient(jointClient)
                .build();
    }

    public static Account addCredit(String accountName, Client client, BigDecimal balance, boolean joint,
                                    Client jointClient, LocalDate maturityDate, BigDecimal creditLine) {
        return new Credit.Builder(client)
                .accountName(accountName)
                .balance(balance)
                .joint(joint)
                .jointClient(jointClient)
                .maturityDate(maturityDate)
                .creditLine(creditLine)
                .build();
    }

}
