class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length) return -1;

        int maxi=bloomDay[0],mini=bloomDay[0];
        for(int i=1;i<bloomDay.length;i++){
            if(maxi<bloomDay[i]) maxi=bloomDay[i];
            if(mini>bloomDay[i]) mini=bloomDay[i];
        }
        int low=1,high=maxi;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(bloomDay,mid,m,k)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    static boolean isPossible(int[]arr,int mid,int m,int k){
        int total=0,cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid) cnt++;
            else {
                total+=cnt/k;
                cnt=0;
            }
        }
        total+=cnt/k;
        return total>=m;
    }
}