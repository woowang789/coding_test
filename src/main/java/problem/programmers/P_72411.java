package problem.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class P_72411 {
    static class Solution {
        static Map<String, Integer> map;
        public String[] solution(String[] orders, int[] course) {
            List<String> answer = new ArrayList<>();
            for (int i : course) {
                map = new HashMap<>();
                for (String o: orders) {
                    String order = sortString(o);
                    if (order.length() >= i) {
                        solve(order, i, 0, new StringBuilder());
                    }
                }
                List<Map.Entry<String, Integer>> collect = map.entrySet().stream()
                        .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                        .collect(Collectors.toList());
                if(collect.isEmpty()) continue;
                int max = collect.get(0).getValue();
                if(max<2) continue;
                for (Map.Entry<String, Integer> entry : collect) {
                       if(entry.getValue()==max) answer.add(entry.getKey());
                }
            }
            answer.sort(Comparator.naturalOrder());
            return answer.toArray(new String[0]);
        }
        
        private void solve(String order, int len, int idx,StringBuilder sb) {
            if (sb.length() == len) {

                map.put(sortString(sb.toString()), map.getOrDefault(sb.toString(), 0) + 1);
                return;
            }
            for (int i = idx; i < order.length(); i++) {
                sb.append(order.charAt(i));
                solve(order, len, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        private String sortString(String sb) {
            char[] chars = Arrays.copyOf(sb.toCharArray(), sb.length());
            Arrays.sort(chars);
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] solution = sol.solution(
                new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                new int[]{2, 3, 4});
        System.out.println(Arrays.toString(solution));
    }
}
