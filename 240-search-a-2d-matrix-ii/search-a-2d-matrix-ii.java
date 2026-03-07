class Solution {
    public boolean searchMatrix(int[][] mat, int tgt) {
        int n=mat.length,m=mat[0].length;
		int row=0,col=m-1;
		while(row<n && col>=0) {
			if(mat[row][col]==tgt) return true;
			else if(mat[row][col] < tgt) row++;
			else col--;
		}
		return false;
    }
}