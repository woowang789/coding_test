package problem.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class P_42579 {
    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            List<Integer> answer = new ArrayList<>();
            Map<String, List<int[]>> map = new HashMap<>();
            Map<String, Integer> count = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if(!map.containsKey(genres[i])) {
                    map.put(genres[i], new ArrayList<>());
                }
                map.get(genres[i]).add(new int[]{i, plays[i]});
                count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
            }
            count.entrySet().stream().sorted((o1, o2) -> o2.getValue()-o1.getValue())
                    .forEach(o1->{
                        List<Integer> collect = map.get(o1.getKey()).stream()
                                .sorted((i1, i2) -> i2[1] - i1[1]).limit(2)
                                .map(i -> i[0])
                                .collect(Collectors.toList());
                        answer.addAll(collect);
                    });
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500});
        System.out.println(Arrays.toString(solution));

    }
}
