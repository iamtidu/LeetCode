import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        int[] factorial = new int[n];
        factorial[0] = 1;
    
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        k--;

        for (int i = n; i > 0; i--) {
            int index = k / factorial[i - 1];
            k %= factorial[i - 1];
            result.append(numbers.get(index));
            numbers.remove(index);
        }

        return result.toString();
    }
}
