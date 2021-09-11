public class Client implements Comparable<Client> {

    // Future versions: consider adding in Bank object for branch that services each client and to link the classes.
    private int clientId;
    private String clientName;
    private String clientAddress;
    private Bank branch;

    private static int nextClientID = 1;                            // M2 HOMEWORK STATIC
    private final static String DEFAULT_CLIENT_ADDRESS = "N/A";

    // Constructors
    public Client(String clientName, String clientAddress, Bank branch) {
        this.clientId = nextClientID;                               // M2 HOMEWORK STATIC
        nextClientID++;                                             // M2 HOMEWORK STATIC
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.branch = branch;
    }

    public Client(String clientName, Bank branch) {
        this(clientName, DEFAULT_CLIENT_ADDRESS, branch);
    }

    // Getters and Setters
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

    // toString
    @Override
    public String toString() {
        return "Client: \n\tID: " + clientId + "\n\tName: " + clientName + "\n\tAddress: " + clientAddress +
                "\n\tBranch: " + branch.getBankId() + " " + branch.getBankName();
    }

    // equals
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
}
