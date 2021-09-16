import java.math.BigDecimal;
import java.time.LocalDate;

public class Checking extends Account {
    private boolean overdraftProtection = false;        // Can also add overdraft limit for more complexity (or pull from Credit class)

    private static BigDecimal totalCheckingBalances = new BigDecimal(0);                // M2 HOMEWORK STATIC

    // CONSTRUCTORS
    private Checking(Account.Builder<?, ?> accountBuilder, Builder checkingBuilder) {
        super(accountBuilder);
        this.overdraftProtection = checkingBuilder.account.overdraftProtection;
    }

    private Checking() {

    }
    /*
    protected Checking(Builder builder) {
        super(builder);
        this.overdraftProtection = builder.overdraftProtection;
    }

     */

    public static class Builder extends Account.Builder<Checking, Checking.Builder> {

//        private boolean overdraftProtection;

        private String DEFAULT_CHECKING_ACCOUNT_NAME = "General Checking Account";

        public Builder(Client client) {
            super(client);
        }

        public Builder accountName() {
            super.accountName(DEFAULT_CHECKING_ACCOUNT_NAME);
            return builder;
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

    /*
    public static class Builder extends Account.Builder<Builder> {

        private String accountName = "General Checking Account";
        private boolean overdraftProtection = false;

        public Builder(Client client) {
            super(client);
//            accountName(accountName);
        }

        public Builder overdraftProtection(boolean overdraftProtection) {
            this.overdraftProtection = overdraftProtection;
            return this;
        }

        public Checking build() {
            return new Checking(this);
        }
    }

     */

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
        return super.toString() + "\n\tOverdraft Protection: " + (overdraftProtection ? "yes" : "no");
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

    // CLASS-SPECIFIC METHODS
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

    public static BigDecimal getTotalCheckingBalances() {                                       // M2 HOMEWORK STATIC
        return Checking.totalCheckingBalances;
    }
}
