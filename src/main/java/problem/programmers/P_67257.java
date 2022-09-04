package problem.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class P_67257 {
    static class Solution {
        static List<Long> numList;
        static List<Character> operList;

        public long solution(String expression) {
            numList = new ArrayList<>();
            operList = new ArrayList<>();
            getList(expression);

            List<Character> operDist = operList.stream().distinct().collect(Collectors.toList());

            return operOrder(operDist, new boolean[operDist.size()], new ArrayList<>());
        }

        private long operOrder(List<Character> oeprDistinct, boolean[] visited, List<Character> order) {
            if (order.size() == oeprDistinct.size()) {
                return solve(order);
            }
            long ret = 0;
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    order.add(oeprDistinct.get(i));
                    ret = Math.max(operOrder(oeprDistinct, visited, order), ret);
                    order.remove(order.size() - 1);
                    visited[i] = false;
                }
            }
            return ret;
        }

        private long solve(List<Character> order) {
            List<Long> newNum = new ArrayList<>(numList);
            List<Character> newOper = new ArrayList<>(operList);
            for (char oper : order) {
                int idx = 0;
                while (idx < newOper.size()) {
                    if(oper != newOper.get(idx)) {
                        idx++;
                        continue;
                    }

                    if (oper == '*') {
                        newNum.set(idx, newNum.get(idx) * newNum.get(idx + 1));
                    } else if (oper == '+') {
                        newNum.set(idx, newNum.get(idx) + newNum.get(idx + 1));
                    }else{
                        newNum.set(idx, newNum.get(idx) - newNum.get(idx + 1));
                    }

                    newNum.remove(idx + 1);
                    newOper.remove(idx);
                }
            }
            return Math.abs(newNum.get(0));
        }

        private void getList(String expression) {
            int idx = 0;
            while (idx < expression.length()) {
                int tmp = idx;
                while (tmp < expression.length() && Character.isDigit(expression.charAt(tmp)))
                    tmp++;
                numList.add(Long.parseLong(expression.substring(idx, tmp)));
                if (tmp < expression.length())
                    operList.add(expression.charAt(tmp));
                idx = tmp + 1;
            }
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("100-200*300-500+20"));
    }
}
