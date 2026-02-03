class Solution {
    public boolean isTrionic(int[] arr) {
      int n=arr.length;
      int i=0;
      while(i<n-1 && arr[i]<arr[i+1] ) i++;
      if(i==n-1 || i==0) return false;
      while(i<n-1 && arr[i]>arr[i+1]) i++;
        if(i==n-1)return false;
        while(i<n-1 && arr[i]<arr[i+1]) i++;
        return i==n-1;
    }
}