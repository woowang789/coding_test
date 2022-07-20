package problem.baekjoon;

import java.io.*;
import java.util.*;

public class P7569 {
    private static int[] dy = new int[]{-1,1,0,0,0,0};
    private static int[] dx = new int[]{0,0,-1,1,0,0};
    private static int[] dh = new int[]{0,0,0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int x = Integer.parseInt(token[0]);
        int y = Integer.parseInt(token[1]);
        int h = Integer.parseInt(token[2]);
        int[][][] arr = new int[h][y][x];
        for(int k=0;k<h;k++){
            for(int i =0;i<y;i++){
                String[] line = br.readLine().split(" ");
                for(int j=0;j<x;j++) arr[k][i][j] = Integer.parseInt(line[j]);
            }
        }
        System.out.println(solve(arr));
        br.close();
    }
    //  1 : 익은 토마토 / 0: 익지않은 토마토 / -1 : 빈칸

    private static int solve(int[][][] arr){
        Queue<int[]> que = new LinkedList<>();
        for(int k=0;k<arr.length;k++){
            for(int i =0;i<arr[0].length;i++){
                for(int j=0;j<arr[0][0].length;j++){
                    if(arr[k][i][j] == 1){ // 익은 토마토
                        que.add(new int[]{k,i,j});
                    }
                }
            }
        }
        while(!que.isEmpty()){
            int[] poll = que.poll();
            int h = poll[0];
            int y = poll[1];
            int x= poll[2];

            for(int i =0;i<6;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                int nh = h + dh[i];
                if(nh >= arr.length || ny >= arr[0].length || nx >= arr[0][0].length || nh <0 || ny < 0 || nx <0) continue;
                if(arr[nh][ny][nx] != 0) continue; //익지 않은 토마토가 아니면 패스
                arr[nh][ny][nx] = arr[h][y][x] + 1;
                que.add(new int[]{nh,ny,nx});
            }
        }
        int ret = Integer.MIN_VALUE;
        for(int k=0;k< arr.length;k++){
            for(int i=0;i<arr[0].length;i++){
                for(int j=0;j<arr[0][0].length;j++){
                    if(arr[k][i][j] == 0) return -1;

                    ret = Math.max(ret, arr[k][i][j]);
                }
            }
        }
        return ret -1 ;
    }
}
