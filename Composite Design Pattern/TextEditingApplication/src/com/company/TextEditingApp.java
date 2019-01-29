package com.company;
import businessLayer.*;
import dataAccessLayer.TextReader;

import java.io.IOException;

public class TextEditingApp {

    public static void main(String[] args) throws IOException {
        TextComponent textSaver = new TextSaver();
        TextComponent charCounter = new CharCounter();
        TextComponent lineCounter = new LineCounter();
        TextComponent paragraphCounter = new ParagraphCounter();
        TextComponent wordCounter = new WordCounter();
        TextComponent autoCorrector = new AutoCorrector();
        TextComponent searcher = new Searcher();
        TextReader tr = new TextReader();
        DataCarrier dc = new DataCarrier();
        dc.setInputText(tr.fileReader());
        TextComposite composite = new TextComposite();
        composite.addComponent(autoCorrector);
        composite.addComponent(paragraphCounter);
        composite.addComponent(lineCounter);
        composite.addComponent(wordCounter);
        composite.addComponent(charCounter);
        composite.addComponent(textSaver);
        composite.addComponent(searcher);
        composite.operation(dc);
    }
}