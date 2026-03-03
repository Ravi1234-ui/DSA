class Solution {
    public char findKthBit(int n, int k) {
        String[] arr=new String[21];
        arr[0]="0";
        for(int i=1;i<=20;i++){
            arr[i]=nextval(arr[i-1]);
        }
        return arr[n].charAt(k-1);
    }
    public String nextval(String val){
        StringBuilder newstr=new StringBuilder(val);
        newstr.append('1');
        for(int i=val.length()-1;i>=0;i--){
            if(val.charAt(i)=='1') newstr.append('0');
            else newstr.append('1');
        }
        return newstr.toString();
    }
}