package problem.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++)
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans = Integer.MAX_VALUE;

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, solve(arr, dp, n-1, i));
        }
        System.out.println(ans);


        br.close();
    }
    private static int solve(int[][] arr,int[][] dp,int depth,int color ){
        if(dp[depth][color] == 0){

            if(color == 0){
                dp[depth][color] = Math.min(solve(arr,dp,depth-1,1),solve(arr,dp,depth-1,2)) + arr[depth][color];
            }else if(color == 1){
                dp[depth][color] = Math.min(solve(arr,dp,depth-1,0),solve(arr,dp,depth-1,2))+ arr[depth][color];
            }else{
                dp[depth][color] = Math.min(solve(arr,dp,depth-1,0),solve(arr,dp,depth-1,1))+ arr[depth][color];
            }

        }
        return dp[depth][color];
    }
}
