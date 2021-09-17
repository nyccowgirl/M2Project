import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountFactory {

    public static Account newAccount(AccountType type, Client client, BigDecimal balance, boolean joint,
                                     Client jointClient, boolean overdraft, LocalDate maturityDate,
                                     BigDecimal creditLine) {
        Account a = null;

        switch (type) {
            case CHECKING -> addChecking(client, balance, joint, jointClient, overdraft);
            case SAVINGS -> addSavings(client, balance, joint, jointClient);
            case CREDIT -> addCredit(client, balance, joint, jointClient, maturityDate, creditLine);
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

    public static Account addChecking(Client client, BigDecimal balance, boolean joint, Client jointClient,
                                      boolean overdraft) {
        return new Checking.Builder(client)
                .balance(balance)
                .joint(joint)
                .jointClient(jointClient)
                .overdraftProtection(overdraft)
                .build();
    }

    public static Account addSavings(Client client, BigDecimal balance, boolean joint, Client jointClient) {
        return new Savings.Builder(client)
                .balance(balance)
                .joint(joint)
                .jointClient(jointClient)
                .build();
    }

    public static Account addCredit(Client client, BigDecimal balance, boolean joint, Client jointClient,
                                    LocalDate maturityDate, BigDecimal creditLine) {
        return new Credit.Builder(client)
                .balance(balance)
                .joint(joint)
                .jointClient(jointClient)
                .maturityDate(maturityDate)
                .creditLine(creditLine)
                .build();
    }
}
