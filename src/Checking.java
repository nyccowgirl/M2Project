import java.time.LocalDate;
import java.lang.Math;

public class Checking extends Account {
    private boolean overdraftProtection;        // Can also add overdraft limit for more complexity (or pull from Credit class)

    private final static String DEFAULT_CHECKING_NAME = "General Checking Account";
    private final static boolean DEFAULT_OVERDRAFT_PROTECTION = false;

    // Constructors
    public Checking(String accountName, int clientID, double balance, boolean joint, int jointID, LocalDate open,
                    boolean overdraftProtection) {
        super(accountName, clientID, balance, joint, jointID, open);
        this.overdraftProtection = overdraftProtection;
    }

    public Checking(String accountName, int clientID, double balance, boolean joint, int jointID, LocalDate open) {
        super(accountName, clientID, balance, joint, jointID, open);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
    }

    public Checking(int clientID, double balance, boolean joint, int jointID, LocalDate open,
                    boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, clientID, balance, joint, jointID, open, overdraftProtection);
    }

    public Checking(int clientID, double balance, boolean joint, int jointID, LocalDate open) {
        this(DEFAULT_CHECKING_NAME, clientID, balance, joint, jointID, open, DEFAULT_OVERDRAFT_PROTECTION);
    }

    public Checking(String accountName, int clientID, double balance, boolean joint, int jointID,
                    boolean overdraftProtection) {
        super(accountName, clientID, balance, joint, jointID);
        this.overdraftProtection = overdraftProtection;
    }

    public Checking(String accountName, int clientID, double balance, boolean joint, int jointID) {
        super(accountName, clientID, balance, joint, jointID);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
    }

    public Checking(int clientID, double balance, boolean joint, int jointID, boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, clientID, balance, joint, jointID, overdraftProtection);
    }

    public Checking(int clientID, double balance, boolean joint, int jointID) {
        this(DEFAULT_CHECKING_NAME, clientID, balance, joint, jointID, DEFAULT_OVERDRAFT_PROTECTION);
    }

    public Checking(String accountName, int clientID, double balance, LocalDate open, boolean overdraftProtection) {
        super(accountName, clientID, balance, open);
        this.overdraftProtection = overdraftProtection;
    }

    public Checking(String accountName, int clientID, double balance, LocalDate open) {
        super(accountName, clientID, balance, open);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
    }

    public Checking(int clientID, double balance, LocalDate open, boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, clientID, balance, open, overdraftProtection);
    }

    public Checking(int clientID, double balance, LocalDate open) {
        this(DEFAULT_CHECKING_NAME, clientID, balance, open, DEFAULT_OVERDRAFT_PROTECTION);
    }

    public Checking(String accountName, int clientID, boolean joint, int jointID, LocalDate open,
                    boolean overdraftProtection) {
        super(accountName, clientID, joint, jointID, open);
        this.overdraftProtection = overdraftProtection;
    }

    public Checking(String accountName, int clientID, boolean joint, int jointID, LocalDate open) {
        super(accountName, clientID, joint, jointID, open);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
    }

    public Checking(int clientID, boolean joint, int jointID, LocalDate open, boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, clientID, joint, jointID, open, overdraftProtection);
    }

    public Checking(int clientID, boolean joint, int jointID, LocalDate open) {
        this(DEFAULT_CHECKING_NAME, clientID, joint, jointID, open, DEFAULT_OVERDRAFT_PROTECTION);
    }

    public Checking(String accountName, int clientID, double balance, boolean overdraftProtection) {
        super(accountName, clientID, balance);
        this.overdraftProtection = overdraftProtection;
    }

    public Checking(String accountName, int clientID, double balance) {
        super(accountName, clientID, balance);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
    }

    public Checking(int clientID, double balance, boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, clientID, balance, overdraftProtection);
    }

    public Checking(int clientID, double balance) {
        this(DEFAULT_CHECKING_NAME, clientID, balance, DEFAULT_OVERDRAFT_PROTECTION);
    }

    public Checking(String accountName, int clientID, boolean joint, int jointID, boolean overdraftProtection) {
        super(accountName, clientID, joint, jointID);
        this.overdraftProtection = overdraftProtection;
    }

    public Checking(String accountName, int clientID, boolean joint, int jointID) {
        super(accountName, clientID, joint, jointID);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
    }

    public Checking(int clientID, boolean joint, int jointID, boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, clientID, joint, jointID, overdraftProtection);
    }

    public Checking(int clientID, boolean joint, int jointID) {
        this(DEFAULT_CHECKING_NAME, clientID, joint, jointID, DEFAULT_OVERDRAFT_PROTECTION);
    }

    public Checking(String name, int clientID, LocalDate open, boolean overdraftProtection) {
        super(name, clientID, open);
        this.overdraftProtection = overdraftProtection;
    }

    public Checking(String name, int clientID, LocalDate open) {
        super(name, clientID, open);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
    }

    public Checking(int clientID, LocalDate open, boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, clientID, open, overdraftProtection);
    }

    public Checking(int clientID, LocalDate open) {
        this(DEFAULT_CHECKING_NAME, clientID, open, DEFAULT_OVERDRAFT_PROTECTION);
    }

    public Checking(String name, int clientID, boolean overdraftProtection) {
        super(name, clientID);
        this.overdraftProtection = overdraftProtection;
    }

    public Checking(String name, int clientID) {
        super(name, clientID);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
    }

    public Checking(int clientID, boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, clientID, overdraftProtection);
    }

    public Checking(int clientID) {
        this(DEFAULT_CHECKING_NAME, clientID, DEFAULT_OVERDRAFT_PROTECTION);
    }

    // Getters and Setters
    public boolean isOverdraftProtection() {
        return overdraftProtection;
    }

    public void setOverdraftProtection(boolean overdraftProtection) {
        this.overdraftProtection = overdraftProtection;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "\n\tOverdraft Protection: " + (overdraftProtection ? "yes" : "no");
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Checking) {
            Checking other = (Checking) obj;
            return (super.equals(obj) && overdraftProtection == other.overdraftProtection);
        } else {
            return false;
        }
    }

    // Class-Specific Method
    @Override
    public void withdrawal(double amount) {
        if (overdraftProtection) {
            super.setBalance(getBalance() - amount);
            super.printBalance();
        } else {
            super.withdrawal(amount);
        }
    }
}
