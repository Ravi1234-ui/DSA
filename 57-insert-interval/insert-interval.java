class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        // List to store the final merged intervals
        List<int[]> result = new ArrayList<>();

        // Traverse each interval
        for (int[] interval : intervals) {

            // Case 1: Current interval ends before newInterval starts
            if (interval[1] < newInterval[0]) {
                // Safe to add since no overlap
                result.add(interval);
            }

            // Case 2: Current interval starts after newInterval ends
            else if (interval[0] > newInterval[1]) {
                // Add the merged newInterval to result
                result.add(newInterval);

                // Update newInterval to current interval
                newInterval = interval;
            }

            // Case 3: Overlapping intervals
            else {
                // Merge by taking minimum start
                newInterval[0] = Math.min(newInterval[0], interval[0]);

                // Merge by taking maximum end
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        // Add the last interval
        result.add(newInterval);

        // Convert list to array and return
        return result.toArray(new int[result.size()][]);
    }
}