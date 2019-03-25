package com.questionpro.constants;

public enum AcknowledgementType {
    DATABASE_CREATED("Database created successfully"),
    DATABASE_EXISTS("Database already exists!!"),
    TABLE_CREATED("Table created successfully"),
    TABLE_EXISTS("Table already exists"),
    DATABASE_NOT_FOUND("database not found");


    private String value;

    AcknowledgementType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

    public static AcknowledgementType getEnumForAcknowledgement(String name) {
        for (AcknowledgementType acknowledgementType : values()) {
            if (acknowledgementType.getValue().equalsIgnoreCase(name)) {
                return acknowledgementType;
            }
        }
        return null;
    }
}
