package problem.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        while(idx < arr.length){
            int t= 0;
            while(idx+2 < arr.length && arr[idx]=='I' && arr[idx+1]=='O' && arr[idx+2]=='I'){
                t++;
                idx+=2;
            }
            if(t != 0) list.add(t);
            idx++;
        }
        int ans = 0;
        for(int i : list) if(i - (n-1) > 0) ans+= i-(n-1);

        System.out.println(ans);

        br.close();
    }
}
