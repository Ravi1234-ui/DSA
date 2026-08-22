class Solution {
    public boolean checkDivisibility(int n) {
        if(n<0) return false;
        int sum=0,temp=n,prod=1;
        while(temp>0){
            int rem= temp%10;
            sum+=rem;
            prod*=rem;
            temp/=10;
        }
        if ((sum + prod) == 0) {
            return false; 
        }
        return n % (sum +prod ) == 0;
    }
}