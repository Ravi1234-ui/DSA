import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // Case 1: k == n
        if (k == n) {
            int max = -1;
            for (int x : nums) {
                max = Math.max(max, x);
            }
            return max;
        }

        // Count frequency of all elements
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // Case 2: k == 1
        if (k == 1) {
            int max = -1;
            for (int x : nums) {
                if (freq.get(x) == 1) {
                    max = Math.max(max, x);
                }
            }
            return max;
        }

        // Case 3: 1 < k < n
        int first = nums[0];
        int last = nums[n - 1];
        int ans = -1;

        if (freq.get(first) == 1) {
            ans = Math.max(ans, first);
        }
        if (freq.get(last) == 1) {
            ans = Math.max(ans, last);
        }

        return ans;
    }
}