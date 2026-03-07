class Solution {
    public boolean searchMatrix(int[][] mat, int tgt) {

        int n = mat.length, m = mat[0].length;
        int i = 0, j = n - 1;

        while (i <= j) {

            int mid = i + (j - i) / 2;

            if (mat[mid][0] <= tgt && tgt <= mat[mid][m - 1]) {

                int k = 0, l = m - 1;

                while (k <= l) {
                    int mid2 = k + (l - k) / 2;

                    if (mat[mid][mid2] == tgt) return true;
                    else if (mat[mid][mid2] < tgt) k = mid2 + 1;
                    else l = mid2 - 1;
                }

                return false;
            }

            else if (mat[mid][0] > tgt) j = mid - 1;
            else i = mid + 1;
        }

        return false;
    }
}