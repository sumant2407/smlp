package com.questionpro;

import com.questionpro.constants.CommandArgType;

public class CommandParams {
    public static String getCommandParams(CommandArgType cmdType, String cmdInput) {
        String cmdArray[] = cmdInput.split(" ");
        if (cmdType.equals(CommandArgType.CREATE_DATABASE)) {
            return cmdArray[2];
        } else if (cmdType.equals(CommandArgType.CREATE_TABLE)) {
            return getTableName(cmdArray[2]);
        }
        return " ";
    }

    public static String getCreateCommandClause(String cmdInput) {
        return cmdInput.substring(cmdInput.indexOf("(")+1, cmdInput.indexOf(")"));
    }

    private static String getTableName(String tableNameWithDB) {
        return tableNameWithDB.split("\\.")[1];
    }

    public static String getDbName(String cmdInput) {
        String cmdArray[] = cmdInput.split(" ");
        System.out.println(cmdArray);
        return cmdArray[2].split("\\.")[1];
    }
}
