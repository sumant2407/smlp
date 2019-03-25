package com.questionpro;

import com.questionpro.constants.CommandArgType;
import com.questionpro.create.database.Database;
import com.questionpro.create.table.CreateTable;
import com.questionpro.insert.DatabaseInsert;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine();
        Database createDB = new Database();
        switch (CommandType.getCommandType(cmd)) {
            case CREATE_DATABASE:
                System.out.println(createDB.create(CommandParams.getCommandParams(CommandArgType.CREATE_DATABASE, cmd)));
                break;
            case CREATE_TABLE:
                System.out.println(CreateTable.createTable(CommandParams.getDbName(cmd),
                        CommandParams.getCommandParams(CommandArgType.CREATE_TABLE, cmd),
                        CommandParams.getCommandClause(cmd)));
                break;
            case INSERT_INTO_TABLE:
                new DatabaseInsert().performInsert(CommandParams.getDbName(cmd), CommandParams.getCommandParams(
                        CommandArgType.INSERT_INTO_TABLE, cmd), CommandParams.getCommandClause(cmd));
                break;
        }
    }
}
