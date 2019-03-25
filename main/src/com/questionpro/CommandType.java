package com.questionpro;

import com.questionpro.constants.CommandArgType;

public class CommandType {

    public static CommandArgType getCommandType(String cmdInput) {

        //String cmdArray[] = cmdInput.split(" ");

        if (cmdInput.contains(CommandArgType.CREATE_DATABASE.getValue())) {
            return CommandArgType.CREATE_DATABASE;
        } else if (cmdInput.contains(CommandArgType.CREATE_TABLE.getValue())) {
            return CommandArgType.CREATE_TABLE;
        } else if (cmdInput.contains(CommandArgType.SELECT_ALL.getValue())) {
            return CommandArgType.SELECT_ALL;
        }
        return CommandArgType.EMPTY;
    }
}
