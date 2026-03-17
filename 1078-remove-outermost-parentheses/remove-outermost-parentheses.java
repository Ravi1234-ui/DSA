class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            
            // Opening bracket
            if (ch == '(') {
                if (count > 0) {
                    sb.append(ch);   // not outermost
                }
                count++;
            } 
            
            // Closing bracket
            else {
                count--;
                if (count > 0) {
                    sb.append(ch);   // not outermost
                }
            }
        }

        return sb.toString();
    }
}