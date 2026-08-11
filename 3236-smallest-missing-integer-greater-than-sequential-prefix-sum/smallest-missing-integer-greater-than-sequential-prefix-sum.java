class Solution {
    public int missingInteger(int[] nums) {
        int sum=nums[0],n=nums.length;
        int longest=-1;
        for(int i=1;i<n;i++){
            if(nums[i] != nums[i-1]+1){
                longest=i;
                break;
            }
            sum+=nums[i];
        }
        while(check(nums,sum)) sum++;
        return sum;

    }
    public static boolean check(int[]nums,int x){
        for(int i:nums){
            if(i==x) return true;
        }
        return false;
    }
}