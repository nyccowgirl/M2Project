import java.math.BigDecimal;
import java.time.LocalDate;

public class Credit extends Account {

    private LocalDate maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
    private BigDecimal creditLine = new BigDecimal(5000);

    private static final int DEFAULT_MATURITY_TERM = 5;
    private static BigDecimal totalCreditLines = new BigDecimal(0);                     // M2 HOMEWORK STATIC
    private static BigDecimal totalCreditUtilization = new BigDecimal(0);               // M2 HOMEWORK STATIC

    // CONSTRUCTORS
    protected Credit(Account.Builder<?, ?> accountBuilder, Builder creditBuilder) {
        super(accountBuilder);
        this.maturityDate = creditBuilder.account.maturityDate;
        this.creditLine = creditBuilder.account.creditLine;
        addTotalCredit();
    }

    private Credit() {}

    public static class Builder extends Account.Builder<Credit, Credit.Builder> {

        private final String DEFAULT_CREDIT_ACCOUNT_NAME = "General Credit Account";

        public Builder(Client client) {
            super(client);
            if (account.accountName == null) {
                accountName(DEFAULT_CREDIT_ACCOUNT_NAME);
            }
        }

        public Builder maturityDate(LocalDate maturityDate) {
            account.maturityDate = maturityDate;
            return builder;
        }

        public Builder creditLine(BigDecimal creditLine) {
            account.creditLine = creditLine;
            return builder;
        }

        protected Credit createAccount(Account.Builder<Credit, Builder> builder) {
            return new Credit(builder, this);
        }

        protected Credit createAccount() {
            return new Credit();
        }

        protected Builder getBuilder() {
            return this;
        }
    }

    // GETTERS & SETTERS
    @Override
    public void setBalance(BigDecimal balance) {                                                // M2 HOMEWORK STATIC
        Credit.totalCreditUtilization = Credit.totalCreditUtilization.add(super.getBalance().subtract(balance));
        super.setBalance(balance);
    }

    @Override
    public boolean setClose(LocalDate close) {                                                  // M2 HOMEWORK STATIC
        BigDecimal currentBalance = super.getBalance();
        if (!super.setClose(close)) {
            Credit.totalCreditUtilization = Credit.totalCreditUtilization.add(currentBalance);
            Credit.totalCreditLines = Credit.totalCreditLines.subtract(creditLine);
            return false;
        } else {
            return true;
        }
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        // Updates maturity date if it is same or later date than open date
        if (maturityDate.compareTo(super.getOpen()) >= 0) {
            this.maturityDate = maturityDate;
        }
    }

    public BigDecimal getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(BigDecimal creditLine) {
        BigDecimal currentCreditLine = this.creditLine;
        if (creditLine.compareTo(super.getBalance().abs()) >= 0) {
            this.creditLine = creditLine;
            Credit.totalCreditLines = Credit.totalCreditLines.add(creditLine.subtract(currentCreditLine)); // M2 HOMEWORK STATIC
        }
    }

    // OVERRIDE METHODS
    @Override
    public String toString() {
        return super.toString() + "\n\tMaturity Date: " + maturityDate + "\n\tCredit Limit: " +
                df.format(creditLine.setScale(DECIMALS, ROUNDING_MODE));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Credit) {
            Credit other = (Credit) obj;
            return (super.equals(obj) && (maturityDate.compareTo(other.getMaturityDate()) == 0) &&
                    creditLine.equals(other.getCreditLine()));
        } else {
            return false;
        }
    }


    // CLASS-SPECIFIC METHODS
    @Override
    public void deposit(BigDecimal amount) {                                                // M2 HOMEWORK STATIC
        super.deposit(amount);
        Credit.totalCreditUtilization = Credit.totalCreditUtilization.subtract(amount);
    }

    @Override
    public void withdrawal(BigDecimal amount) {                                             // M2 HOMEWORK STATIC
        BigDecimal remainingCredit = creditLine.add(getBalance());         // balance is reflected as negative for credit
        if (remainingCredit.compareTo(BigDecimal.valueOf(0)) < 0 || (amount.compareTo(remainingCredit) > 0)) {
            System.out.println("Insufficient credit line.");
        } else {
            if (super.withdrawalCheck(amount)) {
                super.withdrawal(amount);
                Credit.totalCreditUtilization = Credit.totalCreditUtilization.add(amount);
            }
        }
    }

    @Override
    public void addInterest(BigDecimal interest) {
        BigDecimal current = balance;
        super.addInterest(interest);                                                            // M3 USING STRATEGY
        updateTotalCreditBalances(current);
    }

    @Override
    public void addBonus(BigDecimal bonus) {
        BigDecimal current = balance;
        super.addBonus(bonus);                                                                  // M3 USING STRATEGY
        updateTotalCreditBalances(current);
    }

    @Override
    public void subtractFees(BigDecimal fees) {
        BigDecimal current = balance;
        super.subtractFees(fees);                                                               // M3 USING STRATEGY
        updateTotalCreditBalances(current);
    }

    // CLASS-SPECIFIC METHODS
    public static BigDecimal getTotalCreditLines() {return Credit.totalCreditLines;}             // M2 HOMEWORK STATIC

    public static BigDecimal getTotalCreditUtilization() {return Credit.totalCreditUtilization;} // M2 HOMEWORK STATIC

    public static BigDecimal totalCreditAvailable() {                                           // M2 HOMEWORK STATIC
        return Credit.totalCreditLines.subtract(Credit.totalCreditUtilization);
    }

    // HELPER METHODS
    private void addTotalCredit() {                                                             // M2 HOMEWORK STATIC
        Credit.totalCreditLines = Credit.totalCreditLines.add(creditLine);
        Credit.totalCreditUtilization = Credit.totalCreditUtilization.subtract(super.getBalance());
    }

private void updateTotalCreditBalances(BigDecimal current) {                                    // M2 HOMEWORK STATIC
        Credit.totalCreditUtilization = Credit.totalCreditUtilization.add(balance.subtract(current));
    }

}
