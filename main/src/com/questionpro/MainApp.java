package com.questionpro;

import com.questionpro.constants.CommandArgType;
import com.questionpro.create.database.Database;
import com.questionpro.create.table.CreateTable;
import com.questionpro.insert.DatabaseInsert;
import com.questionpro.select.DatabaseSelector;
import com.questionpro.select.SelectFromTable;
import com.questionpro.utility.DbUtility;


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
            case SELECT_ALL:
                String dbName = CommandParams.getDbName(cmd);
                String tableName = CommandParams.getTableName(CommandParams.getCommandParams(CommandArgType.SIMPLE_SELECT,cmd));
                DatabaseSelector.filter(dbName, tableName, DbUtility.getAllColumnsForTable(tableName)
                        ,
                        )
                System.out.println(SelectFromTable.selectAll(CommandParams.getCommandParams(CommandArgType.SELECT_ALL, cmd),
                        CommandParams.getWhereClause(cmd)));
                break;
            case SIMPLE_SELECT:
                System.out.println(SelectFromTable.simpleSelect(CommandParams.getCommandParams(CommandArgType.SIMPLE_SELECT,cmd),
                        CommandParams.getSelectConditionClause(cmd),CommandParams.getWhereClause(cmd)));
                break;
        }

    }
}