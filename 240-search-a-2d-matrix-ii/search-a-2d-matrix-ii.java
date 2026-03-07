class Solution {
    public boolean searchMatrix(int[][] mat, int tgt) {
        int n=mat.length,m=mat[0].length;
        for(int[] row:mat){
            int i=0,j=m-1;
            while(i<=j){
                int mid=i+(j-i)/2;
                if(row[mid]==tgt) return true;
                else if(row[mid]<tgt) i=mid+1;
                else j=mid-1;
            }
        }
        return false;
    }
}