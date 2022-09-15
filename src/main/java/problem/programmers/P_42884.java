package problem.programmers;

import java.util.Arrays;

public class P_42884 {
    static class Solution {
        public int solution(int[][] routes) {
            int answer = 0;
            Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
            int idx = 0;
            while (idx < routes.length) {
                int pos = routes[idx][1];
                while (idx + 1 < routes.length) {
                    int[] route = routes[idx + 1];
                    if(route[0] <= pos && route[1] >=pos) idx++;
                    else break;
                }
                idx++;
                answer++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        new int[][]{ new int[]{-20,-15}, new int[]{-14,-5}, new int[]{-18,-13}, new int[]{-5,-3} }
        int solution = sol.solution(new int[][]{
                new int[]{-20, -15},
                new int[]{-14, -5},
                new int[]{-18, -13},
                new int[]{-5, -3}}
        );
        System.out.println("solution = " + solution);
    }
}
