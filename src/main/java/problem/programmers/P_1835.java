package problem.programmers;

public class P_1835 {
    static class Solution {
        static char[] arr = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        static int answer;
        public int solution(int n, String[] data) {
            answer = 0;
            solve(new boolean[8], data, new StringBuilder());
            return answer;
        }

        private void solve(boolean[] visited, String[] data, StringBuilder sb) {
            if(sb.length()==8 && check(sb,data)) {
                answer++;
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    sb.append(arr[i]);
                    solve(visited, data, sb);
                    sb.deleteCharAt(sb.length() - 1);
                    visited[i] = false;
                }
            }
        }
        private boolean check(StringBuilder sb, String[] data) {
            for (String datum : data) {
                String a = datum.charAt(0)+"";
                String b = datum.charAt(2)+"";
                char oper = datum.charAt(3);

                int value = Integer.parseInt(datum.charAt(4)+"");

                int aIdx = sb.indexOf(a);
                int bIdx = sb.indexOf(b);

                int result = Math.abs(aIdx - bIdx)-1;

                if(oper == '=' && value != result) return false;
                else if(oper == '>' && result <= value) return false;
                else if(oper == '<' && result >= value) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(2, new String[]{"N~F=0", "R~T>2"});
        System.out.println(solution);
    }
}
