package com.questionpro;

import com.questionpro.constants.CommandArgType;

public class CommandType {

    public static CommandArgType getCommandType(String cmdInput) {
        String cmdArray[] = cmdInput.split(" ");
        if((cmdArray[0] + " " + cmdArray[1]).equals(CommandArgType.CREATE_DATABASE)) {
            return CommandArgType.CREATE_DATABASE;
        }
        return CommandArgType.CREATE_TABLE;
    }
}
