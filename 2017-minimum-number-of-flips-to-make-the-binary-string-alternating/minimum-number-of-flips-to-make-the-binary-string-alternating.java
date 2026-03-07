class Solution {
    public int minFlips(String s) {
        int n = s.length();

        int flip1 = 0, flip2 = 0;
        int i = 0, j = 0, ans = Integer.MAX_VALUE;

        while (j < 2 * n) {

            char expected1 = (j % 2 == 0) ? '0' : '1';
            char expected2 = (j % 2 == 0) ? '1' : '0';

            if (s.charAt(j % n) != expected1) flip1++;
            if (s.charAt(j % n) != expected2) flip2++;

            if (j - i + 1 > n) {
                expected1 = (i % 2 == 0) ? '0' : '1';
                expected2 = (i % 2 == 0) ? '1' : '0';

                if (s.charAt(i % n) != expected1) flip1--;
                if (s.charAt(i % n) != expected2) flip2--;

                i++;
            }

            if (j - i + 1 == n) {
                ans = Math.min(ans, Math.min(flip1, flip2));
            }

            j++;
        }

        return ans;
    }
}