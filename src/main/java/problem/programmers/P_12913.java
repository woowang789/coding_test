package problem.programmers;

import java.util.Arrays;

public class P_12913 {
    static class Solution {
        int solution(int[][] land) {
            int[][] dp = new int[land.length][4];
            dp[0] = land[0];
            for (int i = 1; i < land.length; i++) {
                for (int j = 0; j < 4; j++) {
                    dp[i][j] = land[i][j];
                    int max = 0;
                    for (int k = 0; k < 4; k++) {
                        if(j==k) continue;
                        max = Math.max(max, dp[i - 1][k]);
                    }
                    dp[i][j] += max;
                }
            }
            return Arrays.stream(dp[land.length - 1]).max().getAsInt();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        new int[][]{ new int[]{1,2,3,5},new int[]{5,6,7,8},new int[]{4,3,2,1} }
        int solution = sol.solution(new int[][]{
                new int[]{1, 2, 3, 5},
                new int[]{5, 6, 7, 8},
                new int[]{4, 3, 2, 1}});
        System.out.println("solution = " + solution);
    }
}
