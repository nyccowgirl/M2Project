import java.math.BigDecimal;
import java.time.LocalDate;

public class Savings extends Account {

    private static BigDecimal totalSavingsBalances = new BigDecimal(0);                     // M2 HOMEWORK STATIC
    private final static String DEFAULT_SAVINGS_NAME = "General Savings Account";

    // Constructors
    public Savings(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient,
                   LocalDate open) {
        super(accountName, client, balance, joint, jointClient, open);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(balance);               // M2 HOMEWORK STATIC
    }

    public Savings(Client client, BigDecimal balance, boolean joint, Client jointClient, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, client, balance, joint, jointClient, open);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(balance);               // M2 HOMEWORK STATIC
    }

    public Savings(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient) {
        super(accountName, client, balance, joint, jointClient);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(balance);               // M2 HOMEWORK STATIC
    }

    public Savings(Client client, BigDecimal balance, boolean joint, Client jointClient) {
        super(DEFAULT_SAVINGS_NAME, client, balance, joint, jointClient);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(balance);               // M2 HOMEWORK STATIC
    }

    public Savings(String accountName, Client client, BigDecimal balance, LocalDate open) {
        super(accountName, client, balance, open);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(balance);               // M2 HOMEWORK STATIC
    }

    public Savings(Client client, BigDecimal balance, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, client, balance, open);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(balance);               // M2 HOMEWORK STATIC
    }

    public Savings(String accountName, Client client, boolean joint, Client jointClient, LocalDate open) {
        super(accountName, client, joint, jointClient, open);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(super.getBalance());    // M2 HOMEWORK STATIC
    }

    public Savings(Client client, boolean joint, Client jointClient, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, client, joint, jointClient, open);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(super.getBalance());    // M2 HOMEWORK STATIC
    }

    public Savings(String accountName, Client client, BigDecimal balance) {
        super(accountName, client, balance);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(balance);               // M2 HOMEWORK STATIC
    }

    public Savings(Client client, BigDecimal balance) {
        super(DEFAULT_SAVINGS_NAME, client, balance);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(balance);               // M2 HOMEWORK STATIC
    }

    public Savings(String accountName, Client client, boolean joint, Client jointClient) {
        super(accountName, client, joint, jointClient);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(super.getBalance());    // M2 HOMEWORK STATIC
    }

    public Savings(Client client, boolean joint, Client jointClient) {
        super(DEFAULT_SAVINGS_NAME, client, joint, jointClient);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(super.getBalance());    // M2 HOMEWORK STATIC
    }

    public Savings(String accountName, Client client, LocalDate open) {
        super(accountName, client, open);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(super.getBalance());    // M2 HOMEWORK STATIC
    }

    public Savings(Client client, LocalDate open) {
        super(DEFAULT_SAVINGS_NAME, client, open);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(super.getBalance());    // M2 HOMEWORK STATIC
    }

    public Savings(String accountName, Client client) {
        super(accountName, client);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(super.getBalance());    // M2 HOMEWORK STATIC
    }

    public Savings(Client client) {
        super(DEFAULT_SAVINGS_NAME, client);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(super.getBalance());    // M2 HOMEWORK STATIC
    }

    // GETTERS/SETTERS
    @Override
    public void setBalance(BigDecimal balance) {                                                // M2 HOMEWORK STATIC
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(balance.subtract(super.getBalance()));
        super.setBalance(balance);
    }

    @Override
    public boolean setClose(LocalDate close) {                                                  // M2 HOMEWORK STATIC
        BigDecimal currentBalance = super.getBalance();
        if (!super.setClose(close)) {
            Savings.totalSavingsBalances = Savings.totalSavingsBalances.subtract(currentBalance);
            return false;
        } else {
            return true;
        }
    }

    // OVERRIDE METHODS
    @Override
    public void deposit(BigDecimal amount) {                                                    // M2 HOMEWORK STATIC
        super.deposit(amount);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(amount);
    }

    @Override
    public void withdrawal(BigDecimal amount) {                                                 // M2 HOMEWORK STATIC
        if (super.withdrawalCheck(amount)) {
            super.withdrawal(amount);
            Savings.totalSavingsBalances = Savings.totalSavingsBalances.subtract(amount);
        }
    }

    // CLASS-SPECIFIC METHOD
    public static BigDecimal getTotalSavingsBalance() {                                         // M2 HOMEWORK STATIC
        return Savings.totalSavingsBalances;
    }

}
