class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            if (list.isEmpty() || list.get(list.size() - 1).get(1) < intervals[i][0]) {
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                list.get(list.size() - 1).set(1,
                    Math.max(list.get(list.size() - 1).get(1), intervals[i][1]));
            }
        }

        // Convert List<List<Integer>> back to int[][]
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }
        return result;
    }
}