package com.questionpro.create.table;

import com.questionpro.DbUtility;
import com.questionpro.constants.AcknowledgementType;

public class Table {

    public String Create(String dbName, String tableName) {
        createDBFolderIfDoesntExists();
        if (!DbUtility.databaseExists(dbName)) {
            DbUtility.createDatabase(dbName);
        }
        if(!DbUtility.tableExists(dbName, tableName)){
            DbUtility.createTable(dbName, tableName);
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