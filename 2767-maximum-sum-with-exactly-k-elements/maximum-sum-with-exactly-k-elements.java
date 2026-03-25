class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max=-1;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int total=0;
        for(int i=0;i<k;i++){
            total+=max;
            max+=1;
        }
        return total;
    }
}