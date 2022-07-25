package problem.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        System.out.println(solve(memo,n));

    }
    private static int solve(int[] memo,int cur){
        if(memo[cur] != 0) return memo[cur];
        memo[cur] = solve(memo,cur-1);
        if(cur>=2) memo[cur]+= solve(memo,cur-2);
        return memo[cur] = (solve(memo,cur-1) + solve(memo,cur-2))%10007;
    }
}
