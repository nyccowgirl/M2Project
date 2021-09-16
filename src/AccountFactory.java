import java.math.BigDecimal;

public class AccountFactory {

    public static Account newAccount(AccountType type, Client client) {

        Account acc = null;

        switch (type) {
            case CHECKING -> acc = new Checking.Builder(client).accountName().build();
            case SAVINGS -> acc = new Savings.Builder(client).accountName().build();
            case CREDIT -> acc = new Credit.Builder(client).accountName().build();
            case NOT_APPLICABLE -> System.out.println("Not a valid account type.");
            default -> throw new IllegalArgumentException("Unexpected value: " + type);
        }

        return acc;
    }

    public static Account newAccount(AccountType type, Client client, BigDecimal balance) {

        Account acc = null;

        switch (type) {
            case CHECKING -> acc = new Checking.Builder(client).accountName().balance(balance).build();
            case SAVINGS -> acc = new Savings.Builder(client).accountName().balance(balance).build();
            case CREDIT -> acc = new Credit.Builder(client).accountName().balance(balance).build();
            case NOT_APPLICABLE -> System.out.println("Not a valid account type.");
            default -> throw new IllegalArgumentException("Unexpected value: " + type);
        }

        return acc;
    }
}
