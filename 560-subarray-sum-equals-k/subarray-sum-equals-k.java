class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
		hm.put(0, 1);
		int cnt=0,pre_sum=0;
		for(int i=0;i<arr.length;i++) {
			pre_sum+=arr[i];
			int remove=pre_sum-k;
			cnt+=hm.getOrDefault(remove, 0);
			hm.put(pre_sum, hm.getOrDefault(pre_sum,0)+1);
		}
		return cnt;
    }
}