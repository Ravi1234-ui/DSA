class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) return true;

        char[] arr = s.toCharArray();
        int n = s.length();

        while (n > 0) {
            shift(arr);
            if (new String(arr).equals(goal)) return true;
            n--;
        }
        return false;
    }

    public void shift(char[] arr) {
        char temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }
}