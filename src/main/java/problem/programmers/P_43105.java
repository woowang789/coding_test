package problem.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_43105 {
    static class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            int[][] dp = new int[triangle.length][triangle.length];
            dp[0][0] = triangle[0][0];
            for (int i = 0; i < triangle.length-1; i++) {
                for (int j = 0; j < triangle[i].length; j++) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + triangle[i + 1][j]);
                    dp[i + 1][j+1] = Math.max(dp[i + 1][j+1], dp[i][j] + triangle[i + 1][j+1]);
                }
            }
            return Arrays.stream(dp[triangle.length - 1]).max().getAsInt();
        }
    }

    public static void main(String[] args) {
//        new int[][]{ new int[]{7}, new int[]{3, 8}, new int[]{8, 1, 0}, new int[]{2, 7, 4, 4}, new int[]{4, 5, 2, 6, 5} }
        Solution sol = new Solution();
        int solution = sol.solution(new int[][]{
                new int[]{7},
                new int[]{3, 8},
                new int[]{8, 1, 0},
                new int[]{2, 7, 4, 4},
                new int[]{4, 5, 2, 6, 5}});
        System.out.println(solution);

    }
}
