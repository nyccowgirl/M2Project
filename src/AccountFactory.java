import java.math.BigDecimal;

public class AccountFactory {

    public static Account newAccount(AccountType type, Client client) {

        Account acc = null;

        switch (type) {
            case CHECKING -> acc = new Checking(new Checking.Builder(client));
            case SAVINGS -> acc = new Savings(new Savings.Builder(client));
            case CREDIT -> acc = new Credit(new Credit.Builder(client));
            case NOT_APPLICABLE -> System.out.println("Not a valid account type.");
            default -> throw new IllegalArgumentException("Unexpected value: " + type);
        }

        return acc;
    }

    public static Account newAccount(AccountType type, Client client, BigDecimal balance) {

        Account acc = null;

        switch (type) {
            case CHECKING -> acc = new Checking(new Checking.Builder(client).balance(balance));
            case SAVINGS -> acc = new Savings(new Savings.Builder(client).balance(balance));
            case CREDIT -> acc = new Credit(new Credit.Builder(client).balance(balance));
            case NOT_APPLICABLE -> System.out.println("Not a valid account type.");
            default -> throw new IllegalArgumentException("Unexpected value: " + type);
        }

        return acc;
    }
}
