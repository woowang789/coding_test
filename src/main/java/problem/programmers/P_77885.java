package problem.programmers;

import java.util.Arrays;

public class P_77885 {
    static class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];
            for (int i=0;i< numbers.length;i++) {
                StringBuilder str = new StringBuilder(Long.toString(numbers[i], 2));
                int onePos = str.lastIndexOf("1"); // 마지막 1
                int zeroPos = str.lastIndexOf("0"); // 마지막 0
                if(onePos < zeroPos) { // 10 인 상황
                    str.replace(zeroPos, zeroPos + 1, "1");
                }else{
                    int oneP = str.indexOf("1");
                    if(zeroPos == -1) // 111 인 상황
                        str.insert(0,"1").replace(oneP+1, oneP + 2, "0");
                    else { // 1011 인 상황 -> 1101
                        int oneIdx = str.indexOf("1", zeroPos + 1);
                        str.replace(zeroPos, zeroPos + 1, "1").replace(oneIdx, oneIdx + 1, "0");
                    }
                }
                answer[i] = Long.parseLong(str.toString(), 2);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long[] solution = sol.solution(new long[]{2, 7});
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));

    }
}
