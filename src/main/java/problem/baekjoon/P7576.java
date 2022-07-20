package problem.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P7576 {
    private static int[] dy = new int[]{-1,1,0,0};
    private static int[] dx = new int[]{0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int w = Integer.parseInt(token[0]);
        int h = Integer.parseInt(token[1]);
        int[][] arr = new int[h][w];
        for(int i =0;i<h;i++){
            String[] line = br.readLine().split(" ");
            for(int j=0;j<w;j++) arr[i][j] = Integer.parseInt(line[j]);
        }
        System.out.println(solve(arr,h,w));
    }
    private static int solve(int[][] arr, int h, int w){
        Queue<int[]> que = new LinkedList<>();
        for(int i =0;i<h;i++){
            for(int j=0;j<w;j++){
                if(arr[i][j] == 1) que.offer(new int[]{i,j});
            }
        }

        while(!que.isEmpty()){
            int[] poll = que.poll();
            int y = poll[0];
            int x = poll[1];

            for(int i =0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny >= h || nx >= w || ny <0 || nx < 0) continue;
                if(arr[ny][nx] != 0) continue;
                arr[ny][nx] = arr[y][x]+1;
                que.offer(new int[]{ny,nx});
            }
        }
        int ret = Integer.MIN_VALUE;
        for(int i =0;i<h;i++){
            for(int j=0;j<w;j++){
                if(arr[i][j] == 0) return -1;
                ret = Math.max(ret,arr[i][j]);
            }
        }
        return ret-1;
    }
}
