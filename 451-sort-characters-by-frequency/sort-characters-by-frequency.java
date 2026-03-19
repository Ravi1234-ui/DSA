import java.util.*;

class Solution {
    public String frequencySort(String s) {
        int n = s.length();

        HashMap<Character, Integer> hm = new HashMap<>();

        // Step 1: Count frequency
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        // Step 2: Convert to list
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hm.entrySet());

        // Step 3: Sort by frequency (descending)
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        // Step 4: Build result
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list) {
            char ch = entry.getKey();
            int freq = entry.getValue();

            for (int i = 0; i < freq; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}