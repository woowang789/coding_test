package problem.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_118668 {
    static class Solution {
        private int[][] dp;
        public int solution(int alp, int cop, int[][] problems) {
            int maxA = Arrays.stream(problems).max((o1, o2) -> o1[0] - o2[0]).get()[0];
            int maxC = Arrays.stream(problems).max((o1, o2) -> o1[1] - o2[1]).get()[1];
            System.out.println(maxA + " " + maxC);
            dp = new int[maxA+1][maxC+1];
            for (int[] ints : dp) Arrays.fill(ints, Integer.MAX_VALUE);
            dp[Math.min(alp, maxA)][Math.min(cop, maxC)] = 0;

            for (int i = Math.min(alp,maxA); i <= maxA; i++) {
                for (int j = Math.min(cop, maxC); j <= maxC; j++) {
                    int y_ = Math.min(i + 1, maxA);
                    int x_ = Math.min(j + 1, maxC);
                    dp[y_][j] = Math.min(dp[i][j] + 1, dp[y_][j]);
                    dp[i][x_] = Math.min(dp[i][j] + 1, dp[i][x_]);

                    for (int[] p : problems) {
                        if(p[0] <= i && p[1] <= j){
                            int y = Math.min(i + p[2], maxA);
                            int x = Math.min(j + p[3], maxC);
                            dp[y][x] = Math.min(dp[y][x], dp[i][j] + p[4]);
                        }
                    }
                }
            }
            return dp[maxA][maxC];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        [10,15,2,1,2],[20,20,3,3,4]
        System.out.println(sol.solution(10, 10, new int[][]{
                new int[]{10, 15, 2, 1, 2}, new int[]{20, 20, 3, 3, 4}
        }));

    }
}
