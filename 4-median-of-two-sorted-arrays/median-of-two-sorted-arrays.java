class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int n = n1 + n2;

        int ind1 = (n / 2) - 1;
        int ind2 = (n / 2);

        int i = 0, j = 0;
        int cnt = 0;

        int el1 = -1, el2 = -1;

        while (i < n1 && j < n2) {

            int val;
            if (nums1[i] < nums2[j]) {
                val = nums1[i++];
            } else {
                val = nums2[j++];
            }

            if (cnt == ind1) el1 = val;
            if (cnt == ind2) el2 = val;

            cnt++;
        }

        while (i < n1) {
            int val = nums1[i++];

            if (cnt == ind1) el1 = val;
            if (cnt == ind2) el2 = val;

            cnt++;
        }

        while (j < n2) {
            int val = nums2[j++];

            if (cnt == ind1) el1 = val;
            if (cnt == ind2) el2 = val;

            cnt++;
        }

        if (n % 2 == 1) return el2;

        return (el1 + el2) / 2.0;
    }
}