import java.time.LocalDate;
import java.util.Random;
import java.lang.Math;

public abstract class Account {

    private int accountNo;          // This should be unique so would not have a default (see static variable)
    private String accountName;     // Default account name should be at child class
    private int clientID;           // Future versions would have this and jointD be Client objects
    private double balance;
    private boolean joint;          // Maybe only add in personal account if we separate client types further
    private int jointID;            // Default to -1 if joint is false
    private LocalDate open;         // Represents date (year, month, day (yyyy-MM-dd))
    private LocalDate close;

    private static int nextAccountNo = 1;           // Increment account number to avoid duplications
    private final static double DEFAULT_BALANCE = 0;
    private final static boolean DEFAULT_JOINT = false;
    private final static int DEFAULT_JOINTID = -1;
    private final static LocalDate DEFAULT_OPEN_DATE = LocalDate.now();
    private final static int DEFAULT_CLOSE_TERM = 100;

    // Constructors
    // Utilizing automatic assignment of account number
    public Account(String accountName, int clientID, double balance, boolean joint, int jointID,
                   LocalDate open) {
        if (clientID <= 0) {
            throw new IllegalArgumentException("Client ID cannot be less than 1.");
        } else if (joint && !(jointID > 0)) {
            throw new IllegalArgumentException("Joint ID is required for joint accounts and cannot be less than 1.");
        } else {
            this.accountNo = nextAccountNo;
            nextAccountNo++;
            this.accountName = accountName;
            this.clientID = clientID;
            this.balance = balance;
            this.joint = joint;
            this.jointID = jointID;
            this.open = open;
            this.close = open.plusYears(DEFAULT_CLOSE_TERM);
        }
    }

    public Account(String accountName, int clientID, double balance, boolean joint, int jointID) {
        this(accountName, clientID, balance, joint, jointID, DEFAULT_OPEN_DATE);
    }

    public Account(String accountName, int clientID, double balance, LocalDate open) {
        this(accountName, clientID, balance, DEFAULT_JOINT, DEFAULT_JOINTID, open);
    }

    public Account(String accountName, int clientID, boolean joint, int jointID, LocalDate open) {
        this(accountName, clientID, DEFAULT_BALANCE, joint, jointID, open);
    }

    public Account(String accountName, int clientID, double balance) {
        this(accountName, clientID, balance, DEFAULT_JOINT, DEFAULT_JOINTID, DEFAULT_OPEN_DATE);
    }

    public Account(String accountName, int clientID, boolean joint, int jointID) {
        this(accountName, clientID, DEFAULT_BALANCE, joint, jointID, DEFAULT_OPEN_DATE);
    }

    public Account(String accountName, int clientID, LocalDate open) {
        this(accountName, clientID, DEFAULT_BALANCE, DEFAULT_JOINT, DEFAULT_JOINTID, open);
    }

    public Account(String accountName, int clientID) {
        this(accountName, clientID, DEFAULT_BALANCE, DEFAULT_JOINT, DEFAULT_JOINTID, DEFAULT_OPEN_DATE);
    }

    // Getters and Setters
    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo() {
        // Automatically sets account number based on next available number to avoid duplicates
        this.accountNo = nextAccountNo;
        nextAccountNo++;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getClientID() {
        return clientID;
    }

    // Should be rare but in cases of transfer of accounts to other parties for death or divorce, etc.
    public void setClientID(int clientID) {
        if (clientID >= 0) {
            this.clientID = clientID;
        }
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

        if (joint && (jointID <= 0)) {
            System.out.println("Please update joint ID.");
        } else if (!joint) {
            jointID = DEFAULT_JOINTID;
        }
    }

    public int getJointID() {
        return jointID;
    }

    public void setJointID(int jointID) {
        if (joint && jointID > 0) {
            this.jointID = jointID;
        } else if (!joint && jointID > 0) {
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
                "\n\tClient ID: " + clientID +
                "\n\tAccount Balance: " + balance +
                "\n\tJoint Account: " + (joint ? "yes" : "no") +
                "\n\tJoint ID: " + (joint ? jointID : "N/A") +
                "\n\tOpen Date: " + open +
                "\n\tClose Date: " + close;
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            Account other = (Account) obj;
            return (accountNo == other.getAccountNo() && accountName.equalsIgnoreCase(other.getAccountName()) &&
                    clientID == other.getClientID() && (Math.abs(balance - other.getBalance()) < .01) &&
                    joint == other.isJoint() && jointID == other.getJointID() &&
                    (open.compareTo(other.getOpen()) == 0) && (close.compareTo(other.getClose()) == 0));
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

    public static int generateAccountNumber()
    {
        Random rand = new Random();
        int newAccountNumber = rand.nextInt(1000000000);

        return newAccountNumber;
    }
}
