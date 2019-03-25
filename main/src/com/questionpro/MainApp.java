package com.questionpro;

import com.questionpro.create.database.Database;
import com.questionpro.create.table.Table;

public class MainApp {
    public static void main (String[] args){
        Database cd = new Database();
        Table table = new Table();
        System.out.println(cd.Create("test"));
        System.out.println(table.Create("test", "table_one"));
    }
}
