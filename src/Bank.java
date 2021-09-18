public class Bank implements Comparable<Bank> {

    private int bankId;
    private String bankName;
    private String bankAddress;

    private static int nextBankID = 1;                                                  // M2 HOMEWORK STATIC
    private final static String DEFAULT_BANK_ADDRESS = "N/A";

    // CONSTRUCTORS
    public Bank(String bankName, String bankAddress) {
        this.bankId = nextBankID;                                                       // M2 HOMEWORK STATIC
        nextBankID++;                                                                   // M2 HOMEWORK STATIC
        this.bankName = bankName;
        this.bankAddress = bankAddress;
    }

    public Bank(String bankName) {
        this(bankName, DEFAULT_BANK_ADDRESS);
    }

    // GETTERS & SETTERS
    public int getBankId() {
        return this.bankId;
    }

    public void setBankId() {
        this.bankId = nextBankID;                                                       // M2 HOMEWORK STATIC
        nextBankID++;                                                                   // M2 HOMEWORK STATIC
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

    // OVERRIDE METHODS
    @Override
    public String toString() {
        return "Bank: \n\tID =" + bankId + "\n\tName=" + bankName + "\n\tAddress=" + bankAddress;
    }

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

    @Override
    public int compareTo(Bank obj) {
        return Integer.valueOf(bankId).compareTo(Integer.valueOf(obj.getBankId()));
    }

    // CLASS-SPECIFIC METHOD
    public static int getTotalBanks() {                                                    // M2 HOMEWORK STATIC
        return nextBankID - 1;
    }                               // M2 HOMEWORK STATIC

}
