package problem.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P16236 {
    private static int[] dy = new int[]{-1,0,0,1};
    private static int[] dx = new int[]{0,-1,1,0};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int level = 2;
        int count = 0;
        int time = 0;
        int[] cur = {};
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
                if(arr[i][j] == 9) cur = new int[]{i, j};
            }
        }
        while(true){
            int[] target = find(arr, cur, level);
            System.out.println(Arrays.toString(target));
            if(target[0] == -1 && target[1] == -1) break; // 더 이상 먹을 게 없을때
            arr[cur[0]][cur[1]] = 0;
            arr[target[0]][target[1]] = 9;
            count++;
            if (count == level) {
                count = 0;
                level++;
            }
            time+= target[2];
            cur = new int[]{target[0], target[1]};

        }
        System.out.println(time);
        for (int[] line : arr) {
            System.out.println(Arrays.toString(line));
        }
        br.close();
    }
    private static int[] find(int[][] arr,int[] pos,int level){ // y ,x , dep
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{pos[0],pos[1],0});
        boolean[][] visited = new boolean[arr.length][arr.length];
        visited[pos[0]][pos[1]] = true;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if(arr[cur[0]][cur[1]] != 0 && cur[2] != 0 && arr[cur[0]][cur[1]] < level){ // 내 자신이 아니고, 내가 먹을 수 있을때
                return cur;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(ny >= arr.length || ny < 0 || nx >= arr.length || nx < 0) continue;
                if(visited[ny][nx]) continue;
                visited[ny][nx] = true;
                que.offer(new int[]{ny, nx,cur[2]+1});
            }
        }
        return new int[]{-1, -1};
    }
}
