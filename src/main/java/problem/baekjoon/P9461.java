package problem.baekjoon;

import java.io.*;

public class P9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] memo = new long[101];
        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;
        int n = Integer.parseInt(br.readLine());
        for(int i =0;i<n;i++){
            int t = Integer.parseInt(br.readLine());
            bw.write(solve(memo,t)+"\n");
        }


        br.close();
        bw.flush();
        bw.close();
    }
    private static long solve(long[] memo,int target){
        if(memo[target] != 0) return memo[target];
        return memo[target] = solve(memo,target-3) + solve(memo,target-2);
    }
}
