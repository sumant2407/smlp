package com.questionpro.create.database;

import com.questionpro.constants.AcknowledgementType;

public class CreateDatabase {


    public  static void sayHello(){
        System.out.println("hello");

    }

    public static String CreateDatabase (String dbName){
        String currentWorkingDirectory = System.getProperty("user.dir");

        if(!databaseExists(dbName)) {

            return AcknowledgementType.DATABASE_CREATED.getValue();
        }
        return AcknowledgementType.DATABASE_EXISTS.getValue();
    }

    private static boolean databaseExists(String dbName){

        return false;
    }
}
