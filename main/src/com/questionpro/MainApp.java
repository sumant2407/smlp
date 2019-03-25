package com.questionpro;

import com.questionpro.constants.CommandArgType;
import com.questionpro.create.database.Database;
import com.questionpro.create.table.Table;
import com.questionpro.insert.DatabaseInsert;
import com.questionpro.select.DatabaseSelector;
import com.questionpro.select.SelectFromTable;
import com.questionpro.utility.DbUtility;


import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine();
        Database createDB = new Database();
        Table table = new Table();
        DatabaseSelector ds = new DatabaseSelector();
        String dbName = CommandParams.getDbName(cmd);

        switch (CommandType.getCommandType(cmd)) {
            case CREATE_DATABASE:
                System.out.println(createDB.create(CommandParams.getCommandParams(CommandArgType.CREATE_DATABASE, cmd)));
                break;
            case CREATE_TABLE:
                System.out.println(table.create(CommandParams.getDbName(cmd),
                        CommandParams.getCommandParams(CommandArgType.CREATE_TABLE, cmd),
                        CommandParams.getCommandClause(cmd)));
                break;
            case INSERT_INTO_TABLE:
                new DatabaseInsert().performInsert(CommandParams.getDbName(cmd), CommandParams.getCommandParams(
                        CommandArgType.INSERT_INTO_TABLE, cmd), CommandParams.getCommandClause(cmd));
                break;
            case SELECT_ALL:
                String tableName = CommandParams.getTableName(CommandParams.getCommandParams(CommandArgType.SIMPLE_SELECT,cmd));
                ds.filter(dbName, tableName,"*","");
                break;
            case SIMPLE_SELECT:
                tableName = CommandParams.getTableName(CommandParams.getCommandParams(CommandArgType.SIMPLE_SELECT,cmd));
                ds.filter(dbName,tableName,CommandParams.getSelectConditionClause(cmd)," ");
                break;
        }

    }
}