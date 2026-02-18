class Solution {
    public static boolean hasAlternatingBits(int n) {
        while(n>0){
            int lst=n&1;
            n>>=1;
            if((n&1) == lst) return false;
        }
        return true;
    }
}