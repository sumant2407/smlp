package com.questionpro.utility;


import java.io.File;

public class DbUtility {
    private static final String DBPATH = System.getProperty("user.dir")+"/"+"database_folder";

    public static boolean dbFolderExists(){
        File dir = new File(DBPATH);
        return dir.exists();
    }

    public static void createDBFolder(){
        File dir = new File(DBPATH);
        dir.mkdir();
    }

}
