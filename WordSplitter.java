//201611109 JOOWONSUK

import java.util.ArrayList;
import java.util.List;

public class WordSplitter {
    private final String sentence;
    private final List<Character> seperatorList;
    protected List<String> wordList;

    public WordSplitter(String sentence, List<Character> seperatorList){
        this.sentence = sentence;
        this.seperatorList = seperatorList;
    }

    public void splitWord(){
        List<String> wordList = new ArrayList<>();

        //ignore case??
        String sentenceLowerCase = sentence.toLowerCase();

        //point index
        int p = 0;

        //search char
        for(int i = 0; i< sentenceLowerCase.length(); i++){
            char c = sentenceLowerCase.charAt(i);

            //found seperator
            if (seperatorList.contains(c)){
                // ignore continuity separator
                if (i > p) {
                    // extract word and add to list
                    wordList.add(sentenceLowerCase.substring(p, i));
                }
                // mode point index
                p = i + 1;
            }
        }

        // add to list last word
        wordList.add(sentenceLowerCase.substring(p));

        this.wordList = wordList;
    }

}

