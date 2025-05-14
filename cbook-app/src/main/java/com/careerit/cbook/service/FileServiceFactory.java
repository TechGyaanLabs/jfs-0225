package com.careerit.cbook.service;

import com.careerit.cbook.util.FileType;

public class FileServiceFactory {


        public static  FileService getFileService(FileType fileType) {
          return switch (fileType) {
            case PDF -> new PdfFileService();
            case CSV -> new CsvFileService();
            case JSON -> new JsonFileService();
            case EXCEL -> new ExcelFileService();
            default -> throw new IllegalArgumentException("Invalid file type: " + fileType);
          };
        }

}
