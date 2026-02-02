import java.util.*;

class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        long currentSum = 0;
        long minSum = Long.MAX_VALUE;
        TreeSet<int[]> left = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        TreeSet<int[]> right = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int i = 1; i < n; i++) {
            int[] val = new int[]{nums[i], i};
            left.add(val);
            currentSum += val[0];

            if (left.size() > k - 1) {
                int[] largest = left.pollLast();
                currentSum -= largest[0];
                right.add(largest);
            }

            if (i > dist + 1) {
                int[] out = new int[]{nums[i - dist - 1], i - dist - 1};
                if (left.contains(out)) {
                    left.remove(out);
                    currentSum -= out[0];
                    if (!right.isEmpty()) {
                        int[] smallest = right.pollFirst();
                        currentSum += smallest[0];
                        left.add(smallest);
                    }
                } else {
                    right.remove(out);
                }
            }

            if (i >= k - 1 && left.size() == k - 1) {
                minSum = Math.min(minSum, currentSum);
            }
        }

        return nums[0] + minSum;
    }
}