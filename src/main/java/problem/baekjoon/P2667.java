package problem.baekjoon;

import java.io.*;
import java.util.*;

public class P2667 {
    private static int[] dy = new int[]{-1,1,0,0};
    private static int[] dx = new int[]{0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> ans = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        boolean[][] visited= new boolean[n][n];
        for(int i =0;i<n;i++){
            char[] line = br.readLine().toCharArray();
            for(int j =0;j<n;j++) board[i][j] = line[j]-'0';
        }
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    ans.offer(bfs(board,visited,i,j));
                }
            }
        }
        bw.write(ans.size()+"\n");
        while(!ans.isEmpty()) bw.write(ans.poll()+"\n");

        br.close();
        bw.flush();
        bw.close();
    }
    private static int bfs(int[][] board, boolean[][] visited,int y,int x){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{y,x});
        visited[y][x] = true;
        int ans = 0;
        while(!que.isEmpty()){
            int[] cur = que.poll();
            ans ++;
            for(int i =0;i<4;i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(ny >= board.length || ny < 0 || nx >= board[0].length || nx < 0) continue;
                if(visited[ny][nx] || board[ny][nx] == 0) continue;
                visited[ny][nx] = true;
                que.offer(new int[]{ny,nx});
            }
        }
        return ans;
    }
}
