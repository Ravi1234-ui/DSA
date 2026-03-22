class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            mat = rotate(mat);  // directly update mat
            if (isEqual(mat, target)) return true;
        }
        return false;
    }

    public int[][] rotate(int[][] mat) {
        int n = mat.length;

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Reverse each row
        for (int[] row : mat) {
            int j = 0, k = row.length - 1;
            while (j < k) {
                int temp = row[j];
                row[j] = row[k];
                row[k] = temp;
                j++;
                k--;
            }
        }

        return mat;
    }

    public boolean isEqual(int[][] mat1, int[][] mat2) {
        int n = mat1.length, m = mat1[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat1[i][j] != mat2[i][j]) return false;
            }
        }

        return true;
    }
}