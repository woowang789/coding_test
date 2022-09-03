package problem.programmers;

public class P_62048 {
    static class Solution {
        public long solution(int w, int h) {
            long answer = (long) w * h;
            long tmp = 0;
            double prevH =0;
            for (int i = 1; i <= w; i++) {
                double curH = (double)h*i / (double)w ;
                tmp += Math.ceil(curH) - Math.floor(prevH);
                prevH = curH;
            }
            return answer - tmp;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(8, 12));
    }
}
