package problem.baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class P9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i =0;i<n;i++){
            int type = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int j = 0;j<type;j++){
                String[] token = br.readLine().split(" ");
                map.put(token[1],map.getOrDefault(token[1],0)+1);
            }
            int ans = 1;
            for(int val : map.values()){
                ans *= (val+1);
            }
            bw.write((ans-1)+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
