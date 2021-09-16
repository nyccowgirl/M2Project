import java.math.BigDecimal;
import java.time.LocalDate;

public class Savings extends Account {

    private static BigDecimal totalSavingsBalances = new BigDecimal(0);                     // M2 HOMEWORK STATIC

    // CONSTRUCTORS
    protected Savings(Account.Builder<?, ?> accountBuilder, Builder savingsBuilder) {
        super(accountBuilder);
    }

    private Savings() {

    }

    public static class Builder extends Account.Builder<Savings, Savings.Builder> {

        private String DEFAULT_SAVINGS_ACCOUNT_NAME = "General Savings Account";

        public Builder(Client client) {
            super(client);
        }

        public Builder accountName() {
            super.accountName((DEFAULT_SAVINGS_ACCOUNT_NAME));
            return builder;
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
    /*
    public static class Builder extends Account.Builder<Builder> {

        private String accountName = "General Savings Account";

        public Builder(Client client) {
            super(client);
//            accountName(accountName);
        }

        public Savings build() {
            return new Savings(this);
        }
    }

     */

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

    // CLASS-SPECIFIC METHOD
    public static BigDecimal getTotalSavingsBalance() {                                         // M2 HOMEWORK STATIC
        return Savings.totalSavingsBalances;
    }

}
