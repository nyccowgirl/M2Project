import java.time.LocalDate;
import java.lang.Math;

public class Credit extends Account {
    private LocalDate maturityDate;
    private double creditLine;

    private static final String DEFAULT_CREDIT_NAME = "General Credit Line";
    private static final int DEFAULT_MATURITY_TERM = 5;
    private static final double DEFAULT_CREDIT_LINE = 5000;

    // Constructors
    public Credit(String accountName, Client client, double balance, boolean joint, Client jointClient, LocalDate open,
                  LocalDate maturityDate, double creditLine) {
        super(accountName, client, balance, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(String accountName, Client client, double balance, boolean joint, Client jointClient, LocalDate open,
                  double creditLine) {
        super(accountName, client, balance, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, Client client, double balance, boolean joint, Client jointClient, LocalDate open,
                  LocalDate maturityDate) {
        super(accountName, client, balance, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, Client client, double balance, boolean joint, Client jointClient, LocalDate open) {
        super(accountName, client, balance, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(Client client, double balance, boolean joint, Client jointClient, LocalDate open, LocalDate maturityDate,
                  double creditLine) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(Client client, double balance, boolean joint, Client jointClient, LocalDate open, double creditLine) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(Client client, double balance, boolean joint, Client jointClient, LocalDate open, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(Client client, double balance, boolean joint, Client jointClient, LocalDate open) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, Client client, double balance, boolean joint, Client jointClient, double creditLine,
                  LocalDate maturityDate) {
        super(accountName, client, balance, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(String accountName, Client client, double balance, boolean joint, Client jointClient, double creditLine) {
        super(accountName, client, balance, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, Client client, double balance, boolean joint, LocalDate maturityDate,
                  Client jointClient) {
        super(accountName, client, balance, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, Client client, double balance, boolean joint, Client jointClient) {
        super(accountName, client, balance, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(Client client, double balance, boolean joint, Client jointClient, double creditLine,
                  LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(Client client, double balance, boolean joint, Client jointClient, double creditLine) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(Client client, double balance, boolean joint, LocalDate maturityDate, Client jointClient) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(Client client, double balance, boolean joint, Client jointClient) {
        super(DEFAULT_CREDIT_NAME, client, balance, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, Client client, double balance, LocalDate open, LocalDate maturityDate,
                  double creditLine) {
        super(accountName, client, balance, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(String accountName, Client client, double balance, LocalDate open, double creditLine) {
        super(accountName, client, balance, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, Client client, double balance, LocalDate open, LocalDate maturityDate) {
        super(accountName, client, balance, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, Client client, double balance, LocalDate open) {
        super(accountName, client, balance, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, Client client, boolean joint, Client jointClient, LocalDate open, LocalDate maturityDate,
                  double creditLine) {
        super(accountName, client, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(String accountName, Client client, boolean joint, Client jointClient, LocalDate open, double creditLine) {
        super(accountName, client, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, Client client, boolean joint, Client jointClient, LocalDate open, LocalDate maturityDate) {
        super(accountName, client, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, Client client, boolean joint, Client jointClient, LocalDate open) {
        super(accountName, client, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(Client client, boolean joint, Client jointClient, LocalDate open, LocalDate maturityDate,
                  double creditLine) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(Client client, boolean joint, Client jointClient, LocalDate open, double creditLine) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(Client client, boolean joint, Client jointClient, LocalDate open, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(Client client, boolean joint, Client jointClient, LocalDate open) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, Client client, double balance, double creditLine, LocalDate maturityDate) {
        super(accountName, client, balance);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(String accountName, Client client, double balance, double creditLine) {
        super(accountName, client, balance);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, Client client, LocalDate maturityDate, double balance) {
        super(accountName, client, balance);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, Client client, double balance) {
        super(accountName, client, balance);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(Client client, double balance, LocalDate maturityDate, double creditLine) {
        super(DEFAULT_CREDIT_NAME, client, balance);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(Client client, double balance, double creditLine) {
        super(DEFAULT_CREDIT_NAME, client, balance);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(Client client, double balance, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, client, balance);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(Client client, double balance) {
        super(DEFAULT_CREDIT_NAME, client, balance);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, Client client, boolean joint, Client jointClient, double creditLine,
                  LocalDate maturityDate) {
        super(accountName, client, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(String accountName, Client client, boolean joint, Client jointClient, double creditLine) {
        super(accountName, client, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, Client client, boolean joint, LocalDate maturityDate, Client jointClient) {
        super(accountName, client, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, Client client, boolean joint, Client jointClient) {
        super(accountName, client, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(Client client, boolean joint, Client jointClient, double creditLine, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(Client client, boolean joint, Client jointClient, double creditLine) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(Client client, boolean joint, LocalDate maturityDate, Client jointClient) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(Client client, boolean joint, Client jointClient) {
        super(DEFAULT_CREDIT_NAME, client, joint, jointClient);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, Client client, LocalDate open, LocalDate maturityDate, double creditLine) {
        super(accountName, client, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(String accountName, double creditLine, Client client, LocalDate open) {
        super(accountName, client, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, Client client, LocalDate open, LocalDate maturityDate) {
        super(accountName, client, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, Client client, LocalDate open) {
        super(accountName, client, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(Client client, LocalDate open, LocalDate maturityDate, double creditLine) {
        super(DEFAULT_CREDIT_NAME, client, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(Client client, LocalDate open, double creditLine) {
        super(DEFAULT_CREDIT_NAME, client, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(Client client, LocalDate open, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, client, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(Client client, LocalDate open) {
        super(DEFAULT_CREDIT_NAME, client, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(double creditLine, String accountName, Client client, LocalDate maturityDate) {
        super(accountName, client);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(double creditLine, String accountName, Client client) {
        super(accountName, client);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, LocalDate maturityDate, Client client) {
        super(accountName, client);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, Client client) {
        super(accountName, client);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(double creditLine, Client client, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, client);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(double creditLine, Client client) {
        super(DEFAULT_CREDIT_NAME, client);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(LocalDate maturityDate, Client client) {
        super(DEFAULT_CREDIT_NAME, client);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(Client client) {
        super(DEFAULT_CREDIT_NAME, client);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    // Getters and Setters

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        // Updates maturity date if it is same or later date than open date
        if (maturityDate.compareTo(super.getOpen()) >= 0) {
            this.maturityDate = maturityDate;
        }
    }

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        if (creditLine >= Math.abs(super.getBalance())) {
            this.creditLine = creditLine;
        }
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "\n\tMaturity Date: " + maturityDate + "\n\tCredit Limit: " + creditLine;
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Credit) {
            Credit other = (Credit) obj;
            return (super.equals(obj) && (maturityDate.compareTo(other.getMaturityDate()) == 0) &&
                    (Math.abs(creditLine - other.getCreditLine()) < .01));
        } else {
            return false;
        }
    }

    // Class-specific method
    @Override
    public void withdrawal(double amount) {
        double remainingCredit = creditLine + getBalance();         // balance is reflected as negative for credit
        if (remainingCredit < 0 || (-amount > remainingCredit)) {
            System.out.println("Insufficient credit line.");
        } else {
            super.withdrawal(amount);
        }
    }
}
