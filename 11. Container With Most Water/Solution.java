class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftSide = height[left];
        int rightSide = height[right];
        int result = 0;

        while (left < right) {
            final int leftSideHeight = height[left];
            final int rightSideHeight = height[right];
            final int width = right - left;
            final int evaluatedHeight = Math.min(leftSideHeight, rightSideHeight);
            final int square = evaluatedHeight * width;
            if (square > result) {
                result = square;
            }

            while(left < right && height[left] <= evaluatedHeight) {
                left++;
            }

            while(left < right && height[right] <= evaluatedHeight) {
                right--;
            }
        }

        return result;
    }
}
