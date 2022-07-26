package problem.baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class P17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] token = br.readLine().split(" ");
        int nSite = Integer.parseInt(token[0]);
        int nProb = Integer.parseInt(token[1]);
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < nSite; i++) {
            String[] line = br.readLine().split(" ");
            map.put(line[0], line[1]);
        }
        for (int i = 0; i < nProb; i++) {
            String prob = br.readLine();
            bw.write(map.get(prob) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
