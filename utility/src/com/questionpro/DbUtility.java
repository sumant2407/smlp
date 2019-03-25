package com.questionpro;


import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class DbUtility {

    public static String getDbFolderPath() {
        return System.getProperty("user.dir") + "/" + "database_folder" + "/";
    }

    public static String getDbDir(String dbName) {
        return System.getProperty("user.dir") + "/" + "database_folder" + "/" + dbName + "/";
    }

    public static boolean dbFolderExists() {
        String dbPath = System.getProperty("user.dir") + "/" + "database_folder";
        return true;
    }

    public static boolean dbExists(String  dbName) {
        if (dbName.isBlank()) {
            return false;
        }
        File file = new File(getDbDir(dbName));
        return file.exists();
    }

    public static String getTableFile(String dbName, String tableName) {
        return getDbDir(dbName) + "/" + tableName + ".txt";
    }

    public static boolean tableExists(String dbName, String tableName) {
        File file = new File(getTableFile(dbName, tableName));
        return file.exists();
    }

    public static List<String> getAllColumnsForTable(String tableName) {
        return null;
    }
}
