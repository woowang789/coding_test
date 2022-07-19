package problem.baekjoon;

import java.io.*;
import java.util.Arrays;

public class P1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i =0;i<n;i++){
            String[] token = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(token[0]);
            arr[i][1] = Integer.parseInt(token[1]);
        }
        Arrays.sort(arr,(o1, o2) -> {
            if(o1[1] != o2[1]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        int ans = 0;
        int idx = 0;
        int cur = 0;
        while(idx < arr.length){
            int[] target = arr[idx];
            if(cur <= target[0]) {
                cur = target[1];
                ans++;
            }
            idx++;
        }
        System.out.println(ans);
        br.close();
    }
}
