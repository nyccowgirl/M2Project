import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Client implements Comparable<Client> {

    private int clientId;
    private String clientName;
    private String clientAddress;
    private Bank branch;
    private List<Account> accountList;                                                  // M3 USING FACTORY

    private static int nextClientID = 1;                                                // M2 HOMEWORK STATIC
    private final static String DEFAULT_CLIENT_ADDRESS = "N/A";

    // CONSTRUCTORS
    public Client(String clientName, String clientAddress, Bank branch) {
        this.clientId = nextClientID;                                                   // M2 HOMEWORK STATIC
        nextClientID++;                                                                 // M2 HOMEWORK STATIC
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.branch = branch;
        this.accountList = new ArrayList<>();
    }

    public Client(String clientName, Bank branch) {
        this(clientName, DEFAULT_CLIENT_ADDRESS, branch);
    }

    // GETTERS/SETTERS
    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public List<Account> getAccountList() {                                                              // M3 USING FACTORY
        return accountList;
    }

    // OVERRIDE METHODS
    @Override
    public String toString() {
        return "Client: \n\tID: " + clientId + "\n\tName: " + clientName + "\n\tAddress: " + clientAddress +
                "\n\tBranch: " + branch.getBankId() + " " + branch.getBankName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Client) {
            Client other = (Client) obj;
            return (clientId == other.getClientId() && clientName.equalsIgnoreCase(other.getClientName()) &&
                    clientAddress.equalsIgnoreCase(other.getClientAddress()) && branch.equals(other.getBranch()));
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Client obj) {
        if (clientName.compareTo(obj.getClientName()) != 0) {
            return clientName.compareTo(obj.getClientName());
        } else {
            return clientAddress.compareTo((obj.getClientAddress()));
        }
    }

    // CLASS-SPECIFIC METHODS
    public static int getTotalClients() {                                                        // M2 HOMEWORK STATIC
        return nextClientID - 1;
    }                           // M2 HOMEWORK STATIC

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
}
