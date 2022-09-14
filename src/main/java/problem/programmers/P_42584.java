package problem.programmers;

import java.util.Arrays;
import java.util.Stack;

public class P_42584 {
    static class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            Stack<int[]> st = new Stack<>();
            for (int i = 0; i < prices.length; i++) {
                while (!st.isEmpty() && st.peek()[1] > prices[i]) {
                    int[] pop = st.pop();
                    answer[pop[0]] = i - pop[0];
                }
                st.push(new int[]{i, prices[i]});
            }
            while (!st.isEmpty()) {
                int[] pop = st.pop();
                answer[pop[0]] = prices.length - 1 - pop[0];
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(new int[]{1, 2, 3, 2, 3});
        System.out.println(Arrays.toString(solution));

    }
}
