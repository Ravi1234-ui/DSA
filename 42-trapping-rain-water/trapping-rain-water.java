class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int total = 0, lmx = 0, rmx = 0;
        int l = 0, r = n - 1;
        
        while (l < r) {
            if (height[l] <= height[r]) {
                if (lmx > height[l]) 
                    total += lmx - height[l];
                else 
                    lmx = height[l];
                l++;
            }
            else {
                if (rmx > height[r]) 
                    total += rmx - height[r];
                else 
                    rmx = height[r];
                r--;
            }
        }
        return total;
    }
}