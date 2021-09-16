import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Client implements Comparable<Client> {

    private int clientId;
    private String clientLastName;
    private String clientFirstName;
    private String clientAddress;
    private Bank branch;
    private List<Account> accountList;                                                  // M3 USING FACTORY

    private static int nextClientID = 1;                                                // M2 HOMEWORK STATIC
    private final static Bank DEFAULT_CORP = new Bank(Corporate.CORPORATE.name(), Corporate.CORPORATE.getAddress());  // M2 HOMEWORK ENUM USE


    // CONSTRUCTORS
    public Client(Builder builder) {
        this.clientId = builder.clientID;
        this.clientLastName = builder.clientLastName;
        this.clientFirstName = builder.clientFirstName;
        this.clientAddress = builder.clientAddress;
        this.branch = builder.branch;
        this.accountList = builder.accountList;
    }

    public static class Builder {
        private int clientID;
        private String clientLastName, clientFirstName;

        private String clientAddress = "";
        private Bank branch = Corporate.getCorp();                                      // M2 HOMEWORK ENUM USE
        private List<Account> accountList = new ArrayList<>();

        public Builder(String clientLastName, String clientFirstName) {
            this.clientID = nextClientID;                                                 // M2 HOMEWORK STATIC
            nextClientID++;                                                               // M2 HOMEWORK STATIC
            this.clientLastName = clientLastName;
            this.clientFirstName = clientFirstName;
        }

        public Builder clientAddress(String clientAddress) {
            this.clientAddress = clientAddress;
            return this;
        }

        public Builder branch(Bank branch) {
            this.branch = branch;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    // GETTERS & SETTERS
    public int getClientId() {
        return clientId;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Bank getBranch() {
        return branch;
    }

    public void setBranch(Bank branch) {
        this.branch = branch;
    }

    public List<Account> getAccountList() {                                                 // M3 USING FACTORY
        return accountList;
    }

    // OVERRIDE METHODS
    @Override
    public String toString() {
        return "Client: \n\tID: " + clientId + "\n\tName: " + clientFirstName + " " + clientLastName +
                "\n\tAddress: " + clientAddress + "\n\tBranch: " + branch.getBankId() + " " + branch.getBankName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Client) {
            Client other = (Client) obj;
            return (clientId == other.getClientId() && clientLastName.equalsIgnoreCase(other.getClientLastName()) &&
                    clientFirstName.equalsIgnoreCase(other.getClientFirstName()) &&
                    clientAddress.equalsIgnoreCase(other.getClientAddress()) && branch.equals(other.getBranch()));
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Client obj) {
        if (clientLastName.compareTo(obj.getClientLastName()) != 0) {
            return clientFirstName.compareTo(obj.getClientFirstName());
        } else {
            return clientLastName.compareTo((obj.getClientLastName()));
        }
    }

    // CLASS-SPECIFIC METHODS
    public static int getTotalClients() {                                                        // M2 HOMEWORK STATIC
        return nextClientID - 1;
    }                           // M2 HOMEWORK STATIC

    public static Bank getDefaultCorp() {                                                       // M2 HOMEWORK STATIC
        return DEFAULT_CORP;
    }

    public void addAccount(Account acc) {                                                       // M3 USING FACTORY
        accountList.add(acc);
    }

    public void addAccount(AccountType type, Client client) {                                   // M3 USING FACTORY
        Account a = AccountFactory.newAccount(type, client);
        addAccount(a);
    }

    public void addAccount(AccountType type, Client client, BigDecimal balance) {                                   // M3 USING FACTORY
        Account a = AccountFactory.newAccount(type, client, balance);
        addAccount(a);
    }

    // COMPARATOR CLASSES
    static class SortByClientID implements Comparator<Client> {

        public int compare(Client a, Client b) {
            return Integer.compare(a.getClientId(), b.getClientId());
        }
    }

    static class SortByLastName implements Comparator<Client> {

        public int compare(Client a, Client b) {
            return a.clientLastName.compareToIgnoreCase(b.clientLastName);
        }
    }

    static class SortByFirstName implements Comparator<Client> {

        public int compare(Client a, Client b) {
            return a.clientFirstName.compareToIgnoreCase(b.clientFirstName);
        }
    }
}
