class Solution {

    public static boolean ispossible(int[] nums, int threshold, int mid){
        int ans = 0;
        
        for(int i=0;i<nums.length;i++){
            ans += Math.ceil((double)nums[i]/mid);
        }
        
        return ans <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] > max) max = nums[i];
        }
        
        int low = 1, high = max;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(ispossible(nums, threshold, mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return low;
    }
}
