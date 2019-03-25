package com.questionpro.insert;

import com.questionpro.DbUtility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseInsert {

    public int performInsert(String dbName, String tableName, String record) {
        if (DbUtility.tableExists(dbName, tableName) && !record.isBlank()) {
            try {
                File file = new File(DbUtility.getTableFile(dbName, tableName));
                record = record.strip().concat("$");
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(record);
                fileWriter.close();
                return 1;
            } catch (IOException e) {
                return 0;
            }
        }
        return 0;
    }
}
