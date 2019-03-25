package com.questionpro.constants;

public enum CommandArgType {
    CREATE_DATABASE("create database"),
    CREATE_TABLE("create table");

    private String value;

    CommandArgType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CommandArgType getEnumForCommandType(String name) {
        for (CommandArgType cmdType : values()) {
            if (cmdType.getValue().equalsIgnoreCase(name)) {
                return cmdType;
            }
        }
        return null;
    }

}
