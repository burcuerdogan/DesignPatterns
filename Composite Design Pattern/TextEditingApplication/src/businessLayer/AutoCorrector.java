package businessLayer;

import businessLayer.AutoCorrect.AutoCorrect;
import java.util.ArrayList;
import java.util.List;

public class AutoCorrector implements TextComponent {
    @Override
    public void operation(DataCarrier dc) {
        AutoCorrect ac = new AutoCorrect();
        String[] lines = dc.getInputText().split("\r\n|\r|\n");
        List<String[]> words = new ArrayList<>();
        for(String line : lines){
            words.add(line.split("\\s+"));
            for(int i=0;i<words.size()-1;i++){
                for(int j=0;j<words.get(i).length;j++){
                    String tempWord = ac.autoCorrect(words.get(i)[j]);
                    if(tempWord!=null){
                        words.get(i)[j] = tempWord;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String[] lineWords: words){
            for(String word: lineWords){
                sb.append(word).append(" ");
            }
            sb.append("\n");
        }
        dc.setOutputText(sb.toString());
        System.out.println("Auto corrections done.");
    }
}
