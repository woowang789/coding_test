package problem.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int[] memo = new int[target+1];
        Arrays.fill(memo,Integer.MAX_VALUE);
        memo[0] = 0;
        System.out.println(solve(memo,target));

        br.close();
    }
    private static int solve(int[] memo,int target){
        if(memo[target] != Integer.MAX_VALUE) return memo[target];
        int sqrt = (int) Math.sqrt(target);
        int min = Integer.MAX_VALUE;
        for(int i =sqrt;i>=1;i--){
            min = Math.min(min,solve(memo,target-i*i)+1);
        }
        return memo[target] = min;
    }
}
