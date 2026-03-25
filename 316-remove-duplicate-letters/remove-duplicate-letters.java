class Solution {
    public String removeDuplicateLetters(String s) {
        int[]lastIndex=new int[26];
        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a']=i;
        }

        boolean[] isvisited=new boolean[26];
        Stack<Integer> st=new Stack();
        for(int i=0;i<s.length();i++){
            int curr=s.charAt(i) - 'a';
            if(isvisited[curr]) continue;
            while(!st.isEmpty() && st.peek() > curr && i< lastIndex[st.peek()]){
                isvisited[st.pop()]=false;
            }
            st.push(curr);
            isvisited[curr]=true;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()) sb.append((char)(st.pop() + 'a'));
        return sb.reverse().toString();
    }
}