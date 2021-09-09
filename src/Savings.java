import java.time.LocalDate;

public class Savings extends Account {

    private final static String DEFAULT_SAVINGS_NAME = "General Savings Account";

    // Constructors
    public Savings(String accountName, Client client, double balance, boolean joint, Client jointClient, LocalDate open) {
        super(accountName, client, balance, joint, jointClient, open);
    }

    public Savings(Client client, double balance, boolean joint, Client jointClient, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, client, balance, joint, jointClient, open);
    }

    public Savings(String accountName, Client client, double balance, boolean joint, Client jointClient) {
        super(accountName, client, balance, joint, jointClient);
    }

    public Savings(Client client, double balance, boolean joint, Client jointClient) {
        super(DEFAULT_SAVINGS_NAME, client, balance, joint, jointClient);
    }

    public Savings(String accountName, Client client, double balance, LocalDate open) {
        super(accountName, client, balance, open);
    }

    public Savings(Client client, double balance, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, client, balance, open);
    }

    public Savings(String accountName, Client client, boolean joint, Client jointClient, LocalDate open) {
        super(accountName, client, joint, jointClient, open);
    }

    public Savings(Client client, boolean joint, Client jointClient, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, client, joint, jointClient, open);
    }

    public Savings(String accountName, Client client, double balance) {
        super(accountName, client, balance);
    }

    public Savings(Client client, double balance) {
        super(DEFAULT_SAVINGS_NAME, client, balance);
    }

    public Savings(String accountName, Client client, boolean joint, Client jointClient) {
        super(accountName, client, joint, jointClient);
    }

    public Savings(Client client, boolean joint, Client jointClient) {
        super(DEFAULT_SAVINGS_NAME, client, joint, jointClient);
    }

    public Savings(String accountName, Client client, LocalDate open) {
        super(accountName, client, open);
    }

    public Savings(Client client, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, client, open);
    }

    public Savings(String accountName, Client client) {
        super(accountName, client);
    }

    public Savings(Client client) {
        super(DEFAULT_SAVINGS_NAME, client);
    }
}
