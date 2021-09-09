import java.time.LocalDate;
import java.lang.Math;

public class Credit extends Account {
    private LocalDate maturityDate;
    private double creditLine;

    private static final String DEFAULT_CREDIT_NAME = "General Credit Line";
    private static final int DEFAULT_MATURITY_TERM = 5;
    private static final double DEFAULT_CREDIT_LINE = 5000;

    // Constructors
    public Credit(String accountName, int clientID, double balance, boolean joint, int jointID, LocalDate open,
                  LocalDate maturityDate, double creditLine) {
        super(accountName, clientID, balance, joint, jointID, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(String accountName, int clientID, double balance, boolean joint, int jointID, LocalDate open,
                  double creditLine) {
        super(accountName, clientID, balance, joint, jointID, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, int clientID, double balance, boolean joint, int jointID, LocalDate open,
                  LocalDate maturityDate) {
        super(accountName, clientID, balance, joint, jointID, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, int clientID, double balance, boolean joint, int jointID, LocalDate open) {
        super(accountName, clientID, balance, joint, jointID, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(int clientID, double balance, boolean joint, int jointID, LocalDate open, LocalDate maturityDate,
                  double creditLine) {
        super(DEFAULT_CREDIT_NAME, clientID, balance, joint, jointID, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(int clientID, double balance, boolean joint, int jointID, LocalDate open, double creditLine) {
        super(DEFAULT_CREDIT_NAME, clientID, balance, joint, jointID, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(int clientID, double balance, boolean joint, int jointID, LocalDate open, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, clientID, balance, joint, jointID, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(int clientID, double balance, boolean joint, int jointID, LocalDate open) {
        super(DEFAULT_CREDIT_NAME, clientID, balance, joint, jointID, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }


    public Credit(String accountName, int clientID, double balance, boolean joint, int jointID, double creditLine,
                  LocalDate maturityDate) {
        super(accountName, clientID, balance, joint, jointID);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(String accountName, int clientID, double balance, boolean joint, int jointID, double creditLine) {
        super(accountName, clientID, balance, joint, jointID);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, int clientID, double balance, boolean joint, LocalDate maturityDate, int jointID) {
        super(accountName, clientID, balance, joint, jointID);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, int clientID, double balance, boolean joint, int jointID) {
        super(accountName, clientID, balance, joint, jointID);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(int clientID, double balance, boolean joint, int jointID, double creditLine,
                  LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, clientID, balance, joint, jointID);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(int clientID, double balance, boolean joint, int jointID, double creditLine) {
        super(DEFAULT_CREDIT_NAME, clientID, balance, joint, jointID);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(int clientID, double balance, boolean joint, LocalDate maturityDate, int jointID) {
        super(DEFAULT_CREDIT_NAME, clientID, balance, joint, jointID);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }


    public Credit(int clientID, double balance, boolean joint, int jointID) {
        super(DEFAULT_CREDIT_NAME, clientID, balance, joint, jointID);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, int clientID, double balance, LocalDate open, LocalDate maturityDate,
                  double creditLine) {
        super(accountName, clientID, balance, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(String accountName, int clientID, double balance, LocalDate open, double creditLine) {
        super(accountName, clientID, balance, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, int clientID, double balance, LocalDate open, LocalDate maturityDate) {
        super(accountName, clientID, balance, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, int clientID, double balance, LocalDate open) {
        super(accountName, clientID, balance, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, int clientID, boolean joint, int jointID, LocalDate open, LocalDate maturityDate,
                  double creditLine) {
        super(accountName, clientID, joint, jointID, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(String accountName, int clientID, boolean joint, int jointID, LocalDate open, double creditLine) {
        super(accountName, clientID, joint, jointID, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, int clientID, boolean joint, int jointID, LocalDate open, LocalDate maturityDate) {
        super(accountName, clientID, joint, jointID, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, int clientID, boolean joint, int jointID, LocalDate open) {
        super(accountName, clientID, joint, jointID, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(int clientID, boolean joint, int jointID, LocalDate open, LocalDate maturityDate,
                  double creditLine) {
        super(DEFAULT_CREDIT_NAME, clientID, joint, jointID, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(int clientID, boolean joint, int jointID, LocalDate open, double creditLine) {
        super(DEFAULT_CREDIT_NAME, clientID, joint, jointID, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(int clientID, boolean joint, int jointID, LocalDate open, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, clientID, joint, jointID, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(int clientID, boolean joint, int jointID, LocalDate open) {
        super(DEFAULT_CREDIT_NAME, clientID, joint, jointID, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, int clientID, double balance, double creditLine, LocalDate maturityDate) {
        super(accountName, clientID, balance);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(String accountName, int clientID, double balance, double creditLine) {
        super(accountName, clientID, balance);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, int clientID, LocalDate maturityDate, double balance) {
        super(accountName, clientID, balance);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, int clientID, double balance) {
        super(accountName, clientID, balance);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(int clientID, double balance, LocalDate maturityDate, double creditLine) {
        super(DEFAULT_CREDIT_NAME, clientID, balance);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(int clientID, double balance, double creditLine) {
        super(DEFAULT_CREDIT_NAME, clientID, balance);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(int clientID, double balance, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, clientID, balance);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(int clientID, double balance) {
        super(DEFAULT_CREDIT_NAME, clientID, balance);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, int clientID, boolean joint, int jointID, double creditLine,
                  LocalDate maturityDate) {
        super(accountName, clientID, joint, jointID);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(String accountName, int clientID, boolean joint, int jointID, double creditLine) {
        super(accountName, clientID, joint, jointID);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, int clientID, boolean joint, LocalDate maturityDate, int jointID) {
        super(accountName, clientID, joint, jointID);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, int clientID, boolean joint, int jointID) {
        super(accountName, clientID, joint, jointID);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(int clientID, boolean joint, int jointID, double creditLine, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, clientID, joint, jointID);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(int clientID, boolean joint, int jointID, double creditLine) {
        super(DEFAULT_CREDIT_NAME, clientID, joint, jointID);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(int clientID, boolean joint, LocalDate maturityDate, int jointID) {
        super(DEFAULT_CREDIT_NAME, clientID, joint, jointID);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(int clientID, boolean joint, int jointID) {
        super(DEFAULT_CREDIT_NAME, clientID, joint, jointID);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, int clientID, LocalDate open, LocalDate maturityDate, double creditLine) {
        super(accountName, clientID, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(String accountName, double creditLine, int clientID, LocalDate open) {
        super(accountName, clientID, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, int clientID, LocalDate open, LocalDate maturityDate) {
        super(accountName, clientID, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, int clientID, LocalDate open) {
        super(accountName, clientID, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(int clientID, LocalDate open, LocalDate maturityDate, double creditLine) {
        super(DEFAULT_CREDIT_NAME, clientID, open);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(int clientID, LocalDate open, double creditLine) {
        super(DEFAULT_CREDIT_NAME, clientID, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(int clientID, LocalDate open, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, clientID, open);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(int clientID, LocalDate open) {
        super(DEFAULT_CREDIT_NAME, clientID, open);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(double creditLine, String accountName, int clientID, LocalDate maturityDate) {
        super(accountName, clientID);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(double creditLine, String accountName, int clientID) {
        super(accountName, clientID);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(String accountName, LocalDate maturityDate, int clientID) {
        super(accountName, clientID);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(String accountName, int clientID) {
        super(accountName, clientID);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(double creditLine, int clientID, LocalDate maturityDate) {
        super(DEFAULT_CREDIT_NAME, clientID);
        this.maturityDate = maturityDate;
        this.creditLine = creditLine;
    }

    public Credit(double creditLine, int clientID) {
        super(DEFAULT_CREDIT_NAME, clientID);
        this.maturityDate = super.getOpen().plusYears(DEFAULT_MATURITY_TERM);
        this.creditLine = creditLine;
    }

    public Credit(LocalDate maturityDate, int clientID) {
        super(DEFAULT_CREDIT_NAME, clientID);
        this.maturityDate = maturityDate;
        this.creditLine = DEFAULT_CREDIT_LINE;
    }

    public Credit(int clientID) {
        super(DEFAULT_CREDIT_NAME, clientID);
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
