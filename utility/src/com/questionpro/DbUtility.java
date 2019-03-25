package com.questionpro;



public class DbUtility {

    public static boolean dbFolderExists(){
        String dbPath = System.getProperty("user.dir")+"/"+"database_folder";
        return Files.exists(dbPath, LinkOption.NOFOLLOW_LINKS)
    }
    public static boolean dbExists(){

    }
}
