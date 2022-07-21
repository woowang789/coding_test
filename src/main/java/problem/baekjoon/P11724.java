package problem.baekjoon;

import java.io.*;
import java.util.*;

public class P11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] token = br.readLine().split(" ");
        int nodes = Integer.parseInt(token[0]);
        int edges = Integer.parseInt(token[1]);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] arr = new int[nodes];
        for(int i = 0;i<nodes;i++) {
            map.put(i,new ArrayList<>());
            arr[i] = i;
        }

        for(int i =0;i<edges;i++){
            int[] t = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map.get(t[0]-1).add(t[1]-1);
            map.get(t[1]-1).add(t[0]-1);
        }
        for(int i=0;i<nodes;i++){
            Queue<Integer> que = new LinkedList<>(map.get(i));
            while(!que.isEmpty()){
                int cur = que.poll();
                if(arr[i] == arr[cur]) continue;
                arr[i] = arr[cur] = Math.min(i,cur);
                for(int t : map.get(cur)){
                    if(arr[i] == arr[t]) continue;
                    que.add(t);
                }
            }
        }
        int length = Arrays.stream(arr).distinct().toArray().length;
        System.out.println(length);
    }
}
