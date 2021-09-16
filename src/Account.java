import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account implements Comparable<Account> {

    protected int accountNo;
    protected String accountName;
    protected Client client;
    protected BigDecimal balance = DEFAULT_BALANCE;
    protected boolean joint = false;
    protected Client jointClient = DEFAULT_JOINT_CLIENT;
    protected LocalDate open = LocalDate.now();
    protected LocalDate close = open.plusYears(DEFAULT_CLOSE_TERM);
    protected Status status = Status.ACTIVE;
    protected Transactions trans;


//    protected String accountName = "";
//    protected BigDecimal balance = DEFAULT_BALANCE;
//    protected boolean joint = false;
//    protected Client jointClient = DEFAULT_JOINT_CLIENT;
//    protected LocalDate open = LocalDate.now();
//    protected LocalDate close = open.plusYears(DEFAULT_CLOSE_TERM);
//    protected Status status = Status.ACTIVE;

    /*
    private int accountNo;
    private String accountName;
    private Client client;
    private BigDecimal balance;
    private boolean joint;              // Maybe only add in personal account if we separate client types further
    private Client jointClient;         // Default to null if joint is false
    private LocalDate open;             // Represents date (year, month, day (yyyy-MM-dd))
    private LocalDate close;
    private Status status;                                                                  // M2 HOMEWORK ENUM USE
    private Transactions trans;                                                             // M3 USING STRATEGY
*/

    private static int nextAccountNo = 1;                                                   // M2 HOMEWORK STATIC
    protected final static int DECIMALS = 2;
    protected final static RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
    private final static BigDecimal DEFAULT_BALANCE = new BigDecimal(0);
    private final static Client DEFAULT_JOINT_CLIENT = null;
    private final static int DEFAULT_CLOSE_TERM = 100;
    protected static DecimalFormat df = new DecimalFormat("$#,##0.00");

    // CONSTRUCTORS
    protected Account(Builder<?, ?> builder) {
        this.accountNo = builder.account.accountNo;
        this.accountName = builder.account.accountName;
        this.client = builder.account.client;
        this.balance = builder.account.balance;
        this.joint = builder.account.joint;
        this.jointClient = builder.account.jointClient;
        this.open = builder.account.open;
        this.close = builder.account.close;
        this.status = builder.account.status;
    }

    protected Account() {

    }

    /*
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
     */

    protected abstract static class Builder<T extends Account, B extends Builder<T, B>> {
        protected T account;
        protected B builder;

        protected int accountNo;
        protected Client client;

//        protected String accountName = "";
//        protected BigDecimal balance = DEFAULT_BALANCE;
//        protected boolean joint = false;
//        protected Client jointClient = DEFAULT_JOINT_CLIENT;
//        protected LocalDate open = LocalDate.now();
//        protected LocalDate close = open.plusYears(DEFAULT_CLOSE_TERM);
//        protected Status status = Status.ACTIVE;

        public Builder(Client client) {
            builder = getBuilder();
            account = createAccount();
            account.accountNo = nextAccountNo;
            nextAccountNo++;
            account.client = client;
        }

//        public B accountNo() {
//            account.accountNo = nextAccountNo;
//            nextAccountNo++;
//            return builder;
//        }

//        public B client(Client client) {
//            account.client = client;
//            return builder;
//        }

        public B accountName(String accountName) {
            account.accountName = accountName;
            return builder;
        }

        public B balance(BigDecimal balance) {
            account.balance = balance;
            return builder;
        }

        public B joint(boolean joint) {
            account.joint = joint;
            return builder;
        }

        public B jointClient(Client jointClient) {
            account.jointClient = jointClient;
            return builder;
        }

        public B open(LocalDate open) {
            account.open = open;
            return builder;
        }

        public B close(LocalDate close) {
            account.close = close;
            return builder;
        }

        public B status(Status status) {
            account.status = status;
            return builder;
        }

        public T build() {
            return createAccount(builder);
        }

        protected abstract T createAccount(Builder<T, B> builder);
        protected abstract T createAccount();
        protected abstract B getBuilder();

    }
    /*
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
     */

    // GETTERS & SETTERS
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
            System.out.println("Please add joint client.");
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
                "\n\tStatus: " + status.getAbbreviation();                                  // M2 HOMEWORK ENUM USE
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
    status = Status.SUSPENDED;                                                             // M2 HOMEWORK ENUM USE
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

    public void addInterest(BigDecimal interest) {                                          // M3 USING STRATEGY
        trans = new Interest();
        if (balance.compareTo(BigDecimal.valueOf(0)) > 0) {
            setBalance(trans.calculate(balance, interest));
        }
    }

    public void addBonus(BigDecimal bonus) {                                                // M3 USING STRATEGY
        trans = new Bonus();
        setBalance(trans.calculate(balance, bonus));
    }

    public void subtractFees(BigDecimal fees) {                                             // M3 USING STRATEGY
        trans = new Fees();
        setBalance(trans.calculate(balance, fees));
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

    // Consider adding helper method to check if close date is expired and should be extended.
}
