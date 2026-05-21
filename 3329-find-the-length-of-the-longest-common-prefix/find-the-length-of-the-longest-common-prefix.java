class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int common=0;
        HashSet<Integer> prefixset = new HashSet<>();
        for(int num:arr1){
            while(num>0){
                prefixset.add(num);
                num/=10;
            }
        }
        for(int num:arr2){
            while(num>0){
                if(prefixset.contains(num)){
                    int prefixLength = String.valueOf(num).length();
                    if(prefixLength > common) {
                        common = prefixLength;
                    }
                    break;
                }
                num/=10;
            }
        }
        return common;

    }
}