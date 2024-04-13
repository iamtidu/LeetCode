import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
       
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0; 
        
       
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            int value = romanMap.get(symbol);
            
           
            if (value > prevValue) {
                result += value - 2 * prevValue;
            } else {
                result += value; 
            }
            prevValue = value;
        }
        
        return result;
    }
}
