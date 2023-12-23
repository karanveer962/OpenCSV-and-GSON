package org.example;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

    public class OpenCSVWriter {
        private static final String OBJECT_LIST_SAMPLE = "./object-list-sample.csv";

        public static void main(String[] args) {
            try (Writer writer = Files.newBufferedWriter(Paths.get(OBJECT_LIST_SAMPLE))) {
                StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder<CSVUser>(writer)
                        .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                        .build();

                List<CSVUser> myUsers = new ArrayList<>();
                myUsers.add(new CSVUser("Sundar Pichai", "sundar.pichai@gmail.com", "+1-111111111","India"));
                myUsers.add(new CSVUser("Satya Nadella", "satya.nadella@outlook.com", "+1-111111111", "UK"));

                try {
                    beanToCsv.write(myUsers);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

