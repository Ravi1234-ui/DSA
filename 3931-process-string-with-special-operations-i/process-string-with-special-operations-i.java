class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            switch (c) {
                case '*':
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    break;
                case '#':
                    if (sb.length() > 0) {
                        sb.append(sb.toString());
                    }
                    break;
                case '%':
                    sb.reverse();
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}