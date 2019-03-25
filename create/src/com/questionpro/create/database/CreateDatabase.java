package com.questionpro.create.database;

import com.questionpro.DbUtility;
import com.questionpro.constants.AcknowledgementType;

public class CreateDatabase {


    public  static void sayHello(){
        System.out.println("hello");

    }

    public String CreateDatabase(String dbName) {
        createDBFolderIfDoesntExists();
        if (!databaseExists(dbName)) {

            return AcknowledgementType.DATABASE_CREATED.getValue();
        }
        return AcknowledgementType.DATABASE_EXISTS.getValue();
    }

    private void createDBFolderIfDoesntExists() {
        if (!DbUtility.dbFolderExists()) {
            DbUtility.createDBFolder();
        }
    }

    private  boolean databaseExists(String dbName){

        return false;
    }
}
