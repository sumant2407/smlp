package com.questionpro;

import com.questionpro.constants.CommandArgType;
import com.questionpro.create.database.CreateDatabase;
import com.questionpro.create.table.CreateTable;
import com.questionpro.insert.InsertIntoTable;
import com.questionpro.select.SelectFromTable;

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
            case SELECT_ALL:
                System.out.println(SelectFromTable.selectAll(CommandParams.getCommandParams(CommandArgType.SELECT_ALL, cmd),
                        CommandParams.getWhereClause(cmd)));
                break;
        }
        CreateDatabase.sayHello();
    }
}