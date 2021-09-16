public enum Corporate {
    CORPORATE("CORP"), NOT_APPLICABLE("N/A");
    String address = "N/A";

    String abbreviation;

    Corporate(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getAddress() { return address; }

    public static Bank getCorp() {
        return new Bank(CORPORATE.name(), CORPORATE.getAddress());
    }
}
