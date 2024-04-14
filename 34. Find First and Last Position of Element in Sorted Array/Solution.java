class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        
        // Find the leftmost occurrence of the target
        int leftIndex = findIndex(nums, target, true);
        
        // If leftmost occurrence not found, return [-1, -1]
        if (leftIndex == -1) {
            return result;
        }
        
        // Find the rightmost occurrence of the target
        int rightIndex = findIndex(nums, target, false);
        
        result[0] = leftIndex;
        result[1] = rightIndex;
        
        return result;
    }
    
    // Helper function to find the index of the target (leftmost or rightmost)
    private int findIndex(int[] nums, int target, boolean findLeft) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                index = mid;
                if (findLeft) {
                    right = mid - 1; // Look for leftmost occurrence
                } else {
                    left = mid + 1; // Look for rightmost occurrence
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return index;
    }
}
