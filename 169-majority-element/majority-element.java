class Solution {
    public int majorityElement(int[] arr) {
        int n=arr.length;
		HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
		}
		int maximum=-1,key=0;
		for(Map.Entry<Integer, Integer> entry:hm.entrySet()) {
			if(maximum<entry.getValue()) {
				key=entry.getKey();
				maximum=entry.getValue();
			}
		}
		return key;	
    }
}