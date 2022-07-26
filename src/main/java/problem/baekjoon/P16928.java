package problem.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int n_ladder = Integer.parseInt(token[0]);
        int n_snake = Integer.parseInt(token[1]);
        Map<Integer,Integer> map = new HashMap<>();
        boolean[] visited = new boolean[101];
        for (int i = 0; i < n_ladder + n_snake; i++) {
            String[] line = br.readLine().split(" ");
            map.put(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{1, 0});
        visited[0] = true;
        visited[1] = true;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if(cur[0] == 100) {
                System.out.println(cur[1]);
                return;
            }
            for (int i = 1; i <= 6; i++) {
                int next = cur[0] + i;
                if(next < 0 || next > 100) continue;
                if(visited[next]) continue;
                visited[next] = true;
                if(map.containsKey(next)){
                    next = map.get(next);
                    visited[next] = true;
                }
                que.offer(new int[]{next, cur[1] + 1});
            }
        }
        br.close();
    }
}
