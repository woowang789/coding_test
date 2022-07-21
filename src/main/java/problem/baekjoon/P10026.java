package problem.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P10026 {
    private static int[] dy = new int[]{-1,1,0,0};
    private static int[] dx = new int[]{0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        for(int i =0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<n;j++) board[i][j] = line.charAt(j);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    ans++;
                    bfs(board,visited,i,j,true);
                }
            }
        }
        sb.append(ans+" ");
        ans = 0;
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    ans++;
                    bfs(board,visited,i,j,false);
                }
            }
        }
        sb.append(ans+"\n");
        System.out.println(sb.toString());
        br.close();
    }

    private static void bfs(char[][] board,boolean[][] visited,int y,int x,boolean flag){
        Queue<int[]> que = new LinkedList<>();
        char target = board[y][x];
        visited[y][x] = true;
        que.offer(new int[]{y,x});
        while(!que.isEmpty()){
            int[] cur = que.poll();

            for(int i=0;i<4;i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if(ny >= board.length || nx >= board.length || ny < 0 || nx < 0) continue;
                if(visited[ny][nx])continue;

                if(flag){ // 정상인
                    if(board[ny][nx] == target){
                        visited[ny][nx] =true;
                        que.offer(new int[]{ny,nx});
                    }
                }else{ // 적녹 색약
                    if((board[ny][nx] == 'G' || board[ny][nx] == 'R') && (target == 'G' ||target == 'R')){
                        visited[ny][nx] =true;
                        que.offer(new int[]{ny,nx});
                    }else if(board[ny][nx] == 'B' && target == 'B'){
                        visited[ny][nx] =true;
                        que.offer(new int[]{ny,nx});
                    }
                }
            }
        }
    }
}
