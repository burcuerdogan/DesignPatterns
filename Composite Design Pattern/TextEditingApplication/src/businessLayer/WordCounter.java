package businessLayer;

public class WordCounter implements Counter {
    @Override
    public void operation(DataCarrier dc) {
        int wordCount=0;
        String[] lines = dc.getInputText().split("\r\n|\r|\n");
        for(String line : lines){
            String[] words = line.split("\\s+");
            wordCount+=words.length;
        }
        System.out.println("Word Count: " + wordCount);
    }
}
