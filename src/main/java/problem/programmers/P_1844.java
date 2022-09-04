package problem.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P_1844 {
    static class Solution {
        static int[] dy = new int[]{1, -1, 0, 0};
        static int[] dx = new int[]{0, 0, -1, 1};
        public int solution(int[][] maps) {
            int answer = 1;

            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{0, 0, 1});
            boolean[][] visited = new boolean[maps.length][maps[0].length];
            visited[0][0] = true;
            while (!que.isEmpty()) {
                int[] cur = que.poll();
                if (cur[0] == maps.length-1 && cur[1] == maps[0].length-1)
                    return cur[2];
                for (int i = 0; i < 4; i++) {
                    int ny = cur[0] + dy[i];
                    int nx = cur[1] + dx[i];

                    if(ny >= maps.length || nx >= maps[0].length || ny <0 || nx < 0) continue;
                    if(visited[ny][nx] || maps[ny][nx] == 0) continue;
                    visited[ny][nx] = true;
                    que.offer(new int[]{ny, nx, cur[2] + 1});
                }
            }
            return -1;
        }
    }
//    new int[][]{ new int[]{1,0,1,1,1},new int[]{1,0,1,0,1},new int[]{1,0,1,1,1},new int[]{1,1,1,0,1},new int[]{0,0,0,0,1} }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(
                new int[][]{
                        new int[]{1, 0, 1, 1, 1},
                        new int[]{1, 0, 1, 0, 1},
                        new int[]{1, 0, 1, 1, 1},
                        new int[]{1, 1, 1, 0, 1},
                        new int[]{0, 0, 0, 0, 1}}
        );
        System.out.println("solution = " + solution);
    }
}
