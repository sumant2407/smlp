package com.questionpro.constants;

public enum CommandArgType {
    CREATE_DATABASE("create database "),
    CREATE_TABLE("create table "),
    INSERT_INTO_TABLE("insert into "),
    SELECT_ALL("select * from"),
    SIMPLE_SELECT("select ("),
    EMPTY(" ");

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
