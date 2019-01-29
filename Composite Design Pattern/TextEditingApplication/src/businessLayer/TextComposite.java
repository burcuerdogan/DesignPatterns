package businessLayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> componentList;

    public TextComposite(){
        componentList = new ArrayList<>();
    }

    public void addComponent(TextComponent tc){
        componentList.add(tc);
    }


    @Override
    public void operation(DataCarrier dc) throws IOException {
        for(TextComponent tc: componentList){
            tc.operation(dc);
        }
    }
}
