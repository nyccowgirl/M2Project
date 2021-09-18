import java.math.BigDecimal;
import java.time.LocalDate;

public class Savings extends Account {

    private static BigDecimal totalSavingsBalances = new BigDecimal(0);                     // M2 HOMEWORK STATIC

    // CONSTRUCTORS
    protected Savings(Account.Builder<?, ?> accountBuilder, Builder savingsBuilder) {
        super(accountBuilder);
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(super.getBalance());
    }

    private Savings() {}

    public static class Builder extends Account.Builder<Savings, Savings.Builder> {

        private final String DEFAULT_SAVINGS_ACCOUNT_NAME = "General Savings Account";

        public Builder(Client client) {
            super(client);
            if (account.accountName == null) {
                accountName(DEFAULT_SAVINGS_ACCOUNT_NAME);
            }
        }

        protected Savings createAccount(Account.Builder<Savings, Builder> builder) {
            return new Savings(builder, this);
        }

        protected Savings createAccount() {
            return new Savings();
        }

        protected Builder getBuilder() {
            return this;
        }
    }

    // GETTERS & SETTERS
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

    @Override
    public void addInterest(BigDecimal interest) {
        BigDecimal current = balance;
        super.addInterest(interest);                                                            // M3 USING STRATEGY
        updateTotalSavingsBalances(current);
    }

    @Override
    public void addBonus(BigDecimal bonus) {
        BigDecimal current = balance;
        super.addBonus(bonus);                                                                  // M3 USING STRATEGY
        updateTotalSavingsBalances(current);
    }

    @Override
    public void subtractFees(BigDecimal fees) {
        BigDecimal current = balance;
        super.subtractFees(fees);                                                               // M3 USING STRATEGY
        updateTotalSavingsBalances(current);
    }

    // CLASS-SPECIFIC METHOD
    public static BigDecimal getTotalSavingsBalance() {                                         // M2 HOMEWORK STATIC
        return Savings.totalSavingsBalances;
    }

    // HELPER METHOD
    private void updateTotalSavingsBalances(BigDecimal current) {
        Savings.totalSavingsBalances = Savings.totalSavingsBalances.add(balance.subtract(current));
    }

}
