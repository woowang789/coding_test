package problem.programmers;

import java.util.*;

public class P_81302 {
    static class Solution {
        final int SIZE = 5;
        final int[] dy = new int[]{-1, 1, 0, 0};
        final int[] dx = new int[]{0, 0, -1, 1};
        public int[] solution(String[][] places) {
            List<Integer> answer = new ArrayList<>();
            for (String[] place : places) {
                boolean solve = solve(place);
                answer.add(solve ? 1 : 0);
            }
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }

        private boolean solve(String[] place) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (place[i].charAt(j) == 'P') {
                        boolean check = check(place, i, j);
                        if(!check) return false;
                    }
                }
            }
            return true;
        }

        private boolean check(String[] place,int y,int x) {
            Queue<int[]> que = new LinkedList<>();
            boolean[][] visited = new boolean[SIZE][SIZE];
            que.offer(new int[]{y, x, 0});
            visited[y][x] = true;
            while (!que.isEmpty()) {
                int[] cur = que.poll();
                if(cur[2] > 1) return true;

                for (int i = 0; i < 4; i++) {
                    int ny = dy[i] + cur[0];
                    int nx = dx[i] + cur[1];
                    if (ny >= SIZE || nx >= SIZE || ny < 0 || nx < 0) continue;
                    if(visited[ny][nx] || place[ny].charAt(nx) == 'X') continue;
                    if(place[ny].charAt(nx) == 'P') {
                        return false;
                    }
                    visited[ny][nx] = true;
                    que.offer(new int[]{ny, nx, cur[2] + 1});
                }
            }
            return true;
        }
    }

//    new String[][]{
//    new String[]{
//    "POOOP",
//    "OXXOX",
//    "OPXPX",
//    "OOXOX",
//    "POXXP"},
//    new String[]{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
//    new String[]{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
//    new String[]{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
//    new String[]{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
//    }
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] solution = sol.solution(
                new String[][]{
                        new String[]{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        new String[]{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        new String[]{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                        new String[]{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        new String[]{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
                });
        System.out.println(Arrays.toString(solution));
    }
}
