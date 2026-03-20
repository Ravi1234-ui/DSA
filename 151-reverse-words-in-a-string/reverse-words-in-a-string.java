class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int i = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            int j = i;
            // find the word
            while (j >= 0 && s.charAt(j) != ' ') j--;
            // append word
            if (sb.length() > 0) sb.append(" ");
            sb.append(s.substring(j + 1, i + 1));
            // skip multiple spaces
            while (j >= 0 && s.charAt(j) == ' ') j--;
            i = j;
        }
        return sb.toString();
    }
}