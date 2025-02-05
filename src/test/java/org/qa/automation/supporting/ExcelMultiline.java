package org.qa.automation.supporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelMultiline {
    private static final Logger log = LoggerFactory.getLogger(ExcelMultiline.class);

    public ExcelMultiline() {

    }
    public static String unEscapeLineBreak(String data){
        return data.replace("$$", "\n");
    }
    public static String escapeLineBreak(String data){
        return data.replace("\n", "$$");
    }
}
