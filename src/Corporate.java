public enum Corporate {
    CORPORATE("CORP");
    String address = "N/A";

    String abbreviation;

    Corporate(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getAddress() { return address; }
}
