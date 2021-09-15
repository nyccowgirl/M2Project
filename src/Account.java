import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account implements Comparable<Account> {

    private int accountNo;
    private String accountName;
    private Client client;
    private BigDecimal balance;
    private boolean joint;              // Maybe only add in personal account if we separate client types further
    private Client jointClient;         // Default to null if joint is false
    private LocalDate open;             // Represents date (year, month, day (yyyy-MM-dd))
    private LocalDate close;
    private Status status;                                                                  // M2 HOMEWORK ENUM USE

    private static int nextAccountNo = 1;                                                   // M2 HOMEWORK STATIC
    protected final static int DECIMALS = 2;
    protected final static RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
    private final static BigDecimal DEFAULT_BALANCE = new BigDecimal(0);
//    private final static boolean DEFAULT_JOINT = false;
    private final static Client DEFAULT_JOINT_CLIENT = null;
//    private final static LocalDate DEFAULT_OPEN_DATE = LocalDate.now();
    private final static int DEFAULT_CLOSE_TERM = 100;
    DecimalFormat df = new DecimalFormat("$#,##0.00");

    // Constructors
    protected Account(Builder builder) {
        this.accountNo = builder.accountNo;
        this.accountName = builder.accountName;
        this.client = builder.client;
        this.balance = builder.balance;
        this.joint = builder.joint;
        this.jointClient = builder.jointClient;
        this.open = builder.open;
        this.close = builder.close;
        this.status = builder.status;
    }

    public static class Builder<T extends Builder<T>> {
        private int accountNo;
        private Client client;

        private String accountName = "";
        private BigDecimal balance = DEFAULT_BALANCE;
        private boolean joint = false;
        private Client jointClient = DEFAULT_JOINT_CLIENT;
        private LocalDate open = LocalDate.now();
        private LocalDate close = open.plusYears(DEFAULT_CLOSE_TERM);
        private Status status = Status.ACTIVE;                                              // M2 HOMEWORK ENUM USE

        public Builder(Client client) {
            this.accountNo = nextAccountNo;                                                 // M2 HOMEWORK STATIC
            nextAccountNo++;                                                                // M2 HOMEWORK STATIC
            this.client = client;
        }

        public Builder accountName(String accountName) {
            this.accountName = accountName;
            return this;
        }

        public T balance(BigDecimal balance) {
            this.balance = balance;
            return (T) this;
        }

        public T joint(boolean joint) {
            this.joint = joint;
            return (T) this;
        }

        public T jointClient(Client jointClient) {
            this.jointClient = jointClient;
            return (T) this;
        }

        public T open(LocalDate open) {
            this.open = open;
            return (T) this;
        }

        public T close(LocalDate close) {
            this.close = close;
            return (T) this;
        }

        public T status(Status status) {
            this.status = status;
            return (T) this;
        }

        public Account build() {
            return new Account(this);
        }
    }

//    // CONSTRUCTORS
//    public Account(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient,
//                   LocalDate open) {
//        this.accountNo = nextAccountNo;                                                     // M2 HOMEWORK STATIC
//        nextAccountNo++;                                                                    // M2 HOMEWORK STATIC
//        this.accountName = accountName;
//        this.client = client;
//        this.balance = balance;
//        this.joint = joint;
//        this.jointClient = jointClient;
//        this.open = open;
//        this.close = open.plusYears(DEFAULT_CLOSE_TERM);
//        this.status = Status.ACTIVE;                                                        // M2 HOMEWORK ENUM USE
//    }
//
//    public Account(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient) {
//        this(accountName, client, balance, joint, jointClient, DEFAULT_OPEN_DATE);
//    }
//
//    public Account(String accountName, Client client, BigDecimal balance, LocalDate open) {
//        this(accountName, client, balance, DEFAULT_JOINT, DEFAULT_JOINT_CLIENT, open);
//    }
//
//    public Account(String accountName, Client client, boolean joint, Client jointClient, LocalDate open) {
//        this(accountName, client, DEFAULT_BALANCE, joint, jointClient, open);
//    }
//
//    public Account(String accountName, Client client, BigDecimal balance) {
//        this(accountName, client, balance, DEFAULT_JOINT, DEFAULT_JOINT_CLIENT, DEFAULT_OPEN_DATE);
//    }
//
//    public Account(String accountName, Client client, boolean joint, Client jointClient) {
//        this(accountName, client, DEFAULT_BALANCE, joint, jointClient, DEFAULT_OPEN_DATE);
//    }
//
//    public Account(String accountName, Client client, LocalDate open) {
//        this(accountName, client, DEFAULT_BALANCE, DEFAULT_JOINT, DEFAULT_JOINT_CLIENT, open);
//    }
//
//    public Account(String accountName, Client client) {
//        this(accountName, client, DEFAULT_BALANCE, DEFAULT_JOINT, DEFAULT_JOINT_CLIENT, DEFAULT_OPEN_DATE);
//    }

    // Getters and Setters
    public int getAccountNo() {
        return accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Client getClientID() {
        return client;
    }

    // Should be rare but in cases of transfer of accounts to other parties for death or divorce, etc.
    public void setClientID(Client client) {
        this.client = client;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    // Consider in future versions whether this should be an option or if all balances default to zero and only
    // deposit and withdrawal methods are used.
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isJoint() {
        return joint;
    }

    public void setJoint(boolean joint) {
        this.joint = joint;

        if (joint && (jointClient == null)) {
            System.out.println("Please update joint client.");
        } else if (!joint) {
            jointClient = DEFAULT_JOINT_CLIENT;
        }
    }

    public Client getJointClient() {
        return jointClient;
    }

    public void setJointID(Client jointClient) {
        if (joint) {
            this.jointClient = jointClient;
        } else {
            System.out.println("This is not a joint account.");
        }
    }

    public LocalDate getOpen() {
        return open;
    }

    public void setOpen(LocalDate open) {
        if (open.compareTo(close) <= 0) {
            this.open = open;
        }
    }

    public LocalDate getClose() {
        return close;
    }

    public boolean setClose(LocalDate close) {
        // Updates close date if it is same or a later date than open date
        if ((open.compareTo(close) <= 0) && (close.compareTo(LocalDate.now()) <= 0)) {
            this.close = close;
            balance = DEFAULT_BALANCE;
            this.status = Status.INACTIVE;                                                  // M2 HOMEWORK ENUM USE
            return true;
        } else {
            return false;
        }
    }

    // OVERRIDE METHODS
    @Override
    public String toString() {
        return "Account: \n\tAccount No.: " + accountNo +
                "\n\tAccount Name: " + accountName +
                "\n\tClient ID: " + client.getClientId() +
                "\n\tAccount Balance: " + df.format(balance.setScale(DECIMALS, ROUNDING_MODE)) +
                "\n\tJoint Account: " + (joint ? "yes" : "no") +
                "\n\tJoint ID: " + (joint ? jointClient.getClientId() : "N/A") +
                "\n\tOpen Date: " + open + "\tClose Date: " + (status != Status.INACTIVE ? "N/A" : close) +
                "\n\tStatus: " + status.getAbbreviation();                      // M2 HOMEWORK ENUM USE
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            Account other = (Account) obj;
            return (accountNo == other.getAccountNo() &&
                    accountName.equalsIgnoreCase(other.getAccountName()) &&
                    client.equals(other.client) && balance.equals(other.getBalance()) &&
                    joint == other.isJoint() &&
                    Objects.equals(jointClient, other.getJointClient()) &&
                    (open.compareTo(other.getOpen()) == 0) && (close.compareTo(other.getClose()) == 0) &&
                    status.equals(other.getStatus()));                                      // M2 HOMEWORK ENUM USE
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Account obj) {
        if (balance.compareTo(obj.getBalance()) != 0) {
            return balance.compareTo(obj.getBalance());
        } else {
            return open.compareTo(obj.getOpen());
        }
    }

    // CLASS-SPECIFIC METHODS
    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(0)) < 0) {
            System.out.println("Deposit cannot be negative.");
        } else if (status == Status.SUSPENDED || status == Status.INACTIVE) {   // M2 HOMEWORK ENUM USE
            System.out.println("Account is closed or suspended. Deposit cannot be accepted.");
        } else {
            this.balance = balance.add(amount);
            printBalance();
        }
    }

    public void withdrawal(BigDecimal amount) {
        if (withdrawalCheck(amount)) {
            this.balance = balance.subtract(amount);
            printBalance();
        }
    }

    public void printBalance() {
        System.out.println("Current balance: " + balance);
    }

    public void suspend() {
    status = Status.SUSPENDED;                                                              // M2 HOMEWORK ENUM USE
    }

    public void reactivate() {                                              // M2 HOMEWORK ENUM USE
        status = Status.ACTIVE;
    }                                   // M2 HOMEWORK ENUM USE

    public Status getStatus() {                                                 // M2 HOMEWORK ENUM USE
        return status;
    }                                           // M2 HOMEWORK ENUM USE

    public static int getTotalAccounts() {                                                  // M2 HOMEWORK STATIC
        return nextAccountNo - 1;
    }

    // HELPER METHOD
    protected boolean withdrawalCheck(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(0)) < 0) {
            System.out.println("Reflect withdrawal as positive amount.");
            return false;
        } else if (amount.compareTo(balance) > 0) {
            System.out.println("Insufficient funds");
            return false;
        } else {
            return true;
        }
    }

    // TO DO: Add helper method to check if close date is expired and should be extended.
}
