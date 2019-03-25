package com.questionpro.create.database;

import com.questionpro.constants.AcknowledgementType;

public class CreateDatabase {


    public  static void sayHello(){
        System.out.println("hello");
        System.out.println(System.getProperty("user.dir"));
    }

    public static String CreateDatabase (String dbName){
        if(!databaseExists(dbName)) {

            return AcknowledgementType.DATABASE_CREATED.getValue();
        }
        return AcknowledgementType.DATABASE_EXISTS.getValue();
    }

    private static boolean databaseExists(String dbName){

        return false;
    }
}
