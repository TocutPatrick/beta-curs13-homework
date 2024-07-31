package ro.beta.curs13.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
    private final String fileName;

    public ReadFromFile(String fileName) {
        this.fileName = fileName;
    }

    public List<Quote> readFromFile() throws IOException {
        List<Quote> list = new ArrayList<>();
        int counter = 1;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] result = line.split("~");
            list.add(new Quote(counter, result[0], result[1]));
            counter++;
        }
        return list;
    }


}
