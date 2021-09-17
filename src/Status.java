public enum Status {                                                // M2 HOMEWORK ENUM
    ACTIVE("A"), CLOSED("C"), SUSPENDED("S");

    String abbreviation;

    Status(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
