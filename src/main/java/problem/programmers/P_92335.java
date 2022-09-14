package problem.programmers;

public class P_92335 {
    static class Solution {
        public int solution(int n, int k) {
            String str = Integer.toString(n, k);
            int answer = 0;
            int idx = 0;
            while (idx < str.length()) {
                if(str.charAt(idx) != '0'){
                    int tmp = idx;
                    while (tmp + 1 < str.length() && str.charAt(tmp + 1) != '0') {
                        tmp++;
                    }
                    if (isPrime(str.substring(idx, tmp + 1))) answer++;
                    idx = tmp;
                }
                idx++;
            }
            return answer;
        }

        private boolean isPrime(String str) {
            long num = Long.parseLong(str);
            if(num < 2) return false;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 437674;
        int solution = sol.solution(n, 3);
        System.out.println("solution = " + solution);
    }
}
