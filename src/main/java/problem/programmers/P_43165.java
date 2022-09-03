package problem.programmers;

public class P_43165 {
    static class Solution {
        public int solution(int[] numbers, int target) {
            return solve(numbers, target, 0, 0);
        }

        private int solve(int[]numbers, int target,int idx,int result){
            if (idx == numbers.length)
                return target == result ? 1 : 0;

            int ret= 0 ;
            ret += solve(numbers, target, idx + 1, result + numbers[idx]);
            ret += solve(numbers, target, idx + 1, result - numbers[idx]);

            return ret;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{4, 1, 2, 1}, 2));
    }
}
