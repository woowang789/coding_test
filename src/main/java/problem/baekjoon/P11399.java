package problem.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        String[] line = br.readLine().split(" ");
        for(int i =0;i<n;i++) queue.offer(Integer.parseInt(line[i]));
        int ans = 0;
        int time = 0;
        while(!queue.isEmpty()){
            int t= queue.poll();
            ans += t + time;
            time += t;
        }
        System.out.println(ans);
        br.close();
    }
}
