package businessLayer;

public class ParagraphCounter implements Counter {
    @Override
    public void operation(DataCarrier dc){
        int paragraphCount=1;
        String[] lines = dc.getInputText().split("\r\n|\r|\n");
        for(String line : lines){
            if(line.equals("")) paragraphCount+=1;
        }
        System.out.println("Paragraph Count: " + paragraphCount);
    }
}
