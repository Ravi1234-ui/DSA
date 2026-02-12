class Solution {
    public int longestBalanced(String s) {
        int max = 0;
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            int[] freq=new int[26];
            for(int j=i;j<n;j++){
                int c=s.charAt(j)-'a';
                freq[c]++;
                if(isbalanced(freq)){
                    max=Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
    
    public static boolean isbalanced(int[]freq){
        int c=0;
        for(int a:freq){
            if(a==0) continue;
            if(c==0) c=a;
            if(a!=c) return false;
        }
        return true;
    }
}