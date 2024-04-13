import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int start = 0;
        int end = 0;
        while (start < s.length()) {
            if (!set.contains(s.charAt(start))) {
                set.add(s.charAt(start));
                max = Math.max(max, start - end + 1);
                start++;
            } else {
                set.remove(s.charAt(end));
                end++;
            }
        }
        return max;
    }
}
