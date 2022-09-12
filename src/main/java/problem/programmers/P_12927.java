package problem.programmers;

import java.util.Arrays;

public class P_12927 {
    static class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;
            Arrays.sort(works);
            int maxWork = works[works.length - 1];
            int[] leftWork = new int[maxWork + 1];
            for (int i : works) leftWork[i]++;
            while (maxWork > 0 && n > 0) {
                if(leftWork[maxWork] == 0) maxWork--;
                else if(leftWork[maxWork] < n){
                    leftWork[maxWork - 1] += leftWork[maxWork];
                    n -= leftWork[maxWork];
                    leftWork[maxWork] = 0;
                }else{
                    leftWork[maxWork - 1] += n;
                    leftWork[maxWork] -= n;
                    n =0;
                }
            }
            for (int i = 0; i < leftWork.length; i++)
                answer += leftWork[i] * Math.pow(i, 2);
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long solution = sol.solution(4, new int[]{4, 3, 3});
        System.out.println("solution = " + solution);
    }
}
