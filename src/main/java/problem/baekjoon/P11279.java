package problem.baekjoon;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class P11279 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int cmd = Integer.parseInt(br.readLine());
            if(cmd == 0) bw.write((que.isEmpty()?"0":que.poll())+"\n");
            else que.offer(cmd);
        }
        br.close();
        bw.flush();
        bw.close();
    }
}