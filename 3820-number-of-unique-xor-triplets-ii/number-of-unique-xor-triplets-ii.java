import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
       int n=nums.length;
       int T=1,max=nums[0];
       for(int i=0;i<n;i++) max=Math.max(nums[i],max);
       while(T <=max){
        T*=2;
       }
       boolean[] arr1=new boolean[T] ,arr2=new boolean[T];
       Arrays.fill(arr1,false);
       Arrays.fill(arr2,false);
       for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            arr1[nums[i]^nums[j]]=true;
        }
       }
       for(int i=0;i<T;i++){
        if(arr1[i]==true){
            for(int j:nums) arr2[j ^ i]=true;
        }
       }
       int count=0;
       for(int i=0;i<T;i++) if(arr2[i]) count++;
       return count;
    }
}