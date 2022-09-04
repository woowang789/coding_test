package problem.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_17677 {
    static class Solution {
        public int solution(String str1, String str2) {
            int answer = 0;
            Map<String, Integer> map1 = makeMap(str1);
            Map<String, Integer> map2 = makeMap(str2);

            Set<String> same = new HashSet<>(map1.keySet());
            same.retainAll(map2.keySet());

            Set<String> all = new HashSet<>(map1.keySet());
            all.addAll(map2.keySet());

            int a= 0;
            for (String s : same)
                a += Math.min(map1.get(s), map2.get(s));
            int b = 0;
            for (String s : all) {
                if(same.contains(s)){
                    b+= Math.max(map1.get(s), map2.get(s));
                }else{
                    if(map1.containsKey(s)) b += map1.get(s);
                    else if(map2.containsKey(s)) b += map2.get(s);
                }
            }
            if(b==0) return 65536;
            return a * 65536 / b;

        }

        private Map<String, Integer> makeMap(String str) {
            Map<String, Integer> map = new HashMap<>();
            int idx = 0;
            while (idx + 1 < str.length()) {
                char a = str.charAt(idx);
                char b = str.charAt(idx + 1);
                if(Character.isAlphabetic(a) && Character.isAlphabetic(b)){
                    String target = (Character.toUpperCase(a) + "") + (Character.toUpperCase(b) + "");
                    map.put(target, map.getOrDefault(target, 0) + 1);
                }
                idx++;
            }

            return map;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("aa1+aa2","AAAA12"));
    }
}
