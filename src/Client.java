public class Client {

    // Future versions: consider adding in Bank object for branch that services each client and to link the classes.
    private int clientId;
    private String clientName;
    private String clientAddress;

    private static int nextClientID = 1;                            // M2 HOMEWORK STATIC
    private final static String DEFAULT_CLIENT_ADDRESS = "N/A";

    // Constructors
    public Client(String clientName, String clientAddress) {
        this.clientId = nextClientID;                               // M2 HOMEWORK STATIC
        nextClientID++;                                             // M2 HOMEWORK STATIC
        this.clientName = clientName;
        this.clientAddress = clientAddress;
    }

    public Client(String clientName) {
        this(clientName, DEFAULT_CLIENT_ADDRESS);
    }

    // Getters and Setters
    public int getClientId() {
        return this.clientId;
    }
    public void setClientId() {
        this.clientId = nextClientID;                               // M2 HOMEWORK STATIC
        nextClientID++;                                             // M2 HOMEWORK STATIC
    }
    public String getClientName() {
        return this.clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public String getClientAddress() {
        return this.clientAddress;
    }
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    // toString
    @Override
    public String toString() {
        return "Client: \n\tID =" + clientId + "\n\tName=" + clientName + "\n\tAddress=" + clientAddress;
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Client) {
            Client other = (Client) obj;
            return (clientId == other.getClientId() && clientName.equalsIgnoreCase(other.getClientName()) &&
                    clientAddress.equalsIgnoreCase(other.getClientAddress()));
        } else {
            return false;
        }
    }
}
