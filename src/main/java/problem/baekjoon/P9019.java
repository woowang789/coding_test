package problem.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class P9019 {
    static class Step{
        String str="";
        int val;

        public Step(String str,int val) {
            this.str = str;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i =0;i<n;i++){
            String[] token = br.readLine().split(" ");
            int cur = Integer.parseInt(token[0]);
            int target = Integer.parseInt(token[1]);
            boolean[] visited = new boolean[10000];


            Queue<Step> que = new LinkedList<>();
            visited[cur] = true;
            que.offer(new Step("",cur));
            while(!que.isEmpty()){
                Step poll = que.poll();
                if(poll.val == target){
                    bw.write(poll.str+"\n");
                    break;
                }
                int d = D(poll.val);
                if(!visited[d]){
                    visited[d] = true;
                    que.offer(new Step(poll.str+"D", d));
                }
                int s = S(poll.val);
                if(!visited[s]){
                    visited[s] = true;
                    que.offer(new Step(poll.str+"S", s));
                }
                int l = L(poll.val);
                if(!visited[l]){
                    visited[l]= true;
                    que.offer(new Step(poll.str+"L", l));
                }
                int r = R(poll.val);
                if(!visited[r]){
                    visited[r] = true;
                    que.offer(new Step(poll.str+"R", r));
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static int D (int a){
        return a*2%10000;
    }
    private static int S(int a){
        return a==0?9999:a-1;
    }
    private static int L(int a){
        return a%1000 * 10 + a/1000;
    }
    private static int R(int a){
        return a%10*1000 + a/10;
    }
}
