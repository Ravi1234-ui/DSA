class Solution {
    public List<Integer> majorityElement(int[] arr) {
        ArrayList<Integer> list=new ArrayList<Integer>();
		int cnt1=0,cnt2=0,el1=Integer.MIN_VALUE,el2=Integer.MAX_VALUE,n=arr.length;
		for(int i=0;i<n;i++) {
			if(cnt1==0 && arr[i]!=el2) {
				cnt1=1;
				el1=arr[i];
			}else if(cnt2==0 && arr[i]!=el1) {
				cnt2=1;
				el2=arr[i];
			}else if(arr[i]==el1) cnt1++;
			else if(arr[i]==el2) cnt2++;
			else {
				cnt1--;
				cnt2--;
			}
		}
		cnt1=0;
		cnt2=0;
		for(int i=0;i<n;i++) {
			if(arr[i]==el1)cnt1++;
			else if(arr[i]==el2) cnt2++;
		}
		if(cnt1>n/3) list.add(el1);
		if(cnt2>n/3) list.add(el2);
		return list;
    }
}