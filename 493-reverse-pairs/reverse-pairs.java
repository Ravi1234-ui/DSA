class Solution {
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // count reverse pairs
    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;

        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2L * arr[right]) {
                right++;
            }
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public static int mergeSort(int[] arr, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int cnt = 0;

        cnt += mergeSort(arr, left, mid);
        cnt += mergeSort(arr, mid + 1, right);
        cnt += countPairs(arr, left, mid, right);
        merge(arr, left, mid, right);

        return cnt;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
}