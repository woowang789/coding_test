package problem.programmers;

import java.util.Arrays;

public class P_68936 {
    static class Solution {
        public int[] solution(int[][] arr) {
            int size = arr.length;
            return solve(0, 0, size, arr);
        }

        private int[] solve(int y, int x, int size,int[][] arr) {
            if (check(y, x, size, arr)) {
                return arr[y][x] == 0 ? new int[]{1, 0} : new int[]{0, 1};
            }
            int[] topL = solve(y, x, size / 2, arr);
            int[] topR = solve(y, x + size / 2, size / 2, arr);
            int[] botL = solve(y + size / 2, x, size / 2, arr);
            int[] botR = solve(y + size / 2, x + size / 2, size / 2, arr);
            return new int[]{topL[0] + topR[0] + botL[0] + botR[0], topL[1] + topR[1] + botL[1] + botR[1]};
        }

        private boolean check(int y, int x, int size,int[][] arr) {
            int target = arr[y][x];
            for (int i = y; i < y + size; i++) {
                for (int j = x; j < x + size; j++) {
                    if(target != arr[i][j]) return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        new int[][]{ new int[]{1,1,0,0},new int[]{1,0,0,0},new int[]{1,0,0,1},new int[]{1,1,1,1} }
        int[] solution = sol.solution(
                new int[][]{
                        new int[]{1, 1, 0, 0},
                        new int[]{1, 0, 0, 0},
                        new int[]{1, 0, 0, 1},
                        new int[]{1, 1, 1, 1}}
        );
        System.out.println(Arrays.toString(solution));
    }
}
