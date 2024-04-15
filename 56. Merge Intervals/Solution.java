import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals based on the starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        // Add the first interval to the merged list
        merged.add(intervals[0]);
        
        // Iterate through the sorted intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] lastMergedInterval = merged.get(merged.size() - 1);
            
            // Check for overlap between the current interval and the last merged interval
            if (currentInterval[0] <= lastMergedInterval[1]) {
                // Merge the intervals by updating the end point of the last merged interval
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentInterval[1]);
            } else {
                // Add the current interval to the merged list
                merged.add(currentInterval);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}
