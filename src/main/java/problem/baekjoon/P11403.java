package problem.baekjoon;

import java.io.*;
import java.util.*;

public class P11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Set<Integer>> map = new HashMap<>();
        boolean[][] visited = new boolean[n][n];
        for(int i =0;i<n;i++)map.put(i,new HashSet<>());
        for(int i =0;i<n;i++){
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<n;j++){
                if(line[j] == 1)
                    map.get(i).add(j);
            }
        }
        for(int i =0;i<n;i++){
            Set<Integer> set = map.get(i);
            Queue<Integer> que = new LinkedList<>(set);
            while(!que.isEmpty()){
                int cur = que.poll();
                visited[i][cur] = true;

                for(int t : map.get(cur)){
                    if(!visited[i][t]){
                        visited[i][t] = true;
                        que.offer(t);
                    }
                }
            }
        }
        for(boolean[] line : visited){
            for(boolean l : line){
                bw.write((l?1:0)+" ");
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
