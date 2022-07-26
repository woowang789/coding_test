package problem.baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class P18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<Long> set = new HashSet<>();
        Map<Long,Integer> idxMap = new HashMap<>();
        long[] arr = new long[n];
        String[] token = br.readLine().split(" ");
        for (int i=0;i<n;i++) {
            long num = Long.parseLong(token[i]);
            set.add(num);
            arr[i] = num;
        }
        List<Long> collect = set.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) idxMap.put(collect.get(i), i);
        for (long i : arr) bw.write(idxMap.get(i)+" ");

        br.close();
        bw.flush();
        bw.close();
    }
}
