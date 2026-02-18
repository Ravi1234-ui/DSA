class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi=piles[0];
        for(int i=1;i<piles.length;i++){
            if(piles[i]>maxi) maxi=piles[i];
        }
        int low=1,high=maxi;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(requireTime(piles,mid)<=h){
                high=mid-1;
            }else low=mid+1;
        }
        return low;
    }
    public static long requireTime(int[]piles,int mid){
        long ans=0;
        for(int i=0;i<piles.length;i++){
            ans += (long) Math.ceil((double) piles[i] / mid);
        }
        return ans;
    }
}