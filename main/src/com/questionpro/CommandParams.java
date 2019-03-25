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
        } else if(cmdType.equals(CommandArgType.SELECT_ALL)) {
            return getTableName(cmdArray[3]);
        }
        return " ";
    }

    public static String getCommandClause(String cmdInput) {
        return cmdInput.contains("(") ? cmdInput.substring(cmdInput.indexOf("(") + 1, cmdInput.indexOf(")")) :
                CommandArgType.EMPTY.getValue();
    }

    public static String getTableName(String tableName) {
        return tableName.contains("\\.")? tableName.split("\\.")[1]: tableName;
    }

    public static String getWhereClause(String cmdInput) {
        String cmdArray[] = cmdInput.split("where");
        if(cmdInput.contains(" where ")) {
            return cmdArray[1];
        }
        return CommandArgType.EMPTY.getValue();
    }

    public static String getDbName(String cmdInput) {
        String cmdArray[] = cmdInput.split(" ");
        System.out.println(cmdArray);
        return cmdArray[2];
    }
}
