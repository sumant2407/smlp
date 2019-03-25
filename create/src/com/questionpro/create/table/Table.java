package com.questionpro.create.table;

import com.questionpro.utility.DbUtility;
import com.questionpro.constants.AcknowledgementType;

public class Table {

    public String create(String dbName, String tableName, String cmdCreateClause) {
        createDBFolderIfDoesntExists();
        if (!DbUtility.databaseExists(dbName)) {
            DbUtility.createDatabase(dbName);
        }
        if(!DbUtility.tableExists(dbName, tableName)){
            DbUtility.createTable(dbName, tableName, cmdCreateClause);
            return AcknowledgementType.TABLE_CREATED.getValue();
        }
        return AcknowledgementType.DATABASE_EXISTS.getValue();
    }

    private void createDBFolderIfDoesntExists() {
        if (!DbUtility.dbFolderExists()) {
            DbUtility.createDBFolder();
        }
    }
}
