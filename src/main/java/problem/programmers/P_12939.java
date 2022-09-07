package problem.programmers;

import java.util.Arrays;

public class P_12939 {
    static class Solution {
        public String solution(String s) {
            String answer = "";
            int[] s1 = Arrays.stream(s.split(" "))
                    .mapToInt(Integer::parseInt).sorted().toArray();

            answer += s1[0]+" ";
            answer += s1[s1.length - 1];

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("-2 -11 -3 -4"));
    }
}
