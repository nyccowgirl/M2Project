import java.time.LocalDate;

public class Checking extends Account {
    private boolean overdraftProtection;        // Can also add overdraft limit for more complexity (or pull from Credit class)

    private static double totalCheckingBalances = 0;                // M2 HOMEWORK STATIC
    private final static String DEFAULT_CHECKING_NAME = "General Checking Account";
    private final static boolean DEFAULT_OVERDRAFT_PROTECTION = false;

    // Constructors
    public Checking(String accountName, Client client, double balance, boolean joint, Client jointClient, LocalDate open,
                    boolean overdraftProtection) {
        super(accountName, client, balance, joint, jointClient, open);
        this.overdraftProtection = overdraftProtection;
        Checking.totalCheckingBalances += balance;                  // M2 HOMEWORK STATIC
    }

    public Checking(String accountName, Client client, double balance, boolean joint, Client jointClient, LocalDate open) {
        super(accountName, client, balance, joint, jointClient, open);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
        Checking.totalCheckingBalances += balance;                  // M2 HOMEWORK STATIC
    }

    public Checking(Client client, double balance, boolean joint, Client jointClient, LocalDate open,
                    boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, client, balance, joint, jointClient, open, overdraftProtection);
    }

    public Checking(Client client, double balance, boolean joint, Client jointClient, LocalDate open) {
        this(DEFAULT_CHECKING_NAME, client, balance, joint, jointClient, open, DEFAULT_OVERDRAFT_PROTECTION);
    }

    public Checking(String accountName, Client client, double balance, boolean joint, Client jointClient,
                    boolean overdraftProtection) {
        super(accountName, client, balance, joint, jointClient);
        this.overdraftProtection = overdraftProtection;
        Checking.totalCheckingBalances += balance;                  // M2 HOMEWORK STATIC
    }

    public Checking(String accountName, Client client, double balance, boolean joint, Client jointClient) {
        super(accountName, client, balance, joint, jointClient);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
        Checking.totalCheckingBalances += balance;                  // M2 HOMEWORK STATIC
    }

    public Checking(Client client, double balance, boolean joint, Client jointClient, boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, client, balance, joint, jointClient, overdraftProtection);
    }

    public Checking(Client client, double balance, boolean joint, Client jointClient) {
        this(DEFAULT_CHECKING_NAME, client, balance, joint, jointClient, DEFAULT_OVERDRAFT_PROTECTION);
    }

    public Checking(String accountName, Client client, double balance, LocalDate open, boolean overdraftProtection) {
        super(accountName, client, balance, open);
        this.overdraftProtection = overdraftProtection;
        Checking.totalCheckingBalances += balance;                  // M2 HOMEWORK STATIC
    }

    public Checking(String accountName, Client client, double balance, LocalDate open) {
        super(accountName, client, balance, open);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
        Checking.totalCheckingBalances += balance;                  // M2 HOMEWORK STATIC
    }

    public Checking(Client client, double balance, LocalDate open, boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, client, balance, open, overdraftProtection);
    }

    public Checking(Client client, double balance, LocalDate open) {
        this(DEFAULT_CHECKING_NAME, client, balance, open, DEFAULT_OVERDRAFT_PROTECTION);
    }

    public Checking(String accountName, Client client, boolean joint, Client jointClient, LocalDate open,
                    boolean overdraftProtection) {
        super(accountName, client, joint, jointClient, open);
        this.overdraftProtection = overdraftProtection;
        Checking.totalCheckingBalances += super.getBalance();       // M2 HOMEWORK STATIC
    }

    public Checking(String accountName, Client client, boolean joint, Client jointClient, LocalDate open) {
        super(accountName, client, joint, jointClient, open);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
        Checking.totalCheckingBalances += super.getBalance();       // M2 HOMEWORK STATIC
    }

    public Checking(Client client, boolean joint, Client jointClient, LocalDate open, boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, client, joint, jointClient, open, overdraftProtection);
    }

    public Checking(Client client, boolean joint, Client jointClient, LocalDate open) {
        this(DEFAULT_CHECKING_NAME, client, joint, jointClient, open, DEFAULT_OVERDRAFT_PROTECTION);
    }

    public Checking(String accountName, Client client, double balance, boolean overdraftProtection) {
        super(accountName, client, balance);
        this.overdraftProtection = overdraftProtection;
        Checking.totalCheckingBalances += balance;                  // M2 HOMEWORK STATIC
    }

    public Checking(String accountName, Client client, double balance) {
        super(accountName, client, balance);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
        Checking.totalCheckingBalances += balance;                  // M2 HOMEWORK STATIC
    }

    public Checking(Client client, double balance, boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, client, balance, overdraftProtection);
    }

    public Checking(Client client, double balance) {
        this(DEFAULT_CHECKING_NAME, client, balance, DEFAULT_OVERDRAFT_PROTECTION);
    }

    public Checking(String accountName, Client client, boolean joint, Client jointClient, boolean overdraftProtection) {
        super(accountName, client, joint, jointClient);
        this.overdraftProtection = overdraftProtection;
        Checking.totalCheckingBalances += super.getBalance();       // M2 HOMEWORK STATIC
    }

    public Checking(String accountName, Client client, boolean joint, Client jointClient) {
        super(accountName, client, joint, jointClient);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
        Checking.totalCheckingBalances += super.getBalance();       // M2 HOMEWORK STATIC
    }

    public Checking(Client client, boolean joint, Client jointClient, boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, client, joint, jointClient, overdraftProtection);
    }

    public Checking(Client client, boolean joint, Client jointClient) {
        this(DEFAULT_CHECKING_NAME, client, joint, jointClient, DEFAULT_OVERDRAFT_PROTECTION);
    }

    public Checking(String name, Client client, LocalDate open, boolean overdraftProtection) {
        super(name, client, open);
        this.overdraftProtection = overdraftProtection;
        Checking.totalCheckingBalances += super.getBalance();       // M2 HOMEWORK STATIC
    }

    public Checking(String name, Client client, LocalDate open) {
        super(name, client, open);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
        Checking.totalCheckingBalances += super.getBalance();       // M2 HOMEWORK STATIC
    }

    public Checking(Client client, LocalDate open, boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, client, open, overdraftProtection);
    }

    public Checking(Client client, LocalDate open) {
        this(DEFAULT_CHECKING_NAME, client, open, DEFAULT_OVERDRAFT_PROTECTION);
    }

    public Checking(String name, Client client, boolean overdraftProtection) {
        super(name, client);
        this.overdraftProtection = overdraftProtection;
        Checking.totalCheckingBalances += super.getBalance();       // M2 HOMEWORK STATIC
    }

    public Checking(String name, Client client) {
        super(name, client);
        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
        Checking.totalCheckingBalances += super.getBalance();       // M2 HOMEWORK STATIC
    }

    public Checking(Client client, boolean overdraftProtection) {
        this(DEFAULT_CHECKING_NAME, client, overdraftProtection);
    }

    public Checking(Client client) {
        this(DEFAULT_CHECKING_NAME, client, DEFAULT_OVERDRAFT_PROTECTION);
    }

    // Getters and Setters
    @Override
    public void setBalance(double balance) {                        // M2 HOMEWORK STATIC
        Checking.totalCheckingBalances += (balance - super.getBalance());
        super.setBalance(balance);
    }

    @Override
    public boolean setClose(LocalDate close) {                      // M2 HOMEWORK STATIC
        double currentBalance = super.getBalance();
        if (!super.setClose(close)) {
            Checking.totalCheckingBalances -= currentBalance;
            return false;
        } else {
            return true;
        }
    }

    public boolean isOverdraftProtection() {
        return overdraftProtection;
    }

    public void setOverdraftProtection(boolean overdraftProtection) {
        this.overdraftProtection = overdraftProtection;
    }

    public static double getTotalCheckingBalances() {               // M2 HOMEWORK STATIC
        return Checking.totalCheckingBalances;
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

    // Class-Specific Methods
    @Override
    public void deposit(double amount) {                                // M2 HOMEWORK STATIC
        super.deposit(amount);
        Checking.totalCheckingBalances += amount;
    }

    @Override
    protected boolean withdrawalCheck(double amount) {                  // M2 HOMEWORK STATIC
        throw new IllegalAccessError();
    }

    @Override
    public void withdrawal(double amount) {                             // M2 HOMEWORK STATIC
        if (overdraftProtection) {
            super.setBalance(getBalance() - amount);
            Checking.totalCheckingBalances -= amount;
            super.printBalance();
        } else {
            if (super.withdrawalCheck(amount)) {
                super.withdrawal(amount);
                Checking.totalCheckingBalances -= amount;
            }
        }
    }
}
