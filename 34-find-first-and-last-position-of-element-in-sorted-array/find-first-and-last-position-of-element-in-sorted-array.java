class Solution {
    public int firstIdx(int[]nums,int x){
        int n=nums.length,low=0,high=n-1,first=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==x){
                first=mid;
                high=mid-1;
            }
            else if(nums[mid]<x) low=mid+1;
            else high=mid-1;
        }
        return first;
    }
    public int lastIdx(int[]nums,int x){
        int n=nums.length,low=0,high=n-1,last=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==x){
                last=mid;
                low=mid+1;
            }
            else if(nums[mid]<x) low=mid+1;
            else high=mid-1;
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int first=firstIdx(nums,target);
        if(first==-1) return new int[]{-1,-1};
        int last=lastIdx(nums,target);
        return new int[]{first,last};
    }
}