public enum AccountType {

    CHECKING("CHK"), SAVINGS("SAV"), CREDIT("CRED"), NOT_APPLICABLE("N/A");

    private String abbreviation;

    AccountType(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

}
