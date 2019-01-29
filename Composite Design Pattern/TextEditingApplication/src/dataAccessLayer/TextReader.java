package dataAccessLayer;

import java.io.BufferedReader;
import java.io.IOException;

public class TextReader {
    public String fileReader() throws IOException {
        BufferedReader in = new BufferedReader(new java.io.FileReader("src/txtFiles/InputFile.txt"));
        String line;
        StringBuilder allFile = new StringBuilder();
        while((line = in.readLine()) != null)
        {
            allFile.append(line).append("\n");
        }
        in.close();
        return allFile.toString();
    }
}
