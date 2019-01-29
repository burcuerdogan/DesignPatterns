package businessLayer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextSaver implements TextComponent {
    @Override
    public void operation(DataCarrier dc) throws IOException {
        File file = new File("output.txt");
        FileWriter writer = new FileWriter(file);
        writer.write(dc.getOutputText());
        writer.flush();
        writer.close();
        System.out.println("File has been saved.");
    }
}
