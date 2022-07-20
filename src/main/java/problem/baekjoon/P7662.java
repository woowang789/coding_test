package problem.baekjoon;

import java.io.*;
import java.util.*;

public class P7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int round = Integer.parseInt(br.readLine());
        for(int i =0;i<round;i++){
            int count = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minQue = new PriorityQueue<>();
            Map<Integer,Integer> map = new HashMap<>();

            for(int j=0;j<count;j++){
                String[] token = br.readLine().split(" ");
                if(token[0].equals("I")){
                    int target = Integer.parseInt(token[1]);
                    maxQue.offer(target);
                    minQue.offer(target);

                    map.put(target,map.getOrDefault(target,0)+1);
                } else{
                    if(map.size()==0) continue;

                    int target = Integer.parseInt(token[1]);
                    PriorityQueue<Integer> que = target==1?maxQue:minQue;
                    delete(que,map);
                }
            }
            if(map.size() == 0) bw.write("EMPTY\n");
            else{
                int n = delete(maxQue,map);
                bw.write(n+" "+(map.size()>0? delete(minQue,map):n)+"\n");
            }


        }
        br.close();
        bw.flush();
        bw.close();
    }
    private static int delete(PriorityQueue<Integer> queue,Map<Integer,Integer> map){
        int num;
        while(true){
            num = queue.poll();
            int cnt = map.getOrDefault(num,0);
            if(cnt == 0) continue;

            if(cnt == 1) map.remove(num);
            else map.put(num,cnt-1);
            break;
        }
        return num;
    }
}
