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
    }

    private Credit() {

    }

    /*
    protected Credit(Builder builder) {
        super(builder);
        this.maturityDate = builder.maturityDate;
        this.creditLine = builder.creditLine;
        addTotalCredit();
    }

     */

    public static class Builder extends Account.Builder<Credit, Credit.Builder> {

//        private LocalDate maturityDate = super.account.getOpen().plusYears(DEFAULT_MATURITY_TERM);
//        private BigDecimal creditLine = new BigDecimal(5000);

        private String DEFAULT_CREDIT_ACCOUNT_NAME = "General Credit Account";

        public Builder(Client client) {
            super(client);
        }

        public Builder accountName() {
            super.accountName(DEFAULT_CREDIT_ACCOUNT_NAME);
            return builder;
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
    /*
    public static class Builder extends Account.Builder<Builder> {

        private String accountName = "General Credit Line";
        private LocalDate maturityDate = super.build().getOpen().plusYears(DEFAULT_MATURITY_TERM);
        private BigDecimal creditLine = new BigDecimal(5000);

        public Builder(Client client) {
            super(client);
//            accountName(accountName);
        }

        public Builder maturityDate(LocalDate maturityDate) {
            if (maturityDate.compareTo(super.build().getOpen()) >= 0) {
                this.maturityDate = maturityDate;
            }
            return this;
        }

        public Builder creditLine(BigDecimal creditLine) {
            this.creditLine = creditLine;
            return this;
        }

        // IS THIS NEEDED IF EVERYTHING IS CASTED?
        public Credit build() {
            return new Credit(this);
        }
    }

     */

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

    public static BigDecimal getTotalCreditLines() {                                // M2 HOMEWORK STATIC
        return Credit.totalCreditLines;
    }

    public static BigDecimal getTotalCreditUtilization() {                          // M2 HOMEWORK STATIC
        return Credit.totalCreditUtilization;
    }

    public static BigDecimal totalCreditAvailable() {                                       // M2 HOMEWORK STATIC
        return Credit.totalCreditLines.subtract(Credit.totalCreditUtilization);
    }

    // HELPER METHOD
    private void addTotalCredit() {
        Credit.totalCreditLines = Credit.totalCreditLines.add(creditLine);                  // M2 HOMEWORK STATIC
        Credit.totalCreditUtilization = Credit.totalCreditUtilization.subtract(super.getBalance()); // M2 HOMEWORK STATIC
    }
}
