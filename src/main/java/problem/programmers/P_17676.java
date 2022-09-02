package problem.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P_17676 {
    static class Solution {
        public int solution(String[] lines) {
            int answer = 0;
            List<int[]> arr = new ArrayList<>();
            for (String line : lines) {
                String[] a = line.split(" ");
                String t = a[1];
                String[] time = t.split(":");
                int h = Integer.parseInt(time[0]) * 60 * 60 * 1000;
                int min = Integer.parseInt(time[1]) * 60 * 1000;
                String[] s = time[2].split("\\.");
                int sec = Integer.parseInt(s[0]) * 1000 + Integer.parseInt(s[1]);

                String[] tmp = a[2].substring(0, a[2].length() - 1).split("\\.");
                int d = Integer.parseInt(tmp[0]) * 1000;
                if(tmp.length>1) d += Integer.parseInt(tmp[1]);
                int target = h + min + sec ;
                arr.add(new int[]{target - d + 1, target});
            }
            arr.sort((o1, o2) -> o1[1] - o2[1]);
            for (int[] ints : arr) {
                System.out.println(Arrays.toString(ints));
            }

            for (int i = 0; i < arr.size(); i++) {
                int[] std = arr.get(i);
                int tmp = 1;
                for (int j = i + 1; j < arr.size(); j++) {
                    int[] t = arr.get(j);
                    if(std[1]+1000 > t[0]) tmp++;
                }
                answer = Math.max(tmp,answer);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(
                new String[]{
                        "2016-09-15 20:59:57.421 0.351s",
                        "2016-09-15 20:59:58.233 1.181s",
                        "2016-09-15 20:59:58.299 0.8s",
                        "2016-09-15 20:59:58.688 1.041s",
                        "2016-09-15 20:59:59.591 1.412s",
                        "2016-09-15 21:00:00.464 1.466s",
                        "2016-09-15 21:00:00.741 1.581s",
                        "2016-09-15 21:00:00.748 2.31s",
                        "2016-09-15 21:00:00.966 0.381s",
                        "2016-09-15 21:00:02.066 2.62s"
                }
        ));
    }
}
