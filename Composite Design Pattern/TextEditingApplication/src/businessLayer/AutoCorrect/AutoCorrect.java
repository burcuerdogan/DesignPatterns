package businessLayer.AutoCorrect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;

public class AutoCorrect {
    private String[] words; // Word list array
    private java.util.Stack<String> suggestions = new Stack<>();

    public AutoCorrect() {
        loadWords();
        sort(words);
    }

    private void loadWords() {
        String line; // Temp variable for storing one line at a time
        ArrayList<String> temp = new ArrayList<>();

        try {
            // Word list text file
            String wordsFileName = "src/businessLayer/AutoCorrect/words.txt";
            FileReader fileReader = new FileReader(wordsFileName);
            BufferedReader buffReader = new BufferedReader(fileReader);

            while (null != (line = buffReader.readLine())) {
                temp.add(line.trim());
            }

            buffReader.close();
            words = new String[temp.size()];
            temp.toArray(words);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <E extends Comparable<E>> void sort(E[] array) {
        int n = array.length; // Get length of array

        // Insertion sort
        for (int i = 1; i < n; i++) {
            E temp = array[i]; // Save the element at index i
            int j = i - 1; // Let j be the element one index before i

            // Iterate through array
            while (j > -1 && (array[j].compareTo(temp) > 0)) {
                // Insert element at array[j] in proper place
                array[j + 1] = array[j];
                j--;
            }

            // Complete swap
            array[j + 1] = temp;
        }
    }

    public String autoCorrect(String userWord) {
        // Empty by default
        int result = Search.binarySearch(words, userWord);
        if (result == -1) {
            for (String word : words) {
                if (!word.isEmpty()) { // If word is NOT empty
                    if (userWord.length() == word.length()) // Same length
                        if (containsAllChars(userWord, word)) // Same chars
                            suggestions.push(word);
                }
            }
            if (suggestions.isEmpty()) {
                return null;
            } else {
                return suggestions.pop();
            }
        }
        return null;
    }

    private boolean containsAllChars(String strOne, String strTwo) {
        Character[] one = strToCharArray(strOne);
        Character[] two = strToCharArray(strTwo);

        sort(one);
        sort(two);

        for (int i = 0; i < one.length; i++) {
            if (Search.binarySearch(two, one[i]) == -1)
                return false;
            two[i] = '0';
        }

        two = strToCharArray(strTwo);
        sort(two);

        for (int i = 0; i < two.length; i++) {
            if (Search.binarySearch(one, two[i]) == -1)
                return false;
            one[i] = '0';
        }

        return true;
    }

    private Character[] strToCharArray(String str) {
        Character[] charArray = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }

        return charArray;
    }
}