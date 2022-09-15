package problem.programmers;

public class P_12900 {
    static class Solution {
        public int solution(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;
            for (int i = 4; i <= n; i++)
                dp[i] = (dp[i - 1] + dp[i - 2])%1000000007;

            return dp[n];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(4);
        System.out.println(solution);

    }
}
