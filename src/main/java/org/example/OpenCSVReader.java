package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenCSVReader {

    private static final String SAMPLE_CSV_FILE_PATH = "/Users/karanveer962/Desktop/untitled folder/contacts.csv";

    public static void main(String[] args) {
        Reader reader = null;
        CSVReader csvReader = null;

        try {
            reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            csvReader = new CSVReader(reader);

            // Reading Records One by One in a String array
            String[] nextRecord;
            while (true) {
                try {
                    if ((nextRecord = csvReader.readNext()) == null) {
                        break;
                    }
                    System.out.println("Name : " + nextRecord[0]);
                    System.out.println("Email : " + nextRecord[1]);
                    System.out.println("Phone : " + nextRecord[2]);
                    System.out.println("Country : " + nextRecord[3]);
                    System.out.println("==========================");
                } catch (CsvValidationException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Make sure to close the reader when done
            try {
                if (reader != null) {
                    reader.close();
                }
                if (csvReader != null) {
                    csvReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
