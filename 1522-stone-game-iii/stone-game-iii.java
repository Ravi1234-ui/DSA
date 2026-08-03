class Solution {
    int[] dp;
    public String stoneGameIII(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,-1);

        int diff=solve(nums,0);
        if(diff >0) return "Alice";
        else if(diff <0) return "Bob";
        return "Tie";

    }

    public  int solve(int[]nums,int i){
        int n=nums.length;
        if(i>=n) return 0;
        if(dp[i] != -1) return dp[i];
        int diff= nums[i] - solve(nums,i+1);
        if(i+1 <n) diff= Math.max(diff,nums[i]+nums[i+1] - solve(nums,i+2));
        if (i+2 < n) diff= Math.max(diff,nums[i]+nums[i+1] + nums[i+2] - solve(nums,i+3));

        dp[i]=diff;
        return diff;
    }
}