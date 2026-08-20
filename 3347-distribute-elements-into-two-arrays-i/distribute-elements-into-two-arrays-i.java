class Solution {
    public int[] resultArray(int[] nums) {
       List<Integer> arr1=new ArrayList<>() , arr2=new ArrayList<>();
       arr1.add(nums[0]);
       arr2.add(nums[1]);
       for(int i=2;i<nums.length;i++){
        if(arr1.getLast()>arr2.getLast()){
            arr1.add(nums[i]);
        }else arr2.add(nums[i]);
       } 

       int[] result=new int[nums.length];
       int index = 0;
        
        for (int val : arr1) {
            result[index++] = val;
        }
        for (int val : arr2) {
            result[index++] = val;
        }
        
       return result;
    }
}