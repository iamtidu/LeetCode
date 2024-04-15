import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a hashmap to store anagrams
        Map<String, List<String>> anagramsMap = new HashMap<>();
        
        // Iterate through each word in the array
        for (String word : strs) {
            // Sort the characters of the word to create a key
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            
            // Check if the key exists in the hashmap
            if (!anagramsMap.containsKey(key)) {
                // If not, create a new list and add the word
                anagramsMap.put(key, new ArrayList<>());
            }
            // Add the word to the list of anagrams
            anagramsMap.get(key).add(word);
        }
        
        // Return the values (lists of anagrams) from the hashmap
        return new ArrayList<>(anagramsMap.values());
    }
}
