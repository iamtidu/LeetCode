import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], permutations);
        return permutations;
    }
    
    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> permutations) {
        if (current.size() == nums.length) {
            permutations.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                current.add(nums[i]);
                used[i] = true;
                backtrack(nums, current, used, permutations);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
}
