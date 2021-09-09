import java.time.LocalDate;

public class Savings extends Account {

    private final static String DEFAULT_SAVINGS_NAME = "General Savings Account";

    // Constructors
    public Savings(String accountName, int clientID, double balance, boolean joint, int jointID, LocalDate open) {
        super(accountName, clientID, balance, joint, jointID, open);
    }

    public Savings(int clientID, double balance, boolean joint, int jointID, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, clientID, balance, joint, jointID, open);
    }

    public Savings(String accountName, int clientID, double balance, boolean joint, int jointID) {
        super(accountName, clientID, balance, joint, jointID);
    }

    public Savings(int clientID, double balance, boolean joint, int jointID) {
        super(DEFAULT_SAVINGS_NAME, clientID, balance, joint, jointID);
    }

    public Savings(String accountName, int clientID, double balance, LocalDate open) {
        super(accountName, clientID, balance, open);
    }

    public Savings(int clientID, double balance, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, clientID, balance, open);
    }

    public Savings(String accountName, int clientID, boolean joint, int jointID, LocalDate open) {
        super(accountName, clientID, joint, jointID, open);
    }

    public Savings(int clientID, boolean joint, int jointID, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, clientID, joint, jointID, open);
    }

    public Savings(String accountName, int clientID, double balance) {
        super(accountName, clientID, balance);
    }

    public Savings(int clientID, double balance) {
        super(DEFAULT_SAVINGS_NAME, clientID, balance);
    }

    public Savings(String accountName, int clientID, boolean joint, int jointID) {
        super(accountName, clientID, joint, jointID);
    }

    public Savings(int clientID, boolean joint, int jointID) {
        super(DEFAULT_SAVINGS_NAME, clientID, joint, jointID);
    }

    public Savings(String accountName, int clientID, LocalDate open) {
        super(accountName, clientID, open);
    }

    public Savings(int clientID, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, clientID, open);
    }

    public Savings(String accountName, int clientID) {
        super(accountName, clientID);
    }

    public Savings(int clientID) {
        super(DEFAULT_SAVINGS_NAME, clientID);
    }
}
