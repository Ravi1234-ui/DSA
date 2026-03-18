class Solution {
    public String sortSentence(String s) {
        String[] arr = new String[10];
		    StringBuilder sb = new StringBuilder();
		    
		    for (int i = 0; i < s.length(); i++) {
		        char c = s.charAt(i);
		        
		        // 1. Check for letters (both cases)
		        if (Character.isLetter(c)) {
		            sb.append(c);
		        } 
		        // 2. Ignore spaces
		        else if (c == ' ') {
		            continue;
		        } 
		        // 3. If it's a digit, place the built word in the array
		        else if (Character.isDigit(c)) {
		            int idx = c - '0';
		            arr[idx] = sb.toString();
		            sb.setLength(0); // Clear StringBuilder for the next word
		        }
		    }
		    for(int i=1;i<arr.length;i++) {
		    	if(arr[i]!=null){
                    if(sb.length()>0) sb.append(' ');
                    sb.append(arr[i]);
                }
		    	    
		    	
		    }
		    return sb.toString();
    }
}