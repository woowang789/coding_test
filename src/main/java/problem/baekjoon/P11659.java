package problem.baekjoon;

import java.io.*;
import java.util.Arrays;

public class P11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] token = br.readLine().split(" ");
        int n = Integer.parseInt(token[0]);
        int round = Integer.parseInt(token[1]);

        int[] arr = new int[n];
        String[] line = br.readLine().split(" ");
        for(int i =0;i<n;i++){
            int num = Integer.parseInt(line[i]);
            if(i==0) arr[i] = num;
            else arr[i] = arr[i-1]+num;
        }
        for(int i=0;i<round;i++){
            int[] t = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int startIdx = t[0]-2;
            int endIdx = t[1]-1;
            int ans = startIdx<0? arr[endIdx]:arr[endIdx]-arr[startIdx];
            bw.write(ans+"\n");
        }

        br.close();bw.close();
        bw.close();
    }
}
