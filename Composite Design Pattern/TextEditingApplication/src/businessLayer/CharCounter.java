package businessLayer;

public class CharCounter implements Counter {
    @Override
    public void operation(DataCarrier dc) {
        int charCount=0;
        String[] lines = dc.getInputText().split("\r\n|\r|\n");
        for(String line : lines){
            String[] words = line.split("\\s+");
            charCount+=line.length();
        }
        System.out.println("Char Count: " + charCount);
    }
}
