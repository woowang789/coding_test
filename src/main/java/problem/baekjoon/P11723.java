package problem.baekjoon;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class P11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String[] token = br.readLine().split(" ");
            String cmd = token[0];
            int num =0;
            if(!(cmd.equals("all") || cmd.equals("empty"))) num = Integer.parseInt(token[1]);
            switch (cmd){
                case "add":
                    set.add(num);
                    break;
                case "remove":
                    set.remove(num);
                    break;
                case "check":
                    bw.write((set.contains(num)?1:0)+"\n");
                    break;
                case "toggle":
                    if(set.contains(num)) set.remove(num);
                    else set.add(num);
                    break;
                case "all":
                    for(int k =1;k<21;k++) set.add(k);
                    break;
                case "empty":
                    set = new HashSet<>();
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
