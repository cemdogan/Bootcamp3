package org.kodluyoruz.bootcamp3;

import java.util.HashSet;
import java.util.Set;

public class WordCounter {
    public Set<String> wordSoFar = new HashSet<>();

    public int getUniqueWordsCount() {
        return wordSoFar.size();
    }

    public void add(String sentence) {
        if (sentence.isEmpty()) {
            return;
        }

        for (String word : sentence.trim().split("[., ]+")) {
            wordSoFar.add(word.toLowerCase());
        }
    }
}
