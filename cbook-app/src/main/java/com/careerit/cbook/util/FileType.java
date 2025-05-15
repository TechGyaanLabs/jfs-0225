package com.careerit.cbook.util;

import java.util.ArrayList;
import java.util.List;

public enum FileType {
    PDF, EXCEL, CSV, JSON;


    public static List<String> getFileTypes() {
       List<String> fileTypes = new ArrayList<>();
         for (FileType fileType : FileType.values()) {
              fileTypes.add(fileType.name());
         }
         return fileTypes;
    }
}
