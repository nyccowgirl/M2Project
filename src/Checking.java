import java.math.BigDecimal;
import java.time.LocalDate;
import java.math.RoundingMode;

public class Checking extends Account {
    private boolean overdraftProtection;        // Can also add overdraft limit for more complexity (or pull from Credit class)

    private static BigDecimal totalCheckingBalances = new BigDecimal(0);                // M2 HOMEWORK STATIC
//    private final static String DEFAULT_CHECKING_NAME = "General Checking Account";
//    private final static boolean DEFAULT_OVERDRAFT_PROTECTION = false;

    // Constructors
    public Checking(AccountBuilder builder) {
        super(builder);
    }

    public static class CheckingBuilder extends Account.AccountBuilder {

        private String accountName = "General Checking Account";
        private boolean overdraftProtection = false;

        public CheckingBuilder(Client client) {
            super(client);

//            if
            accountName(accountName);
        }

        public CheckingBuilder overdraftProtection(boolean overdraftProtection) {
            this.overdraftProtection = overdraftProtection;
            return this;
        }
    }

//    public Checking(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient,
//                    LocalDate open, boolean overdraftProtection) {
//        super(accountName, client, balance, joint, jointClient, open);
//        this.overdraftProtection = overdraftProtection;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(balance);       // M2 HOMEWORK STATIC
//    }
//
//    public Checking(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient,
//                    LocalDate open) {
//        super(accountName, client, balance, joint, jointClient, open);
//        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(balance);                                          // M2 HOMEWORK STATIC
//    }
//
//    public Checking(Client client, BigDecimal balance, boolean joint, Client jointClient, LocalDate open,
//                    boolean overdraftProtection) {
//        this(DEFAULT_CHECKING_NAME, client, balance, joint, jointClient, open, overdraftProtection);
//    }
//
//    public Checking(Client client, BigDecimal balance, boolean joint, Client jointClient, LocalDate open) {
//        this(DEFAULT_CHECKING_NAME, client, balance, joint, jointClient, open, DEFAULT_OVERDRAFT_PROTECTION);
//    }
//
//    public Checking(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient,
//                    boolean overdraftProtection) {
//        super(accountName, client, balance, joint, jointClient);
//        this.overdraftProtection = overdraftProtection;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(balance);           // M2 HOMEWORK STATIC
//    }
//
//    public Checking(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient) {
//        super(accountName, client, balance, joint, jointClient);
//        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(balance);           // M2 HOMEWORK STATIC
//    }
//
//    public Checking(Client client, BigDecimal balance, boolean joint, Client jointClient, boolean overdraftProtection) {
//        this(DEFAULT_CHECKING_NAME, client, balance, joint, jointClient, overdraftProtection);
//    }
//
//    public Checking(Client client, BigDecimal balance, boolean joint, Client jointClient) {
//        this(DEFAULT_CHECKING_NAME, client, balance, joint, jointClient, DEFAULT_OVERDRAFT_PROTECTION);
//    }
//
//    public Checking(String accountName, Client client, BigDecimal balance, LocalDate open,
//                    boolean overdraftProtection) {
//        super(accountName, client, balance, open);
//        this.overdraftProtection = overdraftProtection;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(balance);           // M2 HOMEWORK STATIC
//    }
//
//    public Checking(String accountName, Client client, BigDecimal balance, LocalDate open) {
//        super(accountName, client, balance, open);
//        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(balance);           // M2 HOMEWORK STATIC
//    }
//
//    public Checking(Client client, BigDecimal balance, LocalDate open, boolean overdraftProtection) {
//        this(DEFAULT_CHECKING_NAME, client, balance, open, overdraftProtection);
//    }
//
//    public Checking(Client client, BigDecimal balance, LocalDate open) {
//        this(DEFAULT_CHECKING_NAME, client, balance, open, DEFAULT_OVERDRAFT_PROTECTION);
//    }
//
//    public Checking(String accountName, Client client, boolean joint, Client jointClient, LocalDate open,
//                    boolean overdraftProtection) {
//        super(accountName, client, joint, jointClient, open);
//        this.overdraftProtection = overdraftProtection;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(super.getBalance());  // M2 HOMEWORK STATIC
//    }
//
//    public Checking(String accountName, Client client, boolean joint, Client jointClient, LocalDate open) {
//        super(accountName, client, joint, jointClient, open);
//        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(super.getBalance());  // M2 HOMEWORK STATIC
//    }
//
//    public Checking(Client client, boolean joint, Client jointClient, LocalDate open, boolean overdraftProtection) {
//        this(DEFAULT_CHECKING_NAME, client, joint, jointClient, open, overdraftProtection);
//    }
//
//    public Checking(Client client, boolean joint, Client jointClient, LocalDate open) {
//        this(DEFAULT_CHECKING_NAME, client, joint, jointClient, open, DEFAULT_OVERDRAFT_PROTECTION);
//    }
//
//    public Checking(String accountName, Client client, BigDecimal balance, boolean overdraftProtection) {
//        super(accountName, client, balance);
//        this.overdraftProtection = overdraftProtection;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(balance);           // M2 HOMEWORK STATIC
//    }
//
//    public Checking(String accountName, Client client, BigDecimal balance) {
//        super(accountName, client, balance);
//        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(balance);           // M2 HOMEWORK STATIC
//    }
//
//    public Checking(Client client, BigDecimal balance, boolean overdraftProtection) {
//        this(DEFAULT_CHECKING_NAME, client, balance, overdraftProtection);
//    }
//
//    public Checking(Client client, BigDecimal balance) {
//        this(DEFAULT_CHECKING_NAME, client, balance, DEFAULT_OVERDRAFT_PROTECTION);
//    }
//
//    public Checking(String accountName, Client client, boolean joint, Client jointClient, boolean overdraftProtection) {
//        super(accountName, client, joint, jointClient);
//        this.overdraftProtection = overdraftProtection;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(super.getBalance());  // M2 HOMEWORK STATIC
//    }
//
//    public Checking(String accountName, Client client, boolean joint, Client jointClient) {
//        super(accountName, client, joint, jointClient);
//        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(super.getBalance());  // M2 HOMEWORK STATIC
//    }
//
//    public Checking(Client client, boolean joint, Client jointClient, boolean overdraftProtection) {
//        this(DEFAULT_CHECKING_NAME, client, joint, jointClient, overdraftProtection);
//    }
//
//    public Checking(Client client, boolean joint, Client jointClient) {
//        this(DEFAULT_CHECKING_NAME, client, joint, jointClient, DEFAULT_OVERDRAFT_PROTECTION);
//    }
//
//    public Checking(String name, Client client, LocalDate open, boolean overdraftProtection) {
//        super(name, client, open);
//        this.overdraftProtection = overdraftProtection;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(super.getBalance());  // M2 HOMEWORK STATIC
//    }
//
//    public Checking(String name, Client client, LocalDate open) {
//        super(name, client, open);
//        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(super.getBalance());  // M2 HOMEWORK STATIC
//    }
//
//    public Checking(Client client, LocalDate open, boolean overdraftProtection) {
//        this(DEFAULT_CHECKING_NAME, client, open, overdraftProtection);
//    }
//
//    public Checking(Client client, LocalDate open) {
//        this(DEFAULT_CHECKING_NAME, client, open, DEFAULT_OVERDRAFT_PROTECTION);
//    }
//
//    public Checking(String name, Client client, boolean overdraftProtection) {
//        super(name, client);
//        this.overdraftProtection = overdraftProtection;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(super.getBalance());  // M2 HOMEWORK STATIC
//    }
//
//    public Checking(String name, Client client) {
//        super(name, client);
//        this.overdraftProtection = DEFAULT_OVERDRAFT_PROTECTION;
//        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(super.getBalance());  // M2 HOMEWORK STATIC
//    }
//
//    public Checking(Client client, boolean overdraftProtection) {
//        this(DEFAULT_CHECKING_NAME, client, overdraftProtection);
//    }
//
//    public Checking(Client client) {
//        this(DEFAULT_CHECKING_NAME, client, DEFAULT_OVERDRAFT_PROTECTION);
//    }

    // Getters and Setters
    @Override
    public void setBalance(BigDecimal balance) {                                                // M2 HOMEWORK STATIC
//        Checking.totalCheckingBalances += (balance - super.getBalance());
        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(balance.subtract(super.getBalance()));
        super.setBalance(balance);
    }

    @Override
    public boolean setClose(LocalDate close) {                                                  // M2 HOMEWORK STATIC
        BigDecimal currentBalance = super.getBalance();
        if (!super.setClose(close)) {
            Checking.totalCheckingBalances = Checking.totalCheckingBalances.subtract(currentBalance);
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

    // Override Methods
    @Override
    public String toString() {
        return super.toString() + "\n\tOverdraft Protection: " + (overdraftProtection ? "yes" : "no");
    }

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
    public void deposit(BigDecimal amount) {                                                    // M2 HOMEWORK STATIC
        super.deposit(amount);
        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(amount);
    }

    @Override
    public void withdrawal(BigDecimal amount) {                                                 // M2 HOMEWORK STATIC
        if (overdraftProtection) {
            super.setBalance(super.getBalance().subtract(amount));
            Checking.totalCheckingBalances = Checking.totalCheckingBalances.subtract(amount);
            super.printBalance();
        } else {
            if (super.withdrawalCheck(amount)) {
                super.withdrawal(amount);
                Checking.totalCheckingBalances = Checking.totalCheckingBalances.subtract(amount);
            }
        }
    }

    // CLASS-SPECIFIC METHOD
    public static BigDecimal getTotalCheckingBalances() {                                       // M2 HOMEWORK STATIC
        return Checking.totalCheckingBalances;
    }
}
