import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWords = words.length;
        int totalChars = wordLength * totalWords;

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - totalChars; i++) {
            Map<String, Integer> wordSeen = new HashMap<>();
            int j = 0;
            while (j < totalWords) {
                String nextWord = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                if (wordCountMap.containsKey(nextWord)) {
                    wordSeen.put(nextWord, wordSeen.getOrDefault(nextWord, 0) + 1);
                    if (wordSeen.get(nextWord) > wordCountMap.getOrDefault(nextWord, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == totalWords) {
                result.add(i);
            }
        }

        return result;
    }
}
