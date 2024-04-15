class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0; // Number of jumps
        int farthest = 0; // Farthest position we can reach
        int currentEnd = 0; // End index of the current jump

        // Iterate through the array
        for (int i = 0; i < n - 1; i++) {
            // Update farthest position we can reach from current position
            farthest = Math.max(farthest, i + nums[i]);
            // If we have reached the end of the current jump, update currentEnd and increment jumps
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest; // Update current end to farthest position we can reach
            }
        }

        return jumps;
    }
}
