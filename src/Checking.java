import java.math.BigDecimal;
import java.time.LocalDate;

public class Checking extends Account {

    private boolean overdraftProtection = false;        // Can also add overdraft limit for more complexity (or pull from Credit class)

    private static BigDecimal totalCheckingBalances = new BigDecimal(0);                // M2 HOMEWORK STATIC

    // CONSTRUCTORS
    private Checking(Account.Builder<?, ?> accountBuilder, Builder checkingBuilder) {
        super(accountBuilder);
        this.overdraftProtection = checkingBuilder.account.overdraftProtection;
        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(super.getBalance());
    }

    private Checking() {}

    // BUILDER
    public static class Builder extends Account.Builder<Checking, Checking.Builder> {

        private final String DEFAULT_CHECKING_ACCOUNT_NAME = "General Checking Account";

        public Builder(Client client) {
            super(client);
            if (account.accountName == null) {
                accountName(DEFAULT_CHECKING_ACCOUNT_NAME);
            }
        }

        public Builder overdraftProtection(boolean overdraftProtection) {
            account.overdraftProtection = overdraftProtection;
            return builder;
        }

        protected Checking createAccount(Account.Builder<Checking, Builder> builder) {
            return new Checking(builder, this);
        }

        protected Checking createAccount() {
            return new Checking();
        }

        protected Builder getBuilder() {
            return this;
        }
    }

    // GETTERS & SETTERS
    @Override
    public void setBalance(BigDecimal balance) {                                                // M2 HOMEWORK STATIC
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

    // OVERRIDE METHODS
    @Override
    public String toString() {
        return super.toString() + "\n\tOverdraft Protection: " + (overdraftProtection ? "Yes" : "No");
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

    // STRATEGY METHODS
    @Override
    public void addInterest(BigDecimal interest) {
        BigDecimal current = super.getBalance();
        super.addInterest(interest);                                                            // M3 USING STRATEGY
        updateTotalCheckingBalances(current);
    }

    @Override
    public void addBonus(BigDecimal bonus) {
        BigDecimal current = super.getBalance();
        super.addBonus(bonus);                                                                  // M3 USING STRATEGY
        updateTotalCheckingBalances(current);
    }

    @Override
    public void subtractFees(BigDecimal fees) {
        BigDecimal current = super.getBalance();
        super.subtractFees(fees);                                                               // M3 USING STRATEGY
        updateTotalCheckingBalances(current);
    }

    // HELPER METHOD
    private void updateTotalCheckingBalances(BigDecimal current) {
        Checking.totalCheckingBalances = Checking.totalCheckingBalances.add(super.getBalance().subtract(current));
    }

}
