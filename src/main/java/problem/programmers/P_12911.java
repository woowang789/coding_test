package problem.programmers;

public class P_12911 {
    static class Solution {
        public int solution(int n) {
            String binary = Integer.toString(n, 2);
            int lastOnePos = binary.lastIndexOf("1");
            int lastZeroPos = lastOnePos-1;
            int oneCount = 0;

            while (lastZeroPos >= 0) {
                if(binary.charAt(lastZeroPos) == '0') break;
                else oneCount++;
                lastZeroPos--;
            }
            StringBuilder sb = new StringBuilder();
            if (lastZeroPos == -1) {
                sb.append("1");
                sb.append("0".repeat(binary.length() - oneCount));
                sb.append("1".repeat(oneCount));
            }else{
                sb.append(binary.substring(0,lastZeroPos));
                sb.append("1");
                sb.append("0".repeat(binary.length() - lastOnePos));
                sb.append("1".repeat(oneCount));
            }
            System.out.println(binary);
            System.out.println(sb);
            return Integer.parseInt(sb.toString(), 2);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(78);
        System.out.println("solution = " + solution);
    }
}
