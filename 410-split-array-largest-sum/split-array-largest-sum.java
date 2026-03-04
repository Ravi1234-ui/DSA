class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length,low=nums[0],high=nums[0];
        for(int i=0;i<nums.length;i++){
            low=Math.max(low, nums[i]);
            high+=nums[i];
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(require(nums,mid)>k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    public int require(int[]nums, int k){
        int curr=0,cnt=1;
        for(int i=0;i<nums.length;i++){
            if(curr+nums[i] <=k) curr+=nums[i];
            else{
                cnt++;
                curr=nums[i];
            }
        }
        return cnt;
    }
}