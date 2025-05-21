package org.qa.automation.utils;

//
//
//
//


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FeatureOverwrite {
    private static final Logger log = LoggerFactory.getLogger(FeatureOverwrite.class);
    private static final String tag = System.getProperty("cucumber.filter.tags");
    private static final String[] fileExt = new String[]{"feature"};
    private static final List<File> fileOverwriteList = new ArrayList<>();

    public FeatureOverwrite() {
    }

    public static void overrideFeatureFiles(String parentDirectory) throws Throwable {
        try {
            setFileOverwriteList(parentDirectory);

            for (File featureFile : fileOverwriteList) {
                List<String> featureWithExcelData = setExcelDataToFeature(featureFile);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(featureFile), StandardCharsets.UTF_8));
                Throwable var5 = null;

                try {
                    for (String string : featureWithExcelData) {
                        writer.write(string);
                        writer.write("\n");
                    }
                } catch (Throwable var16) {
                    var5 = var16;
                    throw var16;
                } finally {
                    if (var5 != null) {
                        try {
                            writer.close();
                        } catch (Throwable var15) {
                            var5.addSuppressed(var15);
                        }
                    } else {
                        writer.close();
                    }
                }
            }
        } catch (Throwable var18) {
            throw var18;
        }
    }

    private static void setFileOverwriteList(String parentDirectory) throws IOException {
        File directory = new File(parentDirectory);
        Collection<File> fileList = FileUtils.listFiles(directory, fileExt, true);

        for (File f : fileList) {
            String fileData = FileUtils.readFileToString(f, Charset.defaultCharset());
            if (fileData.contains(tag)) {
                fileOverwriteList.add(f);
            }
        }
    }

    private static List<String> setExcelDataToFeature(File featureFile) throws IOException {
        List<String> fileData = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new BufferedInputStream(new FileInputStream(featureFile)), StandardCharsets.UTF_8)
        );
        Throwable exception = null;

        try {
            boolean foundHashTag = false;
            boolean featureData = false;

            while (true) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String sheetName = null;
                    String excelFilePath = null;

                    if (line.trim().contains("##@externaldata")) {
                        excelFilePath = line.substring(StringUtils.ordinalIndexOf(line, "@", 2) + 1, line.lastIndexOf("@"));
                        sheetName = line.substring(line.lastIndexOf("@") + 1);
                        foundHashTag = true;
                        fileData.add(line);
                    }

                    if (foundHashTag) {
                        List<Map<String, String>> excelData = new ExcelReaderForOverwrite().getData(
                                featureFile.getPath(), excelFilePath, sheetName
                        );

                        // Get headers and calculate max column widths
                        Map<String, Integer> columnWidths = new LinkedHashMap<>();
                        for (String key : excelData.get(0).keySet()) {
                            columnWidths.put(key, key.length());
                        }

                        for (Map<String, String> row : excelData) {
                            for (Map.Entry<String, String> entry : row.entrySet()) {
                                int len = entry.getValue() != null ? entry.getValue().length() : 0;
                                columnWidths.put(entry.getKey(), Math.max(columnWidths.get(entry.getKey()), len));
                            }
                        }

                        // Create header row
                        StringBuilder headerRow = new StringBuilder();
                        for (String key : columnWidths.keySet()) {
                            headerRow.append("| ").append(padRight(key, columnWidths.get(key))).append(" ");
                        }
                        headerRow.append("|");  // Close the final column

                        fileData.add(headerRow.toString());

                        // Create data rows
                        for (Map<String, String> row : excelData) {
                            boolean isEmptyRow = row.values().stream().allMatch(v -> v == null || v.trim().isEmpty());
                            if (isEmptyRow) continue;  // skip blank Excel rows

                            StringBuilder dataRow = new StringBuilder();
                            for (String key : columnWidths.keySet()) {
                                String value = row.getOrDefault(key, "");
                                dataRow.append("| ").append(padRight(value, columnWidths.get(key))).append(" ");
                            }
                            dataRow.append("|");
                            fileData.add(ExcelMultiline.escapeLineBreak(dataRow.toString()));
                        }


                        foundHashTag = false;
                        featureData = true;
                    } else if (!line.startsWith("|") && !line.endsWith("|")) {
                        featureData = false;
                        fileData.add(line);
                    } else if (!featureData) {
                        fileData.add(line);
                    }
                }
                return fileData;
            }
        } catch (Throwable t) {
            exception = t;
            throw t;
        } finally {
            if (exception != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable suppressed) {
                    exception.addSuppressed(suppressed);
                }
            } else {
                bufferedReader.close();
            }
        }
    }

    // Utility method to pad strings for column alignment
    private static String padRight(String text, int length) {
        if (text == null) text = "";
        return String.format("%-" + length + "s", text);
    }
}