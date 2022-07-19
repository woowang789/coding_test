package problem.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2606 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        int[][] edge = new int[n][n];
        boolean[] visited= new boolean[n];
        for(int i = 0;i<count;i++){
            String[] token = br.readLine().split(" ");
            int a = Integer.parseInt(token[0])-1;
            int b = Integer.parseInt(token[1])-1;
            edge[a][b] = 1;
            edge[b][a] = 1;
        }
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        visited[0] = true;
        int ans = 0;
        while(!que.isEmpty()){
            int cur = que.poll();

            for(int i =0;i<n;i++){
                if(visited[i] || edge[cur][i] == 0) continue;
                visited[i] = true;
                que.offer(i);
                ans++;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
