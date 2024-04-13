import java.util.*;

class Solution {
    private static final Map<Character, String> phoneMap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        backtrack(combinations, new StringBuilder(), digits, 0);
        return combinations;
    }
    
    private void backtrack(List<String> combinations, StringBuilder current, String digits, int index) {
        if (index == digits.length()) {
            combinations.add(current.toString());
            return;
        }
        
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(combinations, current, digits, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
