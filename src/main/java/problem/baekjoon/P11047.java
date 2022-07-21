package problem.baekjoon;

import java.io.*;

public class P11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int n = Integer.parseInt(token[0]);
        int target = Integer.parseInt(token[1]);
        int[] coins = new int[n];
        for(int i =n-1;i>=0;i--) coins[i] = Integer.parseInt(br.readLine());
        int ret = solve(coins, target);
        System.out.println(ret);
        br.close();
    }
    private static int solve(int[] coins, int target){
        if(target == 0) return 0;
        int ret = Integer.MAX_VALUE;
        for(int i =0;i < coins.length;i++){
            if(target >= coins[i]) {
                int t = target/coins[i];
                int a = solve(coins, target%coins[i]) + t;
                if(a != Integer.MAX_VALUE) return a;
            }
        }
        return ret;
    }
}
