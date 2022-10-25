package algorithms.datastructure.primitive.string;

import java.util.*;

/*
https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class SubstringConcat {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Set<Integer>> aMap = findWordsIndexes(s, words);
        for (String word : aMap.keySet()) {
            for (int index : aMap.get(word)) {
                if (index + (words.length * word.length()) > s.length()) continue;
                String subStr = s.substring(index, index + (words.length * word.length()));
                Set<String> found = new HashSet<>();
                for (int i = 0; i < subStr.length(); i += word.length()) {
                    String substring = subStr.substring(i, i + word.length());
                    if (aMap.containsKey(substring)) {
                        found.add(substring);
                    }
                }
                if (found.size() == words.length) {
                    result.add(index);
                }
            }
        }
        return result;
    }

    private Map<String, Set<Integer>> findWordsIndexes(String s, String[] words) {
        Map<String, Set<Integer>> result = new HashMap<>();
        Set<String> wordSet = new HashSet<>();
        Collections.addAll(wordSet, words);
        var wordSize = words[0].length();
        for (int i = 0; i < (s.length() - wordSize + 1); i++) {
            String newWord = s.substring(i, i + wordSize);
            if (wordSet.contains(newWord)) {
                Set<Integer> value = result.getOrDefault(newWord, new HashSet<>());
                value.add(i);
                result.put(newWord, value);
            }
        }

        return result;
    }
}
