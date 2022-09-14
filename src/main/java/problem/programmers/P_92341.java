package problem.programmers;

import java.util.*;

public class P_92341 {
    static class Solution {
        Map<Integer, Integer> priceMap;
        Map<Integer, Integer> timeMap;
        public int[] solution(int[] fees, String[] records) {
            priceMap = new HashMap<>();
            timeMap = new HashMap<>();
            List<Integer> answer = new ArrayList<>();
            for (String record : records) {
                String[] s = record.split(" ");
                int time = convertTime(s[0]);
                int num = Integer.parseInt(s[1]);
                if(timeMap.containsKey(num)){
                    priceMap.put(num, priceMap.getOrDefault(num, 0) + time - timeMap.get(num));
                    timeMap.remove(num);
                } else timeMap.put(num, time);
            }
            int fullTime = 60 * 23 + 59;
            for (Integer integer : timeMap.keySet())
                priceMap.put(integer, priceMap.getOrDefault(integer, 0) + fullTime - timeMap.get(integer));
            System.out.println("priceMap = " + priceMap);
            priceMap.entrySet().stream().sorted((o1, o2) -> o1.getKey()-o2.getKey())
                    .forEach(i ->{
                        if(i.getValue() <= fees[0]) answer.add(fees[1]);
                        else{
                            int price = fees[1];
                            price += Math.ceil((float)(i.getValue() - fees[0]) / fees[2]) * fees[3];
                            answer.add(price);
                        }
                    });
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }

        private int convertTime(String str) {
            String[] split = str.split(":");
            return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(
                new int[]{120, 0, 60, 591},
                new String[]{
                        "16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"
                });
        System.out.println(Arrays.toString(solution));
    }
}
