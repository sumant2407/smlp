package com.questionpro;

import com.questionpro.constants.CommandArgType;
import com.questionpro.create.database.CreateDatabase;
import com.questionpro.create.table.CreateTable;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine();
        switch (CommandType.getCommandType(cmd)) {
            case CREATE_DATABASE:
                System.out.println(CreateDatabase.createDatabase(CommandParams.getCommandParams(CommandArgType.CREATE_DATABASE, cmd)));
                break;
            case CREATE_TABLE:
                System.out.println(CreateTable.createTable(CommandParams.getDbName(cmd),
                        CommandParams.getCommandParams(CommandArgType.CREATE_TABLE, cmd),
                        CommandParams.getCreateCommandClause(cmd)));
        }
        CreateDatabase.sayHello();
    }
}