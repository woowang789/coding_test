package problem.baekjoon;

import java.io.*;

public class P9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i =0;i<n;i++){
            int target = Integer.parseInt(br.readLine());
            bw.write(solve(target,0)+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
    private static int solve(int target, int cur){
        if(cur == target)return 1;
        int ret =0;
        for(int i = 1;i<4;i++){
            if(cur + i <= target){
                ret += solve(target,cur+i);
            }
        }
        return ret;
    }
}
