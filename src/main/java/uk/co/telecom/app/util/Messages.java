package uk.co.telecom.app.util;

public  enum Messages {

    PHONE_ID_NOT_FOUND(1,"Phone ID not found"),
    CUSTOMER_ID_NOT_FOUND(2,"Customer ID not found");

    private final int code;
    private final String description;

    private Messages(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
