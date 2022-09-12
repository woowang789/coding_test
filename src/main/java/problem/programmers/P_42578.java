package problem.programmers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_42578 {
    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            Map<String, Integer> map = new HashMap<>();
            for (String[] clothe : clothes)
                map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
            System.out.println(map);
            for (Integer value : map.values()) {
                answer *= value + 1;
            }
            return answer-1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new String[][]{
                new String[]{"crow_mask", "face"},
                new String[]{"blue_sunglasses", "face"},
                new String[]{"smoky_makeup", "face"}});
        System.out.println("solution = " + solution);
    }
//    new String[][]{ new String[]{"crow_mask", "face"}, new String[]{"blue_sunglasses", "face"}, new String[]{"smoky_makeup", "face"} }
}
