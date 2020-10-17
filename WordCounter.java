//201611109 JOOWONSUK

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter extends WordSplitter {

    private final List<String> stopwordList;
    protected Map<String, Integer> wordAndCountMap;

    public WordCounter(String sentence, List<Character> separatorList, List<String> stopwordList) {
        // in WordSplitter
        super(sentence, separatorList);

        this.stopwordList = stopwordList;
    }

    public void countWord() {
        // check valid
        if (wordList == null) {
            System.out.println("String is not separated by words.");
            return;
        }

        Map<String, Integer> wordAndCountMap = new HashMap<>();

        for (String word : wordList) {
            // ignore stopword
            if (stopwordList.contains(word))
                continue;

            // ignore numeric
            try {
                Double.parseDouble(word);
                continue;
            } catch (NumberFormatException e) {
            }

            // increment count
            Integer count = wordAndCountMap.get(word);

            if (count == null)
                count = 0;

            wordAndCountMap.put(word, count + 1);
        }

        this.wordAndCountMap = wordAndCountMap;
    }

    public void printWordByCountGe(int count) {
        // check valid
        if (wordAndCountMap == null) {
            System.out.println("The number of words has not been calculated.");
            return;
        }

        // print
        for (Map.Entry<String, Integer> entry : wordAndCountMap.entrySet()) {
            String word = entry.getKey();
            Integer wordCount = entry.getValue();

            // ignore less than count
            if (wordCount == null || wordCount < count)
                continue;

            System.out.println(word + ":" + wordCount);
        }
    }


}
