package problem.programmers;

import java.util.*;

public class P_49189 {
    static class Solution {
        public int solution(int n, int[][] edge) {
            int answer = 0;
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 1; i <= n; i++) map.put(i, new ArrayList<>());
            for (int[] ints : edge) {
                int a = ints[0];
                int b = ints[1];
                map.get(a).add(b);
                map.get(b).add(a);
            }
            Queue<Integer> que = new LinkedList<>();
            que.offer(1);
            int[] dist = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[1] = 0;
            visited[1] = true;
            while (!que.isEmpty()) {
                int cur = que.poll();

                List<Integer> arr = map.get(cur);
                for (Integer node : arr) {
                    if (dist[node] > dist[cur] + 1) {
                        dist[node] = dist[cur] + 1;
                        if(!visited[node]){
                            visited[node] = true;
                            que.offer(node);
                        }
                    }
                }
            }
            int count = 0;
            int max = 0;
            for (int i = 1; i <= n; i++) {
                if (max < dist[i]) {
                    max = dist[i];
                    count = 1;
                } else if (max == dist[i]) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        new int[][]{ new int[]{3, 6}, new int[]{4, 3}, new int[]{3, 2}, new int[]{1, 3}, new int[]{1, 2}, new int[]{2, 4}, new int[]{5, 2} }
        int solution = sol.solution(
                6, new int[][]{
                        new int[]{3, 6},
                        new int[]{4, 3},
                        new int[]{3, 2},
                        new int[]{1, 3},
                        new int[]{1, 2},
                        new int[]{2, 4},
                        new int[]{5, 2}}
        );
        System.out.println("solution = " + solution);
    }
}
