package problem.programmers;

public class P_12945 {
    static class Solution {

        public int solution(int n) {
            int[] dp = new int[100001];
            dp[1] = 1;
            for (int i = 2; i <= n; i++)
                dp[i] = (dp[i - 1] + dp[i - 2])%1234567;

            return dp[n];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(5);
        System.out.println("solution = " + solution);
    }
}
