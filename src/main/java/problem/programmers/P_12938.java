package problem.programmers;

import java.util.Arrays;

public class P_12938 {
    static class Solution {
        public int[] solution(int n, int s) {
            if (s < n)
                return new int[]{-1};

            int[] answer = new int[n];
            int t = s / n;
            int sum = s - (t * n);
            for (int i = 0; i < n; i++) {
                if (i >= n - sum) {
                    answer[i] = t + 1;
                } else answer[i] = t;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(2, 9);
        System.out.println(Arrays.toString(solution));
    }
}
