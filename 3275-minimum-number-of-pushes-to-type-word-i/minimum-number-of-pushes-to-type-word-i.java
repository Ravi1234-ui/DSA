class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        if(n<9) return n;
        else if(n>=9 && n<17) return 8 + (n-8)*2;
        else if(n>=17 && n<25) return 24 + (n-16)*3;
        else return 48 + (n-24)*4;
    }
}