package businessLayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Searcher implements TextComponent {

    @Override
    public void operation(DataCarrier dc){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        List<String> matches = new ArrayList<>();
        System.out.println("Enter search keyword: ");
        String searchWord = reader.nextLine();
        String[] lines = dc.getInputText().split("\r\n|\r|\n");
        for(String line : lines){
            String[] words = line.split("\\s+");
            for(String word : words){
                if(word.contains(searchWord) && !matches.contains(word)){
                    matches.add(word);
                }
            }
        }
        if(matches.isEmpty()){
            System.out.println("No match.");
        }
        else{
            System.out.println("Matched words: ");
            for(String word : matches){
                System.out.println(word);
            }
        }
    }
}
