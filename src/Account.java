import java.time.LocalDate;
import java.lang.Math;
import java.util.Objects;

public abstract class Account implements Comparable<Account> {

    private int accountNo;              // This should be unique so would not have a default (see static variable)
    private String accountName;         // Default account name should be at child class
    private Client client;
    private double balance;
    private boolean joint;              // Maybe only add in personal account if we separate client types further
    private Client jointClient;         // Default to null if joint is false
    private LocalDate open;             // Represents date (year, month, day (yyyy-MM-dd))
    private LocalDate close;
    private Status status;                                          // M2 HOMEWORK ENUM USE

    private static int nextAccountNo = 1;                           // M2 HOMEWORK STATIC
    private final static double DEFAULT_BALANCE = 0;
    private final static boolean DEFAULT_JOINT = false;
    private final static Client DEFAULT_JOINT_CLIENT = null;
    private final static LocalDate DEFAULT_OPEN_DATE = LocalDate.now();
    private final static int DEFAULT_CLOSE_TERM = 100;

    // Constructors
    // Utilizing automatic assignment of account number
    public Account(String accountName, Client client, double balance, boolean joint, Client jointClient,
                   LocalDate open) {
        this.accountNo = nextAccountNo;                             // M2 HOMEWORK STATIC
        nextAccountNo++;                                            // M2 HOMEWORK STATIC
        this.accountName = accountName;
        this.client = client;
        this.balance = balance;
        this.joint = joint;
        this.jointClient = jointClient;
        this.open = open;
        this.close = open.plusYears(DEFAULT_CLOSE_TERM);
        this.status = Status.ACTIVE;                                // M2 HOMEWORK ENUM USE
    }

    public Account(String accountName, Client client, double balance, boolean joint, Client jointClient) {
        this(accountName, client, balance, joint, jointClient, DEFAULT_OPEN_DATE);
    }

    public Account(String accountName, Client client, double balance, LocalDate open) {
        this(accountName, client, balance, DEFAULT_JOINT, DEFAULT_JOINT_CLIENT, open);
    }

    public Account(String accountName, Client client, boolean joint, Client jointClient, LocalDate open) {
        this(accountName, client, DEFAULT_BALANCE, joint, jointClient, open);
    }

    public Account(String accountName, Client client, double balance) {
        this(accountName, client, balance, DEFAULT_JOINT, DEFAULT_JOINT_CLIENT, DEFAULT_OPEN_DATE);
    }

    public Account(String accountName, Client client, boolean joint, Client jointClient) {
        this(accountName, client, DEFAULT_BALANCE, joint, jointClient, DEFAULT_OPEN_DATE);
    }

    public Account(String accountName, Client client, LocalDate open) {
        this(accountName, client, DEFAULT_BALANCE, DEFAULT_JOINT, DEFAULT_JOINT_CLIENT, open);
    }

    public Account(String accountName, Client client) {
        this(accountName, client, DEFAULT_BALANCE, DEFAULT_JOINT, DEFAULT_JOINT_CLIENT, DEFAULT_OPEN_DATE);
    }

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

    public double getBalance() {
        return balance;
    }

    // Consider in future versions whether this should be an option or if all balances default to zero and only
    // deposit and withdrawal methods are used.
    public void setBalance(double balance) {
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
            balance = 0;
            this.status = Status.INACTIVE;                                      // M2 HOMEWORK ENUM USE
            return true;
        } else {
            return false;
        }
    }

    public Status getStatus() {                                                 // M2 HOMEWORK ENUM USE
        return status;
    }

    // toString
    @Override
    public String toString() {
        return "Account: \n\tAccount No.: " + accountNo +
                "\n\tAccount Name: " + accountName +
                "\n\tClient ID: " + client.getClientId() +
                "\n\tAccount Balance: " + balance +
                "\n\tJoint Account: " + (joint ? "yes" : "no") +
                "\n\tJoint ID: " + (joint ? jointClient.getClientId() : "N/A") +
                "\n\tOpen Date: " + open + "\tClose Date: " + (status != Status.INACTIVE ? "N/A" : close) +
                "\n\tStatus: " + status.getAbbreviation();                      // M2 HOMEWORK ENUM USE
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
//            @SuppressWarnings("unchecked")
            Account other = (Account) obj;
            return (accountNo == other.getAccountNo() &&
                    accountName.equalsIgnoreCase(other.getAccountName()) &&
                    client.equals(other.client) && (Math.abs(balance - other.getBalance()) < .01) &&
                    joint == other.isJoint() &&
                    Objects.equals(jointClient, other.getJointClient()) &&
                    (open.compareTo(other.getOpen()) == 0) && (close.compareTo(other.getClose()) == 0) &&
                    status.equals(other.getStatus()));                          // M2 HOMEWORK ENUM USE
        } else {
            return false;
        }
    }

    // compareTo
    @Override
    public int compareTo(Account obj) {
//        return accountName.compareTo(obj.getAccountName());
        if (Double.compare(balance, obj.getBalance()) != 0) {
            return Double.compare(balance, obj.getBalance());
        } else {
            return open.compareTo(obj.getOpen());
        }
    }

    // Class-Specific Methods
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Deposit cannot be negative.");
        } else if (status == Status.SUSPENDED || status == Status.INACTIVE) {   // M2 HOMEWORK ENUM USE
            System.out.println("Account is closed or suspended.");
        } else {
            this.balance += amount;
            printBalance();
        }
    }

    public void withdrawal(double amount) {
        if (withdrawalCheck(amount)) {
            this.balance -= amount;
            printBalance();
        }
    }

    // Helper method
    protected boolean withdrawalCheck(double amount) {
        if (amount < 0) {
            System.out.println("Reflect withdrawal as positive amount.");
            return false;
        } else if (amount > balance) {
            System.out.println("Insufficient funds");
            return false;
        } else {
            return true;
        }
    }

    public void printBalance() {
        System.out.println("Current balance: " + balance);
    }

    public void suspend() {
        status = Status.SUSPENDED;                                          // M2 HOMEWORK ENUM USE
    }

    public void reactivate() {                                              // M2 HOMEWORK ENUM USE
        status = Status.ACTIVE;
    }

    // TO DO: Add helper method to check if close date is expired and should be extended.
}
