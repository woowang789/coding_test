package problem.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_68645 {
    static class Solution {
        List<List<Integer>> list;
        public int[] solution(int n) {
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) list.add(new ArrayList<>());
            solve(n, 0, 1);
//            for (List<Integer> integers : list) {
//                System.out.println(integers);
//            }
            return list.stream().flatMap(o -> o.stream()).mapToInt(Integer::intValue).toArray();
        }

        private void solve(int len, int y,int num) {
            int tmp = num;
            if(len <= 0) return;
            for (int i = 0; i <= len-1; i++)
                list.get(y + i).add(num++);
            for (int i = 1; i < len - 1; i++) {
                list.get(y + len - 1).add(num++);
            }
            solve(len - 3, y + 2, len * 3 - 3+tmp);
            for (int i = len - 1; i >= 1; i--) {
                list.get(y + i).add(num++);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(4);
        System.out.println(Arrays.toString(solution));

    }
}
