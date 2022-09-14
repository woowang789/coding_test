package problem.programmers;

public class P_87946 {
    static class Solution {
        boolean[] visited;
        public int solution(int k, int[][] dungeons) {
            int answer = -1;
            visited = new boolean[dungeons.length];
            return solve(dungeons, k, 0, 0);
        }

        private int solve(int[][] dungeons, int k,int count, int depth) {
            if (depth == dungeons.length) {
                return count;
            }
            int ret = 0;
            for (int i = 0; i < dungeons.length; i++) {
                if(!visited[i]){
                    visited[i] = true;
                    if(k >= dungeons[i][0])
                        ret = Math.max(solve(dungeons, k - dungeons[i][1], count + 1, depth + 1),ret);
                    else
                        ret = Math.max(solve(dungeons, k, count, depth + 1), ret);
                    visited[i] = false;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        new int[][]{ new int[]{80,20},new int[]{50,40},new int[]{30,10} }
        int solution = sol.solution(80, new int[][]{
                new int[]{80, 20},
                new int[]{50, 40},
                new int[]{30, 10}});
        System.out.println("solution = " + solution);
    }
}
