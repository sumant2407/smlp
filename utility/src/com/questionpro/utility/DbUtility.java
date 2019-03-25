package com.questionpro.utility;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class DbUtility {
    private static final String DBPATH = System.getProperty("user.dir") + "/" + "database_folder";
    private static final String TABLE_FOLDER = "table";
    private static final String TABLE_METADATA = "table_metadata";

    public static boolean dbFolderExists() {
        return folderExists(DBPATH);
    }

    public static void createDBFolder() {
        createDirectory(DBPATH);
    }

    private static void createDirectory(String path) {
        File dir = new File(path);
        dir.mkdir();
    }

    private static void createFile(String path) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(path))) {
        } catch (Exception ex) {
            System.out.println("fialed to create file");
        }

    }

    public static boolean databaseExists(String dbName) {
        return folderExists(DBPATH + "/" + dbName);
    }

    public static void createDatabase(String dbName) {
        createDirectory(DBPATH + "/" + dbName);
        createDirectory(DBPATH + "/" + dbName + "/" + TABLE_FOLDER);
        createDirectory(DBPATH + "/" + dbName + "/" + TABLE_METADATA);
    }

    private static boolean folderExists(String path) {
        File fileDirectory = new File(path);
        return fileDirectory.exists();
    }

    public static boolean tableExists(String dbName, String tableName) {
        return folderExists(DBPATH + "/" + dbName + "/" + TABLE_FOLDER + "/" + tableName);
    }

    public static void createTable(String dbName, String tableName, String tableData) {
        createFile(DBPATH + "/" + dbName + "/" + TABLE_FOLDER + "/" + tableName + ".txt");
        createFile(DBPATH + "/" + dbName + "/" + TABLE_METADATA + "/" + tableName + ".txt");
        insertDataIntoMetaData(tableData, DBPATH + "/" + dbName + "/" + TABLE_METADATA + "/" + tableName + ".txt");
    }

    public static void insertDataIntoMetaData(String tableData, String pathString){
        Path path = Paths.get(pathString);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.WRITE))
        {
            writer.write(tableData);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String getTableFile(String dbName, String tableName) {
        return DBPATH + "/" + dbName + "/" + TABLE_FOLDER + "/" + tableName +  ".txt";
    }

    public static List<String> getAllColumnsForTable(String tableName) {
        return null;
    }

}
