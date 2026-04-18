class Solution {
    public int mirrorDistance(int n) {
        if(n<10) return 0;
        int rev=0,temp=n;
        while(temp>0){
            int rem=temp%10;
            rev=rev*10+rem;
            temp/=10;
        }
        return Math.abs(n-rev);
    }
    
}