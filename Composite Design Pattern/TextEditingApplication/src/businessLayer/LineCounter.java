package businessLayer;

public class LineCounter implements Counter {
    @Override
    public void operation(DataCarrier dc) {
        String[] lines = dc.getInputText().split("\r\n|\r|\n");
        System.out.println("Line Count: " + lines.length);
    }
}
