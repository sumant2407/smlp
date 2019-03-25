package com.questionpro.select;

import com.questionpro.utility.DbUtility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatabaseSelector {

    public String filter(String dbName, String tableName, String columnNames, String whereClause) throws IOException {
        if (DbUtility.tableExists(dbName, tableName)
                && !columnNames.isBlank()
                && !whereClause.isBlank()) {
            String tableData = new String(Files.readAllBytes(Paths.get(DbUtility.getTableFile(dbName, tableName))));
            List<Map<String, Object>> allRecords =
                    Stream.of(tableData.split("$")).map(singleRecord -> createMap(singleRecord)).collect(Collectors.toList());
            List<String> columns = new ArrayList<>();
            if (columnNames.equals("*")) {
                columns = DbUtility.getAllColumnsForTable(tableName, dbName);
            } else {
                columns = Stream.of(columnNames.split(",")).map(x -> x.strip()).collect(Collectors.toList());
            }
            return printQueryOutput(allRecords, columns);
        }
        return null;
    }

    private Map<String, Object> createMap(String singleRecord) {
        Map<String, Object> map = new HashMap<>();
        String singleRecordWithoutCurlyBraces = singleRecord.strip().substring(1, singleRecord.length() - 1);
        List<String> entries = Arrays.asList(singleRecordWithoutCurlyBraces.split(","));
        entries.forEach(entry -> {
            String[] keyValPair = entry.split(":");
            map.put(keyValPair[0], keyValPair[1]);
        });
        return map;
    }

    public String printQueryOutput(List<Map<String, Object>> records, List<String> columns) {
        StringBuilder output = new StringBuilder();
        records.forEach(singleRecord -> {
            output.append("=======================");
            columns.forEach(column -> output.append(column + " : " + singleRecord.get(column)));
        });
        return output.toString();
    }
}
