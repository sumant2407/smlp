package com.questionpro.create.table;

import com.questionpro.constants.AcknowledgementType;

public class CreateTable {
    public static String createTable(String dbName, String tableName, String cmdCreateClause) {
        if (databaseExists(dbName) && !tableExists(tableName)) {
            return AcknowledgementType.TABLE_CREATED.getValue();
        } else if (databaseExists(dbName) && tableExists(tableName)) {
            return AcknowledgementType.TABLE_EXISTS.getValue();
        }
        return AcknowledgementType.DATABASE_NOT_FOUND.getValue();
    }

    private static boolean databaseExists(String dbName) {
        return true;
    }

    private static boolean tableExists(String tableName) {
        return false;
    }
}
