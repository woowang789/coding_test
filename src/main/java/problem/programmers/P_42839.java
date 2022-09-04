package problem.programmers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_42839 {
    static class Solution {
        static Set<Integer> set;
        public int solution(String numbers) {
            set = new HashSet<>();
            int answer = 0;
            solve(numbers, new boolean[numbers.length()], new StringBuilder());
            for (Integer integer : set) {
                if(isPrime(integer)) answer++;

            }
            return answer;
        }

        private void solve(String number, boolean[] visited, StringBuilder sb) {
            if(sb.length()>=1)
                set.add(Integer.parseInt(sb.toString()));

            for (int i = 0; i < visited.length; i++) {
                if(!visited[i]){
                    visited[i] = true;
                    sb.append(number.charAt(i)+"");
                    solve(number, visited, sb);
                    sb.deleteCharAt(sb.length() - 1);
                    visited[i] = false;
                }
            }
        }

        private boolean isPrime(int num) {
            if(num <= 1) return false;
            int sqrt = (int) Math.sqrt(num);
            for (int i = 2; i <= sqrt; i++) {
                if(num%i == 0) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution("71");
        System.out.println(solution);

    }
}
