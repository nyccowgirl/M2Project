import java.time.LocalDate;
//import java.util.Random;
import java.lang.Math;
import java.util.Objects;

//public abstract class Account<Client extends Comparable<? super Client>> implements Comparable<Account<Client>> {
public abstract class Account {

    private int accountNo;          // This should be unique so would not have a default (see static variable)
    private String accountName;     // Default account name should be at child class
    private Client client;           // Future versions would have this and jointD be Client objects
    private double balance;
    private boolean joint;          // Maybe only add in personal account if we separate client types further
    private Client jointClient;            // Default to -1 if joint is false
    private LocalDate open;         // Represents date (year, month, day (yyyy-MM-dd))
    private LocalDate close;

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
        this.accountNo = nextAccountNo;                         // M2 HOMEWORK STATIC
        nextAccountNo++;                                        // M2 HOMEWORK STATIC
        this.accountName = accountName;
        this.client = client;
        this.balance = balance;
        this.joint = joint;
        this.jointClient = jointClient;
        this.open = open;
        this.close = open.plusYears(DEFAULT_CLOSE_TERM);
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

    public void setAccountNo() {
        this.accountNo = nextAccountNo;                             // M2 HOMEWORK STATIC
        nextAccountNo++;                                            // M2 HOMEWORK STATIC
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
            System.out.println("Please update joint ID.");
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
        this.open = open;
    }

    public LocalDate getClose() {
        return close;
    }

    public void setClose(LocalDate close) {
        // Updates close date if it is same or a later date than open date
        if (close.compareTo(open) >= 0) {
            this.close = close;
        }
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
                "\n\tOpen Date: " + open +
                "\n\tClose Date: " + close;
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            Account other = (Account) obj;
            return (accountNo == other.getAccountNo() &&
                    accountName.equalsIgnoreCase(other.getAccountName()) &&
                    client.equals(other.client) && (Math.abs(balance - other.getBalance()) < .01) &&
                    joint == other.isJoint() &&
//                    Objects.equals(joint, other.getJointClient())
//                    &&
//                    jointClient == other.getJointClient() &&
                    (joint ? jointClient.equals(other.getJointClient()) : jointClient == other.getJointClient()) &&
                    (open.compareTo(other.getOpen()) == 0) && (close.compareTo(other.getClose()) == 0));

            // Not sure if  Objects.equals(joint, other.getJointClient()) replaces the jointClient comparison above
        } else {
            return false;
        }
    }

    // Class-Specific Methods
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Deposit cannot be negative.");
        } else {
            this.balance += amount;
            printBalance();
        }
    }

    // Currently have amount as negative for withdrawals since Credit balances would be negative; however, if it
    // makes more sense to change to positive, adjust formulas throughout.
    public void withdrawal(double amount) {
        if (amount > 0) {
            System.out.println("Withdrawal should be negative.");
        } else if (Math.abs(amount) > balance) {
            System.out.println("Insufficient funds");
        } else {
            this.balance += amount;
            printBalance();
        }
    }

    public void printBalance() {
        System.out.println("Current balance: " + balance);
    }

//    public static int generateAccountNumber()
//    {
//        Random rand = new Random();
//        int newAccountNumber = rand.nextInt(1000000000);
//
//        return newAccountNumber;
//    }
}
