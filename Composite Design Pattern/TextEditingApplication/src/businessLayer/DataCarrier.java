package businessLayer;

public class DataCarrier {
    private String inputText;
    private String outputText;

    public DataCarrier(){
        inputText = "";
        outputText = "";
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public String getOutputText() {
        return outputText;
    }

    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }

}
