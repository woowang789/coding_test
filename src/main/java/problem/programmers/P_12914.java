package problem.programmers;

import java.util.Arrays;

public class P_12914 {
    static class Solution {
        static long[] dp;
        public long solution(int n) {
            dp = new long[2003];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n+2; i++) {
                dp[i] += dp[i - 1] %1234567;
                dp[i] += dp[i - 2] %1234567;
            }
            long answer = dp[n+1];
            return answer%1234567;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long solution1 = solution.solution(4);
        System.out.println("solution1 = " + solution1);
    }
}
