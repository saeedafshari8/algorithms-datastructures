package algorithms.datastructure.primitive.array;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/text-justification/
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int wordsWidth = 0;
        int start = 0;
        int index = 0;
        List<String> result = new ArrayList<>();
        while (index < words.length) {
            while (index < words.length) {
                if (wordsWidth + words[index].length() + 1 <= maxWidth) {
                    wordsWidth += words[index].length() + 1;
                    index++;
                } else if (wordsWidth + words[index].length() == maxWidth) {
                    index++;
                    break;
                } else {
                    break;
                }
            }
            if (index == words.length) {
                result.add(justifyLeft(words, start, index - 1, maxWidth));
            } else {
                if (index - 1 - start <= 1) {
                    result.add(justifyLeft(words, start, index - 1, maxWidth));
                } else {
                    result.add(justifyFull(words, start, index - 1, maxWidth));
                }
            }
            start = index;
            wordsWidth = 0;
        }
        return result;
    }

    private String justifyFull(String[] words, int start, int end, int maxLength) {
        StringBuilder sb = new StringBuilder();
        int wordsLength = 0;
        for (int i = start; i <= end; i++) {
            wordsLength += words[i].length();
        }
        sb.append(words[start]);
        int capacityForRemainingWords = maxLength - words[start].length();
        int remainingWordsLength = capacityForRemainingWords - (wordsLength - words[start].length());
        int numberOfSpacePerWord = remainingWordsLength / (end - start);
        int numberOfSpaceForLeftWords = remainingWordsLength % (end - start);
        int processedWordsFromLeft = 0;
        for (int i = start + 1; i <= end; i++) {
            sb.append(" ".repeat(numberOfSpacePerWord));
            if (processedWordsFromLeft < numberOfSpaceForLeftWords) {
                sb.append(" ");
                processedWordsFromLeft++;
            }
            sb.append(words[i]);
        }
        return sb.toString();
    }

    private String justifyLeft(String[] words, int start, int end, int maxLength) {
        StringBuilder sb = new StringBuilder();
        sb.append(words[start]);
        int processedLength = words[start].length();
        for (int i = start + 1; i <= end; i++) {
            sb.append(" ").append(words[i]);
            processedLength += words[i].length() + 1;
        }
        sb.append(" ".repeat(maxLength - processedLength));
        return sb.toString();
    }
}
