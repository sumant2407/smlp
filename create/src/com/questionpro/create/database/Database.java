package com.questionpro.create.database;

import com.questionpro.utility.DbUtility;
import com.questionpro.constants.AcknowledgementType;

public class Database {

    public String Create(String dbName) {
        createDBFolderIfDoesntExists();
        if (!DbUtility.databaseExists(dbName)) {
            DbUtility.createDatabase(dbName);
            return AcknowledgementType.DATABASE_CREATED.getValue();
        }
        return AcknowledgementType.DATABASE_EXISTS.getValue();
    }

    private void createDBFolderIfDoesntExists() {
        if (!DbUtility.dbFolderExists()) {
            DbUtility.createDBFolder();

        }
    }

}
