package com.careerit.jfs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.fop.apps.MimeConstants;

public class ExcelReadingAndWriting {


    public static void main(String[] args) {
            List<Player> players = getPlayersFromExcel();
            writePlayersToExcel(players);
            writePlayersDataToJson(players);
            writePlayersDataToPdf();
    }

    private static void writePlayersDataToJson(List<Player> players) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("output_players.json"), players);
            System.out.println("Players written to json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writePlayersDataToPdf() {

        try {
            createPdf();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FOPException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createPdf() throws IOException, FOPException {
        File xmlFile = new File(ExcelReadingAndWriting.class.getResource("/players.xml").getPath());
        File xsltFile = new File(ExcelReadingAndWriting.class.getResource("/players.xsl").getPath());
        File pdfFile = new File("players.pdf");
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        try (OutputStream out = new FileOutputStream(pdfFile)) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            Source src = new StreamSource(xmlFile);
            Result res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(src, res);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writePlayersToExcel(List<Player> players) {

        // 1. Create a new excel file
        // 2. Create a new sheet
        // 3. Write the data to the sheet
        // 4. Write the excel file to the disk
        // 5. Close the file
        System.out.println("Writing players to excel");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Players");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Name");
        header.createCell(1).setCellValue("Role");
        header.createCell(2).setCellValue("Country");
        header.createCell(3).setCellValue("Team");
        header.createCell(4).setCellValue("Price");
        int rownum = 1;
        for (Player player : players) {
            Row row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(player.getName());
            row.createCell(1).setCellValue(player.getRole());
            row.createCell(2).setCellValue(player.getCountry());
            row.createCell(3).setCellValue(player.getTeam());
            row.createCell(4).setCellValue(player.getPrice());
        }
        try {
            workbook.write(new FileOutputStream(new File("output_players.xlsx")));
            System.out.println("Players written to excel");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Player> getPlayersFromExcel(){

        // 1. Read the excel file
        // 2. Read the data from the excel file
        // 3. Create a Player object and set the data
        // 4. Print the player object
        // 5. Write the player object to a new excel file
        List<Player> players = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(new File(
                    ExcelReadingAndWriting.class.getResource("/players.xlsx").getPath()));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Player player = new Player();
                player.setName(row.getCell(0).getStringCellValue());
                player.setRole(row.getCell(1).getStringCellValue());
                player.setCountry(row.getCell(2).getStringCellValue());
                player.setTeam(row.getCell(3).getStringCellValue());
                player.setPrice(Double.parseDouble(row.getCell(4).getStringCellValue()));
                players.add(player);
            }

            System.out.println("Total Players : " + players.size());


        }catch (Exception e){
            e.printStackTrace();
        }
        return players;
    }
}
