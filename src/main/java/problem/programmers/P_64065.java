package problem.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class P_64065 {
    static class Solution {
        public int[] solution(String s) {
            List<Set<Integer>> collect = Arrays.stream(s.substring(2, s.length() - 2).split("},\\{"))
                    .map(i ->
                            Arrays.stream(i.split(","))
                                    .map(Integer::parseInt).collect(Collectors.toSet())
                    ).collect(Collectors.toList());
            Map<Integer, Integer> map = new HashMap<>();

            for (Set<Integer> set : collect)
                for (int v : set)
                    map.put(v, map.getOrDefault(v, 0) + 1);

            return map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue())
                    .map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        System.out.println(Arrays.toString(solution));
    }
}
