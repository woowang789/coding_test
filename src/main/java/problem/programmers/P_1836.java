package problem.programmers;

import java.util.*;

public class P_1836 {
    static class Solution {
         static int[] dy = new int[]{-1, 1, 0, 0};
         static int[] dx = new int[]{0, 0, -1, 1};

         static char[][] b;
         Map<Character, List<int[]>> map;
        public String solution(int m, int n, String[] board) {
            StringBuilder answer = new StringBuilder();
            b = new char[m][n];
            map = new HashMap<>();
            init(m, n, board);
            int len = map.size();
            List<Character> order = new ArrayList<>(map.keySet());
            order.sort((o1, o2) -> o1 - o2);
            for (int i = 0; i < len; i++) {
                char ch = find();
                if(ch == '-') return "IMPOSSIBLE";
                List<int[]> removePos = map.get(ch);
                for (int[] pos : removePos) b[pos[0]][pos[1]] = '.';
                answer.append(ch);
            }


            return answer.toString();
        }

        private Character find() {
            PriorityQueue<Character> queue = new PriorityQueue<>();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    if(Character.isAlphabetic(b[i][j]) && !set.contains(b[i][j]) &&canRemove(i, j)){
                        queue.offer(b[i][j]);
                        set.add(b[i][j]);
                    }
                }
            }
            return queue.isEmpty() ? '-' : queue.poll();
        }

        private boolean canRemove(int y,int x) {
            char target = b[y][x];
            boolean[][] visited = new boolean[b.length][b[0].length];
            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{y, x, -1, 0}); //y,x, 방향, 턴횟수
            visited[y][x] = true;
            while (!que.isEmpty()) {
                int[] cur = que.poll();
                if(cur[3] >=2 ) continue;
                if(cur[2]!=-1 && b[cur[0]][cur[1]] == target) return true;
                for (int i = 0; i < 4; i++) {
                    int ny = cur[0] + dy[i];
                    int nx = cur[1] + dx[i];
                    if(ny >= b.length || nx >= b[0].length || ny < 0 || nx < 0) continue;
                    if (visited[ny][nx] || b[ny][nx]=='*') continue;
                    if(Character.isAlphabetic(b[ny][nx]) && b[ny][nx] != target) continue;

                    visited[ny][nx] = true;
                    if(cur[2] == -1){ // 첫 시작이라 방향이 -1
                        que.offer(new int[]{ny, nx, i, 0});
                    }else{ // 진행도중일때
                        if(cur[2] != i) que.offer(new int[]{ny, nx, i, cur[3] + 1}); // 전 방향이랑 맞지 않을 때
                        else que.offer(new int[]{ny, nx, i, cur[3]}); // 전 방향과 맞을 때
                    }
                }
            }
            return false;

        }

        private void init(int m, int n, String[] board) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char target = board[i].charAt(j);
                    b[i][j] = target;
                    if(Character.isAlphabetic(target)){
                        if (!map.containsKey(target)) map.put(target, new ArrayList<>());
                        map.get(target).add(new int[]{i, j});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution = sol.solution(2, 2, new String[]{
                "AB", "BA"
        });
        System.out.println("solution = " + solution);
    }
}
