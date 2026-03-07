class Solution {
    public int minFlips(String s) {
       int n=s.length();
       s=s+s;
       char[]s1=new char[2*n];
       char[]s2=new char[2*n];
       for(int i=0;i<2*n;i++){
            s1[i]=(i%2==0 ? '0' : '1');
            s2[i]=(i%2==0? '1' : '0');
       }
       int flip1=0,flip2=0;
       int i=0,j=0,ans=Integer.MAX_VALUE;
       while(j<2*n){
            if(s.charAt(j)!=s1[j]) flip1++;
            if(s.charAt(j) !=s2[j]) flip2++;

            if(j-i+1>n){
                if(s.charAt(i) !=s1[i]) flip1--;
                if(s.charAt(i) !=s2[i]) flip2--;
                i++;
            }
            if(j-i+1==n){
                ans=Math.min(ans,Math.min(flip1,flip2));
            }
            j++;
       }
       return ans;
    }
}