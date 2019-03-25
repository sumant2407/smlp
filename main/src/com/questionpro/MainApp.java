package com.questionpro;

import com.questionpro.create.database.Database;
import com.questionpro.create.table.Table;
import com.questionpro.constants.CommandArgType;
import com.questionpro.create.table.CreateTable;
import com.questionpro.insert.InsertIntoTable;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine();
        CreateDatabase createDB = new CreateDatabase();
        switch (CommandType.getCommandType(cmd)) {
            case CREATE_DATABASE:
                System.out.println(createDB.CreateDatabase(CommandParams.getCommandParams(CommandArgType.CREATE_DATABASE, cmd)));
                break;
            case CREATE_TABLE:
                System.out.println(CreateTable.createTable(CommandParams.getDbName(cmd),
                        CommandParams.getCommandParams(CommandArgType.CREATE_TABLE, cmd),
                        CommandParams.getCommandClause(cmd)));
                break;
            case INSERT_INTO_TABLE:
                InsertIntoTable.insertIntoTable(CommandParams.getCommandParams(
                        CommandArgType.INSERT_INTO_TABLE, cmd), CommandParams.getCommandClause(cmd));
                break;
        }
        CreateDatabase.sayHello();
    }
}
