package problem.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_1829 {
    static class Solution {
        static int[] dy = new int[]{-1, 1, 0, 0};
        static int[] dx = new int[]{0, 0, -1, 1};
        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;
            int[] answer = new int[2];
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && picture[i][j] != 0) {
                        numberOfArea++;
                        int count = 0;
                        Queue<int[]> que = new LinkedList<>();
                        que.offer(new int[]{i, j});
                        visited[i][j] = true;
                        while (!que.isEmpty()) {
                            count++;
                            int[] cur = que.poll();
                            for (int k = 0; k < 4; k++) {
                                int ny = cur[0] + dy[k];
                                int nx = cur[1] + dx[k];
                                if (ny >= m || nx >= n || ny < 0 || nx < 0) continue;
                                if (picture[ny][nx] != picture[i][j] || visited[ny][nx]) continue;
                                visited[ny][nx] = true;
                                que.offer(new int[]{ny, nx});
                            }
                        }
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                    }
                }
            }
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//  new int[]{new int[]{1, 1, 1, 0}, new int[]{1, 2, 2, 0}, new int[]{1, 0, 0, 1}, new int[]{0, 0, 0, 1}, new int[]{0, 0, 0, 3}, new int[]{0, 0, 0, 3}}
        System.out.println(Arrays.toString(
                sol.solution(6, 4,
                new int[][]{
                        new int[]{1, 1, 1, 0},
                        new int[]{1, 2, 2, 0},
                        new int[]{1, 0, 0, 1},
                        new int[]{0, 0, 0, 1},
                        new int[]{0, 0, 0, 3},
                        new int[]{0, 0, 0, 3}
                }
        )));
    }
}
