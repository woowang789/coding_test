package problem.programmers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P_42890 {
    static class Solution {
        Map<String, Boolean> cand;
        Map<String, String> rowMap;
        public int solution(String[][] relation) {
            cand = new HashMap<>();
            rowMap = new HashMap<>();
            int answer = 0;
            setUpCand(0, new StringBuilder());
            for (String[] strings : relation) setUpRowMap(strings, 0, new StringBuilder(), new StringBuilder());

            List<String> collect = cand.entrySet().stream()
                    .filter(i -> i.getValue()).map(Map.Entry::getKey)
                    .sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
            int idx = 0;
            while (idx < collect.size()) {
                while (idx + 1 < collect.size() && collect.get(idx+1).startsWith(collect.get(idx))) {
                    collect.remove(idx + 1);
                }
                idx++;
            }
            System.out.println("collect = " + collect);
            return collect.size();
        }
        private void setUpRowMap(String[] r , int idx,StringBuilder key,StringBuilder val){
            if(idx == 4){
                if (key.length()!=0) {
                    if (rowMap.containsKey(key.toString())) {
                        cand.put(val.toString(), false);
                        return;
                    }
                    rowMap.put(key.toString(), val.toString());
                }
                return;
            }
            setUpRowMap(r, idx + 1, key, val);

            String t = r[idx];
            key.append(t).append(",");
            val.append(idx);
            setUpRowMap(r, idx + 1, key, val);
            key.delete(key.length() - t.length()-1, key.length());
            val.deleteCharAt(val.length() - 1);
        }

        private void setUpCand(int idx, StringBuilder sb) {
            if(idx == 4){
                if(sb.length()!=0){
                    cand.put(sb.toString(), true);
                }
                return;
            }
            setUpCand( idx+1, sb);
            sb.append(Integer.toString(idx));
            setUpCand(idx+1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        new String[][]{ new String[]{"100","ryan","music","2"},new String[]{"200","apeach","math","2"},new String[]{"300","tube","computer","3"},new String[]{"400","con","computer","4"},new String[]{"500","muzi","music","3"},new String[]{"600","apeach","music","2"} }
        int solution = sol.solution(new String[][]{
                new String[]{"100", "ryan", "music", "2"},
                new String[]{"200", "apeach", "math", "2"},
                new String[]{"300", "tube", "computer", "3"},
                new String[]{"400", "con", "computer", "4"},
                new String[]{"500", "muzi", "music", "3"},
                new String[]{"600", "apeach", "music", "2"}}
        );
        System.out.println("solution = " + solution);
    }
}
