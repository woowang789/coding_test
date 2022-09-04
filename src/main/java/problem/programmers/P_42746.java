package problem.programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P_42746 {
    static class Solution {
        public String solution(int[] numbers) {
            String ret = Arrays.stream(numbers)
                    .mapToObj(Integer::toString)
                    .sorted((o1, o2) -> (o2 + o1)
                            .compareTo(o1 + o2))
                    .collect(Collectors.joining());
            for (int i = 0; i < ret.length()-1; i++) {
                if(ret.charAt(i) != '0') return ret.substring(i);
            }
            return "0";
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[]{3, 30, 34, 5, 9});
    }
}
