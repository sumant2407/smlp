package com.questionpro;

import com.questionpro.constants.CommandArgType;

public class CommandParams {
    public static String getCommandParams(CommandArgType cmdType, String cmdInput) {
        String cmdArray[] = cmdInput.split(" ");
        if (cmdType.equals(CommandArgType.CREATE_DATABASE)) {
            return cmdArray[2];
        } else if (cmdType.equals(CommandArgType.CREATE_TABLE) ||
                cmdType.equals(CommandArgType.INSERT_INTO_TABLE)) {
            return getTableName(cmdArray[2]);
        }
        return " ";
    }

    public static String getCommandClause(String cmdInput) {
        return cmdInput.substring(cmdInput.indexOf("(")+1, cmdInput.indexOf(")"));
    }

    public static String getTableName(String tableName) {
        return tableName.split("\\.")[1];
    }

    public static String getDbName(String cmdInput) {
        String cmdArray[] = cmdInput.split(" ");
        System.out.println(cmdArray);
        return cmdArray[2].split("\\.")[1];
    }
}
