package com.questionpro;

import com.questionpro.constants.CommandArgType;

public class CommandParams {
    public static String getCommandParams(CommandArgType cmdType, String cmdInput) {
        String cmdArray[] = cmdInput.split(" ");
        if (cmdType.getValue().contains(CommandArgType.CREATE_DATABASE.getValue())) {
            return cmdArray[2];
        } else if (cmdType.getValue().contains(CommandArgType.CREATE_TABLE.getValue()) ||
                cmdType.getValue().contains(CommandArgType.INSERT_INTO_TABLE.getValue())) {
            return getTableName(cmdArray[2]);
        } else if(cmdType.getValue().contains(CommandArgType.SELECT_ALL.getValue())||
                cmdType.getValue().contains(CommandArgType.SIMPLE_SELECT.getValue())) {
            return getTableName(cmdArray[3]);
        }
        return " ";
    }

    public static String getCommandClause(String cmdInput) {
        return cmdInput.contains("(") ? cmdInput.substring(cmdInput.indexOf("(") + 1, cmdInput.indexOf(")")) :
                CommandArgType.EMPTY.getValue();
    }

    public static String getTableName(String tableNameWithDB) {
        return tableNameWithDB.contains("\\.")? tableNameWithDB.split("\\.")[1]: tableNameWithDB;
    }

    public static String extractOnlyDBName(String tableNameWithDB) {
        return tableNameWithDB.contains("\\.")? tableNameWithDB.split("\\.")[0]: tableNameWithDB;
    }

    public static String getWhereClause(String cmdInput) {
        String cmdArray[] = cmdInput.split("where");
        if(cmdInput.contains(" where ")) {
            return cmdArray[1];
        }
        return CommandArgType.EMPTY.getValue();
    }

    public static String getSelectConditionClause(String cmdInput) {
        String cmdArray[] = cmdInput.split("where");
        if (cmdArray[0].contains("(")) {
            cmdArray[0].substring(cmdArray[0].indexOf("(") + 1, cmdArray[0].indexOf(")"));
        }
        return CommandArgType.EMPTY.getValue();
    }

    public static String getDbName(String cmdInput) {
        String cmdArray[] = cmdInput.split(" ");
        System.out.println(cmdArray);
        return cmdArray[2];
    }
}
