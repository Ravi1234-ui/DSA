class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // (i + 1) % n cleanly wraps the last element back to the 0th element
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            
            // Optimization: If we find more than 1 drop, it's definitely false
            if (count > 1) {
                return false;
            }
        }
        
        return true;
    }
}