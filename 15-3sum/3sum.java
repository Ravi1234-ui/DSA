class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);   // Step 1
        
        int n = arr.length;
        
        for(int i = 0; i < n; i++) {
            
            // Skip duplicate first element
            if(i > 0 && arr[i] == arr[i-1]) continue;
            
            int left = i + 1;
            int right = n - 1;
            
            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                
                if(sum == 0) {
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    
                    // Skip duplicates
                    while(left < right && arr[left] == arr[left+1]) left++;
                    while(left < right && arr[right] == arr[right-1]) right--;
                    
                    left++;
                    right--;
                }
                else if(sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }
}
