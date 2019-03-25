package com.questionpro.select;

public class SelectFromTable {
    public static String selectAll(String tableName, String whereClause) {
        System.out.println(tableName +" " +whereClause);
        return " ";
    }
    public static String simpleSelect(String tableName, String selectCondition, String whereClause) {
        System.out.println(tableName + " " +whereClause + " " +selectCondition);
        return " ";
    }
}
