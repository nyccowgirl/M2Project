public class Bank {

    private int bankId;
    private String bankName;
    private String bankAddress;

    // Future versions: increment bankID within the class, similar to Account class to avoid duplication.
    private final static String DEFAULT_BANK_ADDRESS = "Zoneless";

    // Constructors
    public Bank(int bankId, String bankName, String bankAddress) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.bankAddress = bankAddress;
    }

    public Bank(int bankId, String bankName) {
        this(bankId, bankName, DEFAULT_BANK_ADDRESS);
    }

    // Getters and Setters
    public int getBankId() {
        return this.bankId;
    }
    public void setBankId(int bankId) {
        this.bankId = bankId;
    }
    public String getBankName() {
        return this.bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankAddress() {
        return this.bankAddress;
    }
    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }


    // toString
    @Override
    public String toString() {
        return "Bank: \n\tID =" + bankId + "\n\tName=" + bankName + "\n\tAddress=" + bankAddress;
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bank) {
            Bank other = (Bank) obj;
            return (bankId == other.getBankId() && bankName.equalsIgnoreCase(other.getBankName()) &&
                    bankAddress.equalsIgnoreCase(other.getBankAddress()));
        } else {
            return false;
        }
    }
}
