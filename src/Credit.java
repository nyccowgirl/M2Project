import java.math.BigDecimal;
import java.time.LocalDate;

public class Credit extends Account {
    private LocalDate maturityDate;
    private BigDecimal creditLine;

    private static BigDecimal totalCreditLines = new BigDecimal(0);                     // M2 HOMEWORK STATIC
    private static BigDecimal totalCreditUtilization = new BigDecimal(0);               // M2 HOMEWORK STATIC
    private static final String DEFAULT_CREDIT_NAME = "General Credit Line";
    private static final int DEFAULT_MATURITY_TERM = 5;
    private static final BigDecimal DEFAULT_CREDIT_LINE = new BigDecimal(5000);

    // CONSTRUCTORS
    public Credit(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient,
                  LocalDate open, LocalDate maturityDate, BigDecimal creditLine) {
        super(accountName, client, balance, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient,
                  LocalDate open, BigDecimal creditLine) {
        super(accountName, client, balance, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient,
                  LocalDate open, LocalDate maturityDate) {
        super(accountName, client, balance, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient,
                  LocalDate open) {
        super(accountName, client, balance, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(Client client, BigDecimal balance, boolean joint, Client jointClient, LocalDate open,
                  LocalDate maturityDate, BigDecimal creditLine) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(Client client, BigDecimal balance, boolean joint, Client jointClient, LocalDate open,
                  BigDecimal creditLine) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(Client client, BigDecimal balance, boolean joint, Client jointClient, LocalDate open,
                  LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(Client client, BigDecimal balance, boolean joint, Client jointClient, LocalDate open) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient,
                  BigDecimal creditLine, LocalDate maturityDate) {
        super(accountName, client, balance, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient,
                  BigDecimal creditLine) {
        super(accountName, client, balance, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, BigDecimal balance, boolean joint, LocalDate maturityDate,
                  Client jointClient) {
        super(accountName, client, balance, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, BigDecimal balance, boolean joint, Client jointClient) {
        super(accountName, client, balance, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(Client client, BigDecimal balance, boolean joint, Client jointClient, BigDecimal creditLine,
                  LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(Client client, BigDecimal balance, boolean joint, Client jointClient, BigDecimal creditLine) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(Client client, BigDecimal balance, boolean joint, LocalDate maturityDate, Client jointClient) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(Client client, BigDecimal balance, boolean joint, Client jointClient) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, BigDecimal balance, LocalDate open, LocalDate maturityDate,
                  BigDecimal creditLine) {
        super(accountName, client, balance, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, BigDecimal balance, LocalDate open, BigDecimal creditLine) {
        super(accountName, client, balance, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, BigDecimal balance, LocalDate open, LocalDate maturityDate) {
        super(accountName, client, balance, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, BigDecimal balance, LocalDate open) {
        super(accountName, client, balance, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, boolean joint, Client jointClient, LocalDate open,
                  LocalDate maturityDate, BigDecimal creditLine) {
        super(accountName, client, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, boolean joint, Client jointClient, LocalDate open,
                  BigDecimal creditLine) {
        super(accountName, client, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, boolean joint, Client jointClient, LocalDate open,
                  LocalDate maturityDate) {
        super(accountName, client, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, boolean joint, Client jointClient, LocalDate open) {
        super(accountName, client, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(Client client, boolean joint, Client jointClient, LocalDate open, LocalDate maturityDate,
                  BigDecimal creditLine) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(Client client, boolean joint, Client jointClient, LocalDate open, BigDecimal creditLine) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(Client client, boolean joint, Client jointClient, LocalDate open, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(Client client, boolean joint, Client jointClient, LocalDate open) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, BigDecimal balance, BigDecimal creditLine, LocalDate maturityDate) {
        super(accountName, client, balance);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, BigDecimal balance, BigDecimal creditLine) {
        super(accountName, client, balance);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, LocalDate maturityDate, BigDecimal balance) {
        super(accountName, client, balance);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, BigDecimal balance) {
        super(accountName, client, balance);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(Client client, BigDecimal balance, LocalDate maturityDate, BigDecimal creditLine) {
        super(DEFAULT_CREDIT_NAME, client, balance);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(Client client, BigDecimal balance, BigDecimal creditLine) {
        super(DEFAULT_CREDIT_NAME, client, balance);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(Client client, BigDecimal balance, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, client, balance);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(Client client, BigDecimal balance) {
        super(DEFAULT_CREDIT_NAME, client, balance);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(balance, creditLine);                                                     // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, boolean joint, Client jointClient, BigDecimal creditLine,
                  LocalDate maturityDate) {
        super(accountName, client, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, boolean joint, Client jointClient, BigDecimal creditLine) {
        super(accountName, client, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, boolean joint, LocalDate maturityDate, Client jointClient) {
        super(accountName, client, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, boolean joint, Client jointClient) {
        super(accountName, client, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(Client client, boolean joint, Client jointClient, BigDecimal creditLine, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(Client client, boolean joint, Client jointClient, BigDecimal creditLine) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(Client client, boolean joint, LocalDate maturityDate, Client jointClient) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(Client client, boolean joint, Client jointClient) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, LocalDate open, LocalDate maturityDate, BigDecimal creditLine) {
        super(accountName, client, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, BigDecimal creditLine, Client client, LocalDate open) {
        super(accountName, client, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, LocalDate open, LocalDate maturityDate) {
        super(accountName, client, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client, LocalDate open) {
        super(accountName, client, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(Client client, LocalDate open, LocalDate maturityDate, BigDecimal creditLine) {
        super(DEFAULT_CREDIT_NAME, client, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(Client client, LocalDate open, BigDecimal creditLine) {
        super(DEFAULT_CREDIT_NAME, client, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(Client client, LocalDate open, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, client, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(Client client, LocalDate open) {
        super(DEFAULT_CREDIT_NAME, client, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(BigDecimal creditLine, String accountName, Client client, LocalDate maturityDate) {
        super(accountName, client);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(BigDecimal creditLine, String accountName, Client client) {
        super(accountName, client);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, LocalDate maturityDate, Client client) {
        super(accountName, client);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(String accountName, Client client) {
        super(accountName, client);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(BigDecimal creditLine, Client client, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, client);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(BigDecimal creditLine, Client client) {
        super(DEFAULT_CREDIT_NAME, client);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(LocalDate maturityDate, Client client) {
        super(DEFAULT_CREDIT_NAME, client);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    public Credit(Client client) {
        super(DEFAULT_CREDIT_NAME, client);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
        addTotalCredit(super.getBalance(), creditLine);                                          // M2 HOMEWORK STATIC
    }

    // GETTERS/SETTERS
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
                df.format(creditLine.setScale(super.DECIMALS, super.ROUNDING_MODE));
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
    private void addTotalCredit(BigDecimal balance, BigDecimal creditLine) {
        Credit.totalCreditLines = Credit.totalCreditLines.add(creditLine);                  // M2 HOMEWORK STATIC
        Credit.totalCreditUtilization = Credit.totalCreditUtilization.subtract(balance);    // M2 HOMEWORK STATIC
    }
}
