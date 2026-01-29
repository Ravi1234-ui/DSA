class Solution {
    static ArrayList<Integer> nthRow(int n) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		int ans=1;
		list.add(ans);
		for(int i=1;i<n;i++) {
			ans*=(n-i);
			ans/=i;
			list.add(ans);
		}
		return list;
	}
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            list.add(new ArrayList(nthRow(i)));
        }
        return list;
    }
}