class Solution {
    static int func(int[] wt,int cap) {
		int days=1,load=0;
		for(int i=0;i<wt.length;i++) {
			if(load+wt[i] >cap) {
				days++;
				load=wt[i];
			}else load+=wt[i];
		}
		return days;
	}
    public int shipWithinDays(int[] wt, int days) {
        int n=wt.length;
		int max=wt[0] ,sum=wt[0];
		for(int i=1;i<n;i++) {
			if(max<wt[i]) max=wt[i];
			sum+=wt[i];
		}
		int low=max,high=sum;
		while(low<=high) {
			int mid=low+(high-low)/2;
			if(func(wt, mid)<=days) high=mid-1;
			else low=mid+1;
		}
		return low;
    }
}