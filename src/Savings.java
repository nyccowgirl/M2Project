import java.time.LocalDate;

public class Savings extends Account {

    private static double totalSavingsBalances = 0;             // M2 HOMEWORK STATIC
    private final static String DEFAULT_SAVINGS_NAME = "General Savings Account";

    // Constructors
    public Savings(String accountName, Client client, double balance, boolean joint, Client jointClient, LocalDate open) {
        super(accountName, client, balance, joint, jointClient, open);
        Savings.totalSavingsBalances += balance;                // M2 HOMEWORK STATIC
    }

    public Savings(Client client, double balance, boolean joint, Client jointClient, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, client, balance, joint, jointClient, open);
        Savings.totalSavingsBalances += balance;                // M2 HOMEWORK STATIC
    }

    public Savings(String accountName, Client client, double balance, boolean joint, Client jointClient) {
        super(accountName, client, balance, joint, jointClient);
        Savings.totalSavingsBalances += balance;                // M2 HOMEWORK STATIC
    }

    public Savings(Client client, double balance, boolean joint, Client jointClient) {
        super(DEFAULT_SAVINGS_NAME, client, balance, joint, jointClient);
        Savings.totalSavingsBalances += balance;                // M2 HOMEWORK STATIC
    }

    public Savings(String accountName, Client client, double balance, LocalDate open) {
        super(accountName, client, balance, open);
        Savings.totalSavingsBalances += balance;                // M2 HOMEWORK STATIC
    }

    public Savings(Client client, double balance, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, client, balance, open);
        Savings.totalSavingsBalances += balance;                // M2 HOMEWORK STATIC
    }

    public Savings(String accountName, Client client, boolean joint, Client jointClient, LocalDate open) {
        super(accountName, client, joint, jointClient, open);
        Savings.totalSavingsBalances += super.getBalance();     // M2 HOMEWORK STATIC
    }

    public Savings(Client client, boolean joint, Client jointClient, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, client, joint, jointClient, open);
        Savings.totalSavingsBalances += super.getBalance();     // M2 HOMEWORK STATIC
    }

    public Savings(String accountName, Client client, double balance) {
        super(accountName, client, balance);
        Savings.totalSavingsBalances += balance;                // M2 HOMEWORK STATIC
    }

    public Savings(Client client, double balance) {
        super(DEFAULT_SAVINGS_NAME, client, balance);
        Savings.totalSavingsBalances += balance;                // M2 HOMEWORK STATIC
    }

    public Savings(String accountName, Client client, boolean joint, Client jointClient) {
        super(accountName, client, joint, jointClient);
        Savings.totalSavingsBalances += super.getBalance();     // M2 HOMEWORK STATIC
    }

    public Savings(Client client, boolean joint, Client jointClient) {
        super(DEFAULT_SAVINGS_NAME, client, joint, jointClient);
        Savings.totalSavingsBalances += super.getBalance();     // M2 HOMEWORK STATIC
    }

    public Savings(String accountName, Client client, LocalDate open) {
        super(accountName, client, open);
        Savings.totalSavingsBalances += super.getBalance();     // M2 HOMEWORK STATIC
    }

    public Savings(Client client, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, client, open);
        Savings.totalSavingsBalances += super.getBalance();     // M2 HOMEWORK STATIC
    }

    public Savings(String accountName, Client client) {
        super(accountName, client);
        Savings.totalSavingsBalances += super.getBalance();     // M2 HOMEWORK STATIC
    }

    public Savings(Client client) {
        super(DEFAULT_SAVINGS_NAME, client);
        Savings.totalSavingsBalances += super.getBalance();     // M2 HOMEWORK STATIC
    }

    // Getter and Setter
    @Override
    public boolean setClose(LocalDate close) {                  // M2 HOMEWORK STATIC
        double currentBalance = super.getBalance();
        if (super.setClose(close)) {
            Savings.totalSavingsBalances -= currentBalance;
            return true;
        } else {
            return false;
        }
    }

    public static double getTotalSavingsBalance() {             // M2 HOMEWORK STATIC
        return Savings.totalSavingsBalances;
    }

    // Class-specific methods
    @Override
    public void deposit(double amount) {                        // M2 HOMEWORK STATIC
        super.deposit(amount);
        Savings.totalSavingsBalances += amount;
    }

    @Override
    protected boolean withdrawalCheck(double amount) {
        throw new IllegalAccessError();                         // M2 HOMEWORK STATIC
    }

    @Override
    public void withdrawal(double amount) {                     // M2 HOMEWORK STATIC
        if (super.withdrawalCheck(amount)) {
            super.withdrawal(amount);
            Savings.totalSavingsBalances -= amount;
        }
    }
}
